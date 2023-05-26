package cl.ravenhill
package poly.library.publications

import poly.library.contributors.Author

abstract class AbstractAuthorable[T <: Authorable[T] with Publication](
    override val title: String
) extends Publication
    with Authorable[T] {
  private var _author: Option[Author[T]] = None

  override def author: Option[Author[T]] = _author

  override def author_=(author: Author[T]): Unit = {
    _author = Some(author)
  }
}
