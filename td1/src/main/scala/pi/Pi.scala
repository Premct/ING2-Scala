package pi

import scala.annotation.tailrec
import scala.math.{pow, sqrt}
import scala.util.Random

/**
 * Pi approximations computing
 */
object Pi {
  /**
   * Approximation of pi using lim(n->+infinity) SUM(1, n) 1/n² = pi²/6
   *
   * @param n The number of iteration
   * @return A Double, as the result of Pi approximation
   * @note This is a pure function : a given entry return always the same result
   */
  def pi(n: Int): Double = {
    /**
     * Approximation of pi using lim(n->+infinity) SUM(1, n) 1/n² = pi²/6, recursive computing
     *
     * @param k           The number of iterations
     * @param accumulator A accumulator meant to store result of each iteration
     * @return A double as the approximation of (pi *pi)/6
     */
    @tailrec
    def piTR(k: Int, accumulator: Double): Double = {
      if (k == 0) accumulator else piTR(k - 1, accumulator + (1.0 / (k * k)))
    }

    sqrt(6 * piTR(n, 0))
  }

  /**
   * Approximation of pi using Monte-Carlo method
   *
   * @param n The number of iterations
   * @return A Double, as the approximation of pi
   * @note This is not a pure function : a given entry does not give always the same result : in fact here, random change the result
   */
  def piMC(n: Int): Double = {
    /**
     * Approximation of pi using Monte-Carlo method, recursive computing
     *
     * @param k           The number of iterations
     * @param accumulator A accumulator meant to store result of each iteration
     * @return A Double, as the approximation of 4(*pi)/n
     */
    @tailrec
    def piMCtr(k: Int, accumulator: Int): Int = {
      if (k == 0) accumulator else piMCtr(k - 1, accumulator + draw())
    }

    4.0 * piMCtr(n, 0) / n
  }

  /**
   * Draws two Double between 0 and and computes the sum of their squares
   *
   * @return 1 if the sum of their squares is less or equal to 1, 0 otherwise
   */
  private def draw(): Int = {
    val x = new Random()
    val y = new Random()

    val sum_square = pow(x.nextDouble(), 2) + pow(y.nextDouble(), 2)

    if (sum_square <= 1) 1 else 0
  }
}
