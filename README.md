# Free Love

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

Free Love is a Scala project that illustrates the concepts of subtype polymorphism, parametric 
polymorphism, ad-hoc polymorphism, variance, upper and lower bounds, and the Curiously Recurring 
Template Pattern (CRTP). 
It does so by implementing a model of a library, which includes various types of publications, and 
individuals who author them.

## Polymorphism

Polymorphism is a key principle in Object Oriented Programming (OOP) that allows objects of 
different types to be accessed through a single, uniform interface.

### Subtype Polymorphism

In this project, we use subtype polymorphism in the definition of publications and the people 
involved in their creation. 
For example, ``Book`` and ``Comic`` are subtypes of ``Publication``.

### Parametric Polymorphism

Parametric polymorphism, achieved through the use of generics, is extensively used in this project. 
For example, the ``Author`` class has a generic type parameter which is constrained to be a subtype 
of ``Authorable``.

### Ad-hoc Polymorphism

Ad-hoc polymorphism is not used in this project, but it is exemplified and explained in the 
related PPT presentation (in Spanish).

It is also known as function overloading, and it is a form of polymorphism in which a function
is applied to arguments of different types, but behaves differently depending on the type of the
arguments to which it is applied.

### Variance

Variance deals with the subtyping relationship between complex types (types that consist of other 
types, e.g., generics, collections). 
Scala supports variance annotations on type parameters, which helps in defining how subtyping 
between more complex types relates to subtyping between their components.

In the ``Library`` class, we use covariance (``+T``) to allow a ``Library`` of a certain publication
type to also hold its subtypes. 
This makes our Library more flexible and easier to use.

### Upper and Lower Bounds

In the context of generics, upper and lower bounds are constraints put on the type parameters. 
They restrict what types can be used as the actual type argument for a given class or trait.

In our ``Library`` class, we use an upper bound in the type parameter of the add methods 
(``+[U >: T <: Publication]`` and ``++[U >: T <: Publication]``) to ensure that we can only add 
``Publication`` types (or subtypes) to our ``Library``.

## Curiously Recurring Template Pattern (CRTP)

CRTP is a design pattern in which a class is inherited from a base class with a generic parameter, 
and the derived class is passed as the parameter. 
This is extensively used in this project, for example, in the ``Authorable`` trait.

## Running the Project

The project can be run from the command line using the following command:

```
sbt run
```

