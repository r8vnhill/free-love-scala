package cl.ravenhill
package poly.library.publications

/** Represents a comic, which is a specific kind of authorable publication with a title.
 *
 * The `Comic` class extends the `AbstractAuthorable` class, providing a concrete implementation for
 * a comic.
 * This class inherits the ability to have an author associated with it from the
 * `AbstractAuthorable` class.
 *
 * A `Comic` object represents a specific comic and can be distinguished by its title.
 *
 * @param title The title of the comic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class Comic(override val title: String) extends AbstractAuthorable[Comic](title)
