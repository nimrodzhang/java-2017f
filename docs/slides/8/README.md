
## Java Collections Framework


🚺

---

## Outline

<br/>
- Holding your objects
- Arrays
- Containers in depth 

---

## Collections in Java

<br/>
- Manipulate grouped data as a single object
  + Java provides List, Set, Map
  + add, contains, remove, size, loop over, sort, ...

- Insulate programmer from implementation
  + array, linked list, hash table, balanced binary tree

- A Java collection is any class that holds objects and implements the ***Collection*** interface
  + For example, the ***ArrayList<T>*** class is a Java collection class, and implements all the methods in the ***Collection*** interface.
  + Collections are used along with iterators.

---

## Collection Framework

- A **collection framework** is a unified architecture for representing and manipulating collections. It has:
  + **Interfaces**: abstract data types representing collections
  + **Implementations**: concrete implementations of the collection interfaces
  + **Algorithms**: methods that perform useful computations, such as searching and sorting
    + These algorithms are said to be *polymorphic*: the same method can be used on different implementations

---

## Collection Framework

![](https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509882696522&di=800f9f7d8572eaf6cda169bf91a5decc&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D1284418618%2C721281437%26fm%3D214%26gp%3D0.jpg)

---

## Java Collection Framework Hierarchy

- A *collection* is a container object that represents a group of objects, often referred to as *elements*.
  + **Set** and **List** are subinterfaces of Collection.

---

## Java Collection Framework Hierarchy

- An instance of **Map** represents a group of objects, each of which is associated with a key. You can get the object from a map using a key, and you have to use a key to put the object into the map.

---

## Interfaces
 
- An interface describes a set of methods:
  + no constructors or instance variables

- Interfaces must be implemented by clasess

- 2 or more classes implement an interface
  + Classes guaranteed to have the same methods.
  + Objects can be treated as the same type.
  + Can use different algorithms / instance variables.

---

## Collection Interfaces

- Collections also uses following interfaces:
  + Comparator
  + Iterator
  + ListIterator
  + RandomAccess

---

## Collection Interfaces

- Collection
  + Enables you to work with collections. <<Top of Collection Hierarchy>>

- List
  + Extends Collection to handle List of elements [objects]
  + Allows *duplicate* elements in the list
  + Uses *indexing* technique starting with 0 to access elements


---

## Collection Interfaces

- Set
  + Extends Collection to handle set of elements [objects], which must contain *unique elements*

- SortedSet
   + Extends Set to handle sorted elements in a set



---

# END