package cl.ravenhill
package poly.library.publications

import poly.library.contributors.Author

/** Trait for entities that can be authored, parameterized by a type `T` that is a subtype of
 * `Authorable[T]`.
 *
 * This trait applies the "curiously recurring template pattern" (CRTP) to enforce a type
 * relationship between the implementer (`T`) and `Authorable[T]`.
 * It ensures that only types that can be authored can have an author.
 *
 * @tparam T The specific subtype of `Authorable[T]` to which this trait applies.
 *           It should be the type that implements this trait.
 */
trait Authorable[T <: Authorable[T]] {

  /** Returns the author of the current entity, wrapped in an [[Option]].
   * [[None]] indicates that the entity currently has no author, this may be the case if the
   * entity is anonymous or if the author has not yet been set.
   */
  def author: Option[Author[T]]

  /** Sets the author of the current entity. */
  def author_=(author: Author[T]): Unit
}
