package tree

sealed trait BinaryTree[+T] {

  /**
   * Applies an operation for each value and, if exists, it sons in a tree
   * @param z Accumulator like
   * @param op A operation
   * @tparam U Return type value
   * @return z if node is empty, op on lv and rb otherwise
   */
  def fold[U](z: U)(op: (U, T, U) => U): U = this match {
    case Node(lt, lbl, rt) => op(lt.fold(z)(op), lbl, rt.fold(z)(op))
    case Empty => z
  }

  lazy val size: Int = fold(0) { case (lv, lbl, rv) => 1 + (lv + rv) }
  lazy val height: Int = fold(0) { case (lv, lbl, rv) => 1 + (lv max rv) }
  def contains[T1 >: T](x: T1) : Boolean =
    fold(false) { (lv, lbl, rv) => (lbl == x) || lv || rv }
}

case class Node[+T](left: BinaryTree[T], label: T, right: BinaryTree[T]) extends BinaryTree[T]

case object Empty extends BinaryTree[Nothing]
