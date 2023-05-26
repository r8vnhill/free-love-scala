
package cl.ravenhill
package poly.library.publications

/** Represents a magazine, which is a specific kind of publication with a title.
 *
 * The `Magazine` class extends the `Publication` trait, providing a concrete implementation for a
 * magazine.
 * This class represents a specific magazine and can be distinguished by its title.
 *
 * Note: Unlike `Book` or `Comic`, `Magazine` does not inherit from `AbstractAuthorable` and
 * therefore does not include author information. If authorship is needed, consider using or
 * extending `AbstractAuthorable` instead.
 *
 * @param title The title of the magazine.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class Magazine(override val title: String) extends Publication

