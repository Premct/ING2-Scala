package rational

import scala.math.Ordered;

/**
 * Defines a rational number : a/b
 *
 * @param numerator   The numerator
 * @param denominator The denominator
 */
class Rational(val numerator: Int, val denominator: Int) extends Ordered[Rational] {
  /**
   * Gives the opposite of a Rational
   *
   * @return A Rational, as the opposite of a Rational
   */
  def unary_- : Rational = {
    Rational(numerator * (-1), denominator)
  }

  /**
   * Invert a Rational
   *
   * @return A Rational, as an inverted Rational
   */
  def inverse: Rational = {
    Rational(denominator, numerator)
  }

  /**
   * Adds two Rationals
   *
   * @param other A Rational
   * @return A Rational, as the sum of two Rationals
   */
  def +(other: Rational): Rational = {
    Rational((numerator * other.denominator) + (other.numerator * denominator), denominator * other.denominator)
  }

  /**
   * Subtracts two Rationals
   *
   * @param other A Rational
   * @return A Rational, as the subtraction of two Rationals
   */
  def -(other: Rational): Rational = {
    this + (-other)
  }

  /**
   * Gives the multiplication of two Rationals
   *
   * @param other A Rational
   * @return A Rational, as the multiplication of two Rationals
   */
  def *(other: Rational): Rational = {
    Rational(numerator * other.numerator, denominator * other.denominator)
  }

  /**
   * Gives the division of two Rationals
   *
   * @param other A Rational
   * @return A Rational, as the division of two Rationals
   */
  def /(other: Rational): Rational = {
    this * other.inverse
  }

  /**
   * Checks if two Rationals are equals
   *
   * @param other A Rational
   * @return True if the two Rationals are equals, false otherwise
   */
  def ==(other: Rational): Boolean = {
    (numerator == other.numerator) && (denominator == other.denominator)
  }

  /**
   * Compare two Rationals
   *
   * @param that A Rational
   * @return An Int, as the subtract of numerators multiplied by each other denominators
   */
  override def compare(that: Rational): Int = {
    (numerator * that.denominator) - (that.numerator * denominator)
  }

  /**
   * Checks if a Rational (instantiated) is less greater than another Rational (as parameter)
   *
   * @param that A Rational
   * @return True if a Rational (instantiated) is less greater than another Rational (as parameter), false otherwise
   */
  override def <(that: Rational): Boolean = {
    compare(that) < 0
  }

  /**
   * Checks if a Rational (instantiated) is greater than another Rational (as parameter)
   *
   * @param that A Rational
   * @return True if a Rational (instantiated) is greater than another Rational (as parameter), false otherwise
   */
  override def >(that: Rational): Boolean = {
    compare(that) > 0
  }

  /**
   * Checks if a Rational (instantiated) is less greater or equal than another Rational (as parameter)
   *
   * @param that A Rational
   * @return True if a Rational (instantiated) is less greater or equal than another Rational (as parameter), false otherwise
   */
  override def <=(that: Rational): Boolean = {
    !(>(that))
  }

  /**
   * Checks if a Rational (instantiated) is greater or equal than another Rational (as parameter)
   *
   * @param that A Rational
   * @return True if a Rational (instantiated) is greater or equal than another Rational (as parameter), false otherwise
   */
  override def >=(that: Rational): Boolean = {
    !(<(that))
  }

  /**
   * Format output to display a Rational
   *
   * @return A string
   */
  override def toString: String = {
    s"[RATIONAL]: $numerator/$denominator"
  }
}

/**
 * Companion object
 */
object Rational {
  /**
   * Instantiates a Rational with a numerator and a denominator
   *
   * @param numerator   The numerator
   * @param denominator The denominator
   * @return A Rational
   */
  def apply(numerator: Int, denominator: Int): Rational = new Rational(numerator, denominator);

  /**
   * Instantiates a Rational with a numerator only, e.g denominator equals 1
   *
   * @param numerator The numerator
   * @return A Rational, with 1 in place of denominator
   */
  def apply(numerator: Int): Rational = new Rational(numerator, 1);

  /** Zero constant: result of 0/1 */
  val zero: Rational = Rational(0, 1)

  /** One constant: result of 1/1 */
  val one: Rational = Rational(1, 1)

  /** Inf constant: result of 1/0 (impossible) */
  val inf: Rational = Rational(1, 0)
}
