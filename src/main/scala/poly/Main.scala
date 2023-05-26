package cl.ravenhill
package poly

import poly.library.Library
import poly.library.contributors.Author
import poly.library.publications.{Book, Comic, Magazine}

import java.time.LocalDate

/** The main entry point of the application.
  *
  * This object instantiates some authors and their works, adds them to a library,
  * and then prints out all the titles of the publications in the library.
  * It showcases the use of various classes and their methods: `Author`, `Book`, `Comic`, `Magazine`,
  * and `Library`.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  * @version 1.0
  * @since 1.0
  */
object Main extends App {
  // Instantiate authors
  private val tolkien =
    new Author[Book]("J.R.R. Tolkien", LocalDate.of(1892, 1, 3))
  private val moore =
    new Author[Comic]("Alan Moore", LocalDate.of(1953, 11, 18))

  // Authors write their works
  private val pubs = List(
    tolkien.write(new Book("The Hobbit")),
    moore.write(new Comic("Watchmen"))
  )

  // Create a library and add the works
  private var library = new Library(pubs) + new Magazine("Wired")

  // Add more works to the library
  library = library ++ List(
    new Book("The Lord of the Rings"),
    new Comic("V for Vendetta")
  )

  // Print out all the titles of the publications in the library
  for (pub <- library.publications) {
    println(pub.title)
  }
}
