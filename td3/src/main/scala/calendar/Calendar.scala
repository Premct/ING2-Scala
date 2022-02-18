package calendar

/**
 * Defines a Calendar
 */
object Calendar {
  /**
   * Checks if a year is leap
   *
   * @param year A year
   * @return None is year is less than 0, true is the year is leap, false otherwise
   */
  def isLeap(year: Int): Option[Boolean] = {
    if (year < 0) None else Some((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
  }

  /**
   * Gives the number of days in a given month of a year
   *
   * @note Here, we pass boolean parameter as the second one, so we can use it with default value and without writing it unnecessarily
   * @param month The month
   * @param leap  If the year is leap or not. Default: false
   * @return An Option[Int], as None is month is not valid and the number of days in a given month of a year otherwise
   */
  def numberOfDays(month: Int, leap: => Boolean): Option[Int] = {
    if (month < 1 || month > 12)
      return None
    month match {
      case 2 => Some(if (leap) 29 else 28)
      case 4 | 6 | 9 | 11 => Some(30)
      case _ => Some(31)
    }

    /* TD3 exercise here */
//    def numberOfDays(year: Int, month: Int): Option[Int] = {
//      isLeap(year) flatMap { numberOfDays(_, month) }
////      isLeap(year) match {
////        case Some(leap) => numberOfDays(leap, month)
////        case None => None
////      }
//    }
  }
}
