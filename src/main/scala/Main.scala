package cl.ravenhill

import scala.collection.mutable.ArrayBuffer

trait Authorable[T <: Authorable[T]] extends Material {
  def author: Option[Author[_ >: T]]
  def author_=(author: Author[_ >: T]): Unit
}

class Illustrator[-T <: Material](val name: String) {
  def illustrate(t: T): Unit = {
    t.illustrator = this
  }
}

class Author[T <: Authorable[T]](val name: String) {
  def write(t: T): T = {
    t.author = this
    t
  }
}

class Material(val title: String) {
  private var _illustrator: Option[Illustrator[_ <: Material]] = None

  def illustrator: Option[Illustrator[_ <: Material]] = _illustrator

  def illustrator_=(illustrator: Illustrator[_ <: Material]): Unit = {
    _illustrator = Some(illustrator)
  }
}

class Book(title: String) extends Material(title) with Authorable[Book] {
  private var _author: Option[Author[_ >: Book]] = None

  def author: Option[Author[_ >: Book]] = _author

  def author_=(author: Author[_ >: Book]): Unit = {
    _author = Some(author)
  }
}

class Comic(title: String) extends Material(title) with Authorable[Comic] {
  private var _author: Option[Author[_ >: Comic]] = None

  def author: Option[Author[_ >: Comic]] = _author

  def author_=(author: Author[_ >: Comic]): Unit = {
    _author = Some(author)
  }
}

class Magazine(title: String) extends Material(title)

// An immutable Library class, where T is covariant
class Library[+T <: Material](val materials: List[T]) {

  def +[U >: T <: Material](material: U): Library[U] = {
    new Library(material :: materials)
  }

  def +[U >: T <: Material](materials: List[U]): Library[U] = {
    if (materials.isEmpty) {
      this
    } else {
      this + materials.head + materials.tail
    }
  }
}

object Main extends App {
  private val book = new Book("The Lord of the Rings")
  private val author = new Author[Book]("J. R. R. Tolkien")
  private val illustrator = new Illustrator[Book]("George Allen & Unwin")
  private val editedBook = author.write(book)
  illustrator.illustrate(editedBook)

  println(s"Book: ${editedBook.title}")
  println(s"Author: ${editedBook.author.get.name}")
  println(s"Editor: ${editedBook.illustrator.get.name}")

  val magazine = new Magazine("National Geographic")
  val library = new Library[Material](List(book, magazine))
  val newLibrary = library + new Book("The Hobbit")

  println(s"Library: ${library.materials.map(_.title).mkString(", ")}")
  println(s"New Library: ${newLibrary.materials.map(_.title).mkString(", ")}")
}