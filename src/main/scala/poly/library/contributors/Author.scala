package cl.ravenhill
package poly.library.contributors

import poly.library.publications.Authorable

import java.time.LocalDate

/** Represents an author of authorable works.
  *
  * @constructor Creates an instance of the author with the provided name and birth date.
  * @param name The name of the author.
  * @param birthDate The birth date of the author.
  * @tparam T The type of work that this author can create. It must extend the Authorable[T] trait.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  */
class Author[T <: Authorable[T]](val name: String, val birthDate: LocalDate) {

  /** The list of works that this author has written. */
  private var _works = List[T]()

  /** Returns the list of works that this author has written. */
  def works: List[T] = _works

  /** Allows the author to write a new work.
    * Adds the work to the author's list of works, and assigns the author to the work.
    *
    * @param book The work that the author is to write.
    * @return The work that was written.
    */
  def write(book: T): T = {
    _works = _works.appended(book)
    book.author = this
    book
  }
}
