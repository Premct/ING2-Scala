package loop

import scala.annotation.tailrec

/**
 * Loop Object
 */
object Loop {
  /**
   * Applies n times a function
   * @param next A function
   * @param init Initial start value
   * @param times Number of iterations
   * @tparam T Parameter type
   * @return The of f(x) applied n times
   * @note This method is equivalent to mathematical expression f&#94;n(x)
   */
  @tailrec
  def fixed[T](next: T => T)(init: T, times: Int): T = {
    val x: T = init
    if (times <= 0) init else fixed(next)(next(init), times-1)
  }

  @tailrec
  def whilst[T](next : T => T)(cont : T => Boolean)(init : T): T = {
    if (!cont(init)) init else whilst(next)(cont)(next(init));
  }
}
