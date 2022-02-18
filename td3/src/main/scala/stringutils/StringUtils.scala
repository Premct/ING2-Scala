package stringutils

object StringUtils {
  implicit class StringUtils(s: String) {
    val occurrences: Map[Char, Int] = {
      s groupBy identity map { case (c -> cs) => (c -> cs.length) }
      //      s groupMapReduce(identity){ _ => 1 }(_ + _)
      //      (s foldLeft Map.empty[Char, Int]) { case (m, c) => m + (c -> (m.getOrElse(c, 0) + 1)) }
    }

    def occurrencesByWord(sep: String = " "): Map[String, Int] = {
      s split sep groupBy identity map { case (c -> cs) => (c -> cs.length) }
    }
  }

  object SeqUtils {
    implicit class SeqUtils[T](seq: Seq[T]) {
      val occurrences: Map[T, Int] = (seq groupMapReduce identity) (_ => 1)(_ + _)
    }
  }
}
