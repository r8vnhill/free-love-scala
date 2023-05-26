package cl.ravenhill
package poly.library.publications

import poly.library.contributors.Author

trait Authorable[T <: Authorable[T]] {
  def author: Option[Author[T]]
  def author_=(author: Author[T]): Unit
}
