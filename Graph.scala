/**
 * A minimalist generic type representing a directed graph over vertices of an arbitrary type T.
 */
trait Graph[T]:
  def edges(v: T): List[T]