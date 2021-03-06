package org.specs2
package reporter

import execute.Details
import io.MockOutput

trait ConsoleNotifier extends Notifier {
  def specStart(title: String, location: String)                                                                      = Console.println(Seq("specStart"     ,title  ,location)                       .mkString(": "))
  def specEnd(title: String, location: String)                                                                        = Console.println(Seq("specEnd"       ,title  ,location)                       .mkString(": "))
  def contextStart(text: String, location: String)                                                                    = Console.println(Seq("contextStart"  ,text   ,location)                       .mkString(": "))
  def contextEnd(text: String, location: String)                                                                      = Console.println(Seq("contextEnd"    ,text   ,location)                       .mkString(": "))
  def text(text: String, location: String)                                                                            = Console.println(Seq("text"          ,text   ,location)                       .mkString(": "))
  def exampleStarted(name: String, location: String)                                                                  = Console.println(Seq("exampleStarted",name   ,location)                       .mkString(": "))
  def exampleSuccess(name: String, duration: Long)                                                                    = Console.println(Seq("exampleSuccess",name   ,duration)                       .mkString(": "))
  def exampleFailure(name: String, message: String, location: String, f: Throwable, details: Details, duration: Long) = Console.println(Seq("exampleFailure",name   , message,location,f.getMessage, details, duration).mkString(": "))
  def exampleError  (name: String, message: String, location: String, f: Throwable, duration: Long)                   = Console.println(Seq("exampleError"  ,name   , message,location,f.getMessage, duration).mkString(": "))
  def exampleSkipped(name: String, message: String, duration: Long)                                                   = Console.println(Seq("exampleSkipped",name   , message,duration)                       .mkString(": "))
  def examplePending(name: String, message: String, duration: Long)                                                   = Console.println(Seq("examplePending",name   , message,duration)                       .mkString(": "))
}
object ConsoleNotifier extends ConsoleNotifier

trait MessagesNotifier extends Notifier with MockOutput {
  def specStart(title: String, location: String)                                                                      = println(Seq("specStart"     ,title  ,location)                       .mkString(": "))
  def specEnd(title: String, location: String)                                                                        = println(Seq("specEnd"       ,title  ,location)                       .mkString(": "))
  def contextStart(text: String, location: String)                                                                    = println(Seq("contextStart"  ,text   ,location)                       .mkString(": "))
  def contextEnd(text: String, location: String)                                                                      = println(Seq("contextEnd"    ,text   ,location)                       .mkString(": "))
  def text(text: String, location: String)                                                                            = println(Seq("text"          ,text   ,location)                       .mkString(": "))
  def exampleStarted(name: String, location: String)                                                                  = println(Seq("exampleStarted",name   ,location)                       .mkString(": "))
  def exampleSuccess(name: String, duration: Long)                                                                    = println(Seq("exampleSuccess",name   ,duration)                       .mkString(": "))
  def exampleFailure(name: String, message: String, location: String, f: Throwable, details: Details, duration: Long) = println(Seq("exampleFailure",name   , message,location,f.getMessage, details, duration).mkString(": "))
  def exampleError  (name: String, message: String, location: String, f: Throwable, duration: Long)                   = println(Seq("exampleError"  ,name   , message,location,f.getMessage, duration).mkString(": "))
  def exampleSkipped(name: String, message: String, duration: Long)                                                   = println(Seq("exampleSkipped",name   , message,duration)                       .mkString(": "))
  def examplePending(name: String, message: String, duration: Long)                                                   = println(Seq("examplePending",name   , message,duration)                       .mkString(": "))
}

object MessagesNotifier extends MessagesNotifier
