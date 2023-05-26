package cl.ravenhill
package poly

import poly.library.Library
import poly.library.contributors.Author
import poly.library.publications.{AbstractAuthorable, Authorable, Book, Comic, Magazine, Publication}

import java.time.LocalDate

object Main extends App {
  val tolkien = new Author[Book]("J.R.R. Tolkien", LocalDate.of(1892, 1, 3))
  val moore = new Author[Comic]("Alan Moore", LocalDate.of(1953, 11, 18))
  val pubs = List(
    tolkien.write(new Book("The Hobbit")),
    moore.write(new Comic("Watchmen"))
  )
  val library = new Library(pubs) addPublication new Magazine("Wired")
  for (pub <- library.publications) {
    println(pub.title)
  }
}
