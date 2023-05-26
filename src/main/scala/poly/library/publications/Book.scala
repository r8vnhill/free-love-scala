package cl.ravenhill
package poly.library.publications

/** Represents a book, which is a specific kind of authorable publication with a title.
 *
 * The `Book` class extends the `AbstractAuthorable` class, providing a concrete implementation for
 * a book.
 * This class inherits the ability to have an author associated with it from the
 * [[AbstractAuthorable]] class.
 *
 * A `Book` object represents a specific book and can be distinguished by its title.
 *
 * @param title The title of the book.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class Book(override val title: String) extends AbstractAuthorable[Book](title)