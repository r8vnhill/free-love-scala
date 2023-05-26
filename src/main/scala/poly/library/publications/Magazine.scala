
package cl.ravenhill
package poly.library.publications

class Magazine(override val title: String)
  extends Publication {

  override def toString: String = {
    s"Magazine($title)"
  }
}
