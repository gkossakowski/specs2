package org.specs2.text

import NotNullStrings._

/**
 * Quote and unquote strings
 *
 */
private[specs2] 
trait Quote {

  /** quote a value, unless it is a collection of objects */
  def q(a: Any) = {
    if (a == null) quote("null")
    else {
      a match {
        case ar: Array[_]           => ar.notNull
        case it: TraversableOnce[_] => it.notNull
        case _                      => quote(a.notNull)
      }
    }
  }

  /** quote a string */
  def quote(s: String, addQuotes: Boolean = true) = if (addQuotes) "'"+s+"'" else s

  /** @return an object.toString() without quotes (used in messages creation) */
  def unq(a: Any)  = a.notNull

  implicit def prefixed(s: String) = new Prefixed(s)
  class Prefixed(s: String) {
    def prefix(separator: String, other: String) = Seq(s, other).filter(_.nonEmpty).mkString(separator)
  }
}
private[specs2] object Quote extends Quote 