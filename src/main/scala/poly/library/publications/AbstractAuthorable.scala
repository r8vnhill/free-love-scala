package cl.ravenhill
package poly.library.publications

import poly.library.contributors.Author

/** Represents an abstract authorable publication with a title.
  *
  * The `AbstractAuthorable` class serves as a base for any specific type of publication that can be
  * authored, such as a book or article.
  * Any class that extends this abstract class will have to provide an implementation for the
  * `Publication` trait and the `Authorable` trait.
  *
  * The class also provides a mechanism to associate an author to a specific publication, and to
  * retrieve the associated author.
  *
  * @param title The title of the publication.
  * @tparam T The specific type of the publication that extends `Authorable[T]` and `Publication` traits.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  * @version 1.0
  * @since 1.0
  */
abstract class AbstractAuthorable[T <: Authorable[T] with Publication](
    override val title: String
) extends Publication
    with Authorable[T] {
  /** The author of this publication. */
  private var _author: Option[Author[T]] = None

  /** Retrieves the author of this publication.
    *
    * @return An Option containing the `Author` object if an author is associated, otherwise None.
    */
  override def author: Option[Author[T]] = _author

  /** Associates an author to this publication.
    *
    * @param author The `Author` object to be associated with this publication.
    */
  override def author_=(author: Author[T]): Unit = {
    _author = Some(author)
  }
}
