package model

object UserQueries {
  val students: Seq[Student] = ???
  val teachers: Seq[Teacher] = ???

  def studentsOfYear(y: Int): Seq[Student] = {
    (students filter { _.year == y }).sorted
//    (for (s <- students if s.year == y) yield s).sorted // For-Comprehension version
  }

  def teachersOfDepartment(d: String): Seq[Teacher] =
    (teachers filter { _.department == d }).sorted
  //    (for (t <- teachers if t.department == d) yield t).sorted // For-Comprehension version

  def fontPartieDesMeubles: Seq[Teacher] =
    (teachers filter { _.seniority >= 10 }).sorted
  //    (for (t <- teachers if t.seniority >= 10) yield t).sorted // For-Comprehension version

}
