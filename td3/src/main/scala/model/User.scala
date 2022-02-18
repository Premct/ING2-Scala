package model

sealed abstract class User(val last: String,
                           val first: String,
                           val age: Int) extends Ordered[User] {
  val login: String = this match {
    case Student(l, f, _, _) => (l + f).toLowerCase take 10
    case Teacher(l, f, _, _, _) => Seq(f.head, l.head, l.last).mkString
  }

  override def compare(that: User): Int =
    if ((this.last compare that.last) == 0)
      this.first compare that.first
    else
      this.last compare that.last
}

case class Student(override val last: String,
                   override val first: String,
                   override val age: Int,
                   val year: Int) extends User(last, first, age) {
}

case class Teacher(override val last: String,
                   override val first: String,
                   override val age: Int,
                   val department: String,
                   val seniority: Int) extends User(last, first, age)
