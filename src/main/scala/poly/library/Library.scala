
package cl.ravenhill
package poly.library

import poly.library.publications.Publication

/** Represents a library which contains a list of publications.
 *
 * The `Library` class is generic and can contain different kinds of publications
 * that extend from the `Publication` trait.
 * Variance annotation `+` on `T` allows the `Library` class to be covariant, meaning that it can
 * also handle subtypes of `Publication`.
 *
 * @param publications The list of publications in the library.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class Library[+T <: Publication](val publications: List[T]) {

  /** Adds a new publication to the library.
   *
   * This method returns a new `Library` with the added publication.
   * It takes into account the type of the added publication, hence the `U` type parameter.
   *
   * @param publication The publication to be added.
   * @return A new `Library` instance with the added publication.
   */
  def +[U >: T <: Publication](publication: U): Library[U] = {
    new Library(publications :+ publication)
  }

  /** Adds a list of new publications to the library.
   *
   * This method returns a new `Library` with the added publications.
   * It takes into account the type of the added publications, hence the `U` type parameter.
   *
   * @param publications The list of publications to be added.
   * @return A new `Library` instance with the added publications.
   */
  def ++[U >: T <: Publication](publications: List[U]): Library[U] = {
    if (publications.isEmpty) {
      this
    } else {
      (this + publications.head) ++ publications.tail
    }
  }
}
