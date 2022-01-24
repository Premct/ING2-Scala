/**
 * TD - Scala
 *
 * @author Pierre Monchecourt [monchecour@cy-tech.fr]
 */

import calendar.Calendar
import rational.Rational
import pi.Pi

/**
 * Main object, as an object meant for testing Calendar and Rational
 */
object Main {

  /**
   * Main function
   *
   * @param args The command-line arguments
   */
  def main(args: Array[String]): Unit = {
    /*
     * CALENDAR
     */
    println(s"------------")
    println(s"--CALENDAR--")
    println(s"------------")
    val year: Int = 2020;
    val month: Int = 2;

    val yearIsLeap: Boolean = Calendar.isLeap(year).get;

    println(s"$year is leap -> $yearIsLeap")
    println(s"$month/$year has ${Calendar.numberOfDays(month, yearIsLeap).get} days.\n")

    /*
     * RATIONAL
     */
    println(s"------------")
    println(s"--RATIONAL--")
    println(s"------------")
    val r = Rational(3, 5);
    val minusR = -r
    val invertedR = r.inverse

    val other = Rational(6)

    println(s"R: ${r.toString}")
    println(s"-R: ${minusR.toString}");
    println(s"1/R: ${invertedR.toString}")

    println(s"Other: ${other}")
    println(s"R + Other = ${r + other}")
    println(s"R - Other = ${r - other}")
    println(s"R * Other = ${r * other}")
    println(s"R / Other = ${r / other}")
    println(s"R = Other -> ${r == other}")
    println(s"R < Other -> ${r < other}")
    println(s"R > Other -> ${r > other}")
    println(s"R <= Other -> ${r <= other}")
    println(s"R >= Other -> ${r >= other}")

    /*
     * PI
     */
    println(s"------------")
    println(s"-----PI-----")
    println(s"------------")

    println(s"Pi Approximation, first method: ${Pi.pi(1000000)}")
    println(s"Pi Approximation, Monte-Carlo method: ${Pi.piMC(1000000)}")
  }
}
