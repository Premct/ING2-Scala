package pi

import scala.annotation.tailrec
import scala.math.sqrt

object Pi {
  def pi(n: Int): Double = {
    @tailrec
    def piTR(n: Int, accumulator: => Double): Double = {
      println(accumulator)
      if (n == 0) accumulator else piTR(n - 1, accumulator+sqrt(6/(n*n)))
    }

    piTR(n, 0)
  }
}
