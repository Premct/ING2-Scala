package expression

import rational.Rational

/**
 * Represents Expression
 *
 * @note We add 'sealed' because we want to specify to Scala that there will not exist any other under-class outside this file
 * @note Each class is a case class because we want to make pattern matching
 *
 */
sealed trait Expression {
  val eval: Rational = this match {
    case Constant(x) => x
    case Plus(e1, e2) => e1.eval + e2.eval
    case Minus(e1, e2) => e1.eval - e2.eval
    case Times(e1, e2) => e1.eval * e2.eval
    case Opposite(e) => -e.eval
  }

  def +(that: Expression) = Plus(this, that)

  def -(that: Expression) = Minus(this, that)

  def *(that: Expression) = Times(this, that)

  lazy val unary_- = Opposite(this)

}

case class Constant(x: Rational) extends Expression

case class Plus(e1: Expression, e2: Expression) extends Expression

case class Minus(e1: Expression, e2: Expression) extends Expression

case class Times(e1: Expression, e2: Expression) extends Expression

case class Opposite(e: Expression) extends Expression
