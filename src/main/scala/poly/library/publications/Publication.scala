
package cl.ravenhill
package poly.library.publications

/** Represents a publication with a title.
 *
 * This trait can be used as a common type for all kinds of publications, like books, magazines,
 * newspapers, etc.
 * Any class that extends this trait can be treated as a Publication, making it easier to work with
 * different kinds of publications in a uniform way.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @version 1.0
 * @since 1.0
 */
trait Publication {

  /** The title of the publication. */
  val title: String
}
