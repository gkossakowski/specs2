package org.specs2
package io

import io.FileReader._
import io.Paths._
import control.Throwablex._
import main.SystemProperties

/**
 * Get source code from the current point of execution
 * 
 * * An important limitation is that only the content of one line will be returned *
 * 
 * The source dir is assumed to be "src/test/scala/" by default but this can be modified
 * by setting the "specs2.srcDir" System property
 *
 */
private[specs2]
trait FromSource {
  
  private[specs2] lazy val srcDir: String = SystemProperties.getOrElse("srcDir", "src/test/scala").dirPath

  /**
   * get some source code by:
   *   * fetching the current stacktrace
   *   * finding the location of the example (4th trace by default)
   */
  def getCode(depth: Int = 4): String = {
    val stackTrace = new Exception().getStackTrace()
    val trace = stackTrace.apply(depth)
    val location = new Location(trace)
    val content = readLines(srcDir+location.path)
    content(location.lineNumber - 1)
  }
}
private[specs2]
object FromSource extends FromSource