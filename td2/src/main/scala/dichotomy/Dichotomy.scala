package dichotomy

import scala.annotation.tailrec

/**
 * Dichotomy Object.
 */
object Dichotomy {
  /**
   * Computes, if exists, a root for a given function
   * @param f A function
   * @param a Lower bound
   * @param b Higher bound
   * @param eps Precision
   * @return A approached root of function if exists, None otherwise
   */
  def apply(f: Double => Double, a: Double, b: Double, eps: Double): Option[Double] = {
    if (f(a) * f(b) > 0) None /* function f does not admit any root */
    else if (b - a <= eps) Some(a) // or Some(b)
    else {
      val c: Double = (a + b) / 2 /* Interval's middle */
      if ((math.abs(b - a) < eps) || ((f(c) == 0.0))) /* Precision degree reached */
        Some(c)
      else
        if (f(a) * f(c) < 0) apply(f, a, c, eps) else apply(f, c, b, eps)
    }
  }
}
