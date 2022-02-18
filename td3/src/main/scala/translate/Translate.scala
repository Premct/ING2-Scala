package translate

import scala.annotation.tailrec

object Translate {
  def level0(dict: Map[String, String], french: String): String = {
//    french.toLowerCase split ' ' map { dict(_) } mkString " " // version "no-check"
    french.toLowerCase split ' ' map { dict.getOrElse(_,"???")} mkString " "
  }
}
