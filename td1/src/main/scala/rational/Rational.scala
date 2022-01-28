package rational

import scala.annotation.tailrec
import scala.math.Ordered;

/**
 * Defines a rational number : a/b
 *
 * @param numerator   The numerator
 * @param denominator The denominator
 * @note Rational(val numerator: Int, val denominator: Int = 1) allows building the two asked constructors
 */
class Rational(numerator: Int, denominator: Int) extends Ordered[Rational] {

  /* import statics */

  import Rational._

  private val d = gcd(numerator, denominator)
  val num: Int = numerator / d
  val den: Int = denominator / d

  lazy val unary_- : Rational = Rational(-num, den)
  lazy val inverse: Rational = Rational(den, num)

  /**
   * Adds two Rationals
   *
   * @param other A Rational
   * @return A Rational, as the sum of two Rationals
   */
  def +(other: Rational): Rational = {
    Rational((num * other.den) + (other.num * den), den * other.den)
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
    Rational(num * other.num, den * other.den)
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
    (this compare other) == 0
  }

  /**
   * Compare two Rationals
   *
   * @param that A Rational
   * @return An Int, as the subtract of numerators multiplied by each other denominators
   */
  override def compare(that: Rational): Int = {
    (num * that.den) - (that.num * den) * den * that.den
  }

  /**
   * Format output to display a Rational
   *
   * @return A string
   */
  override def toString: String = {
    s"[RATIONAL]: $num" + (if (den == 1) "" else s"/$den")
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

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  /** Zero constant: result of 0/1 */
  val zero: Rational = apply(0)

  /** One constant: result of 1/1 */
  val one: Rational = apply(1, 1)

  /** Inf constant: result of 1/0 (impossible) */
  val inf: Rational = apply(1, 0)
}
