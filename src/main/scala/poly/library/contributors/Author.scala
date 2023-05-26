package cl.ravenhill
package poly.library.contributors

import poly.library.publications.{Authorable, Book}

import java.time.LocalDate

class Author[T <: Authorable[T]](val name: String, val birthDate: LocalDate) {
  private var _works = List[T]()

  def works: List[T] = _works

  def write(book: T): T = {
    _works = _works.appended(book)
    book.author = this
    book
  }
}
