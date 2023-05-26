
package cl.ravenhill
package poly.library

import poly.library.publications.Publication

class Library[+T <: Publication](val publications: List[T]) {
  def addPublication[U >: T <: Publication](publication: U): Library[U] = {
    new Library(publications :+ publication)
  }

  def ++[U >: T <: Publication](publications: List[U]): Library[U] = {
    if (publications.isEmpty) {
      this
    } else {
      this addPublication publications.head ++ publications.tail
    }
  }
}
