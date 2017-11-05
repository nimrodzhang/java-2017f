
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

## The Collection Interface

- The Collection interface is the root interface for manipulating a collection of objects


---

## A not on iterators

- An iterator is an object that enables you to traverse through a collection and to remove elements from the collection and to remove elements from the collection by calling its iterator() method. 

```java
public interface Iterator<E>{
  boolean hasNext();
  E next();
  void remove(); //optional
}

```

---

## Example 

- Iterators provide a general way to traverse all elements in a collection. 

```java
ArrayList<String> list = new ArrayList<String>();
list.add("1-FiRsT");
list.add("2-SeCoND");
list.add("3-ThIrD");
Iterator<String> itr = list.iterator();
while (itr.hasNext()){
  System.out.println(itr.next().toLowerCase());
}

```

---

## Example

```java

import java.util.*
public class SimpleCollection{
  public static void main(String[] args){
    Collection c = new ArrayList();
    for (i=0;i<10;i++)   c.add(Integer.toString(i));
    Iterator it = c.iterator();
    while (it.hasNext())  System.out.println(it.next());
  }
}

```

---

## Implementations

- A collection class
  + implements an ADT as a Java class
  + implements all methods of the interface
  + selects appropriate instance variables
  + can be instantiated

- Java implements interfaces with
  + List: ArrayList, LinkedList, Vector
  + Map: HashMap, TreeMap
  + Set: TreeSet, HashSet

---

## Implementations in Java Collection Framework

- Vector, LinkedList, HashMap


---

## Algorithms

- Java has polymorphic algorithms to provide functionality for different types of collections.
  + Sorting (e.g. sort)
  + Shuffling (e.g. shuffle)
  + Routine Data Manipulation (e.g. reverse, addAll)
  + Searching (e.g. binarySearch)
  + Composition (e.g. frequency)
  + Finding Extreme Values (e.g. max)

---

## Utility Classes -1 

- Collections class
- Static methods:
  + sort (List)
  + binarySearch (List, Object)
  + reverse (List)
  + shuffle (List)
  + fill (List, Object)
  + copy (List dest, List src)
  + min (Collection)
  + max (Collection)
  + synchronizedX, unmodifiableX factory methods

---

## Example

```java
...
List list = Collections.nCopies(3, "red");
ArrayList arrayList = new ArrayList(list);
Collections.fill(arrayList, "yellow");
Collections.shuffle(arrayList);
...
```

---

## Utility Classes -2

- Arrays class
- Static methods that act on Java arrays:
  + sort
  + binarySearch
  + equals
  + fill
  + asList // returns an ArrayList composed of this array's contents

---

## List

- Like an array
  + elements have positions indexed 0...size()-1
  + duplicate entries possible
- Unlike an array
  + can grow as needed
  + easy to add/delete at any position
  + API independent of implementation (ArrayList, LinkedList)

---

## The List Interface


---

## The List Iterator

---

## List Implementations

- ArrayList
  + a resizable-array implementation like Vector
    + unsynchronized, and without legacy methods
- LinkedList
  + a doubly-linked list implementation
  + May provide better performance that ArrayList
    + if elements frequently inserted/deleted within the List
  + For queues and double-ended queuse (deques)
- Vector
  + a synchronized resizable-array implementationo f a List with additional "legacy" methods.

---

## LinkedList


---

## Example

```java
import java.util.*;
public class TestArrayAndLinkedList {
public static void main(String[] args) {
    List<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(1); // 1 is autoboxed to new Integer(1)
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(1);
    arrayList.add(4);
    arrayList.add(0, 10);
    arrayList.add(3, 30);
    System.out.println("A list of integers in the array list:");
    System.out.println(arrayList);
    LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);
    linkedList.add(1, "red");
    linkedList.removeLast();
    linkedList.addFirst("green");
    System.out.println("Display the linked list forward:");
    ListIterator<Object> listIterator = linkedList.listIterator();
    while (listIterator.hasNext()) {
    System.out.print(listIterator.next() + " "); }
    System.out.println();
    System.out.println("Display the linked list backward:");
    listIterator = linkedList.listIterator(linkedList.size());
    while (listIterator.hasPrevious()) {
    System.out.print(listIterator.previous() + " "); } }
}
```

---

## The Vector Class

- The Java Collections Framework was introducde with Java 2. Several data structures were supported prior to Java 2. Among them are the Vector class and the Stack class.

- In Java 2, Vector is the same as ArrayList, except that Vector contains the synchronized methods for accessing and modifying the vector.

---

## The Vector Class


---

## Example

```java 
import java.util.Vector;
public class Polygon{ // 存储多边形顶点的Point表
  private Vector verties = new Vector();
  public void add(Point p){
  verties.addElement(p);
  }
  public void remove(Point p){
  verties.removeElement(p);
  }
  public int numVerties(){
  return verties.size();
  }
  // ..其它方法....
}
```

---

## The Stack Class

- The Stack class represents a last-in-first-out stack of objects. The elements are accessed only from the top of the stack. You can retrieve, insert, or remove an element from the top of the stack.


---

## Example

```java
import java.util.Stack//Using Stack to keep track of who currently
public class Borrow{ // has borrowed something
    private String itemName;
    private Stack hasIt = new Stack();
    public Borrow(String name,String owner){
      itemName = name; hasIt.push(owner);
    } //首先压进主人的名字
    public void borrow(String borrower){
      hasIt.push(borrower); }
    public String currentHolder(){
      return (String)hasIt.peek(); }
    public String returnIt(){
      String ret=(String)hasIt.pop();
      if(hasIt.empty()) //不小心把主人弹出
        hasIt.push(ret); //将主人名字入栈
      return ret; 
    } 
}


```

---

## Set

- Like a List
  + can grow as needed
  + easy to add/delete
  + API independent of implementation (HashSet, TreeSet, LinkedHashSet)

- Unlike a List
  + elements have no positions
  + duplicate entries not allowed

---

## Set Implementations

- HashSet
  + a Set backed by a *hash table*
- LinkedHashSet
  + a Set implementated by a *linked-list*
  + sorted by an inserting ordinary
- TreeSet
  + a *balanced binary tree* implementation
  + Imposes an ordering on its elements

---

## Example

```java
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Set<String> ss = new LinkedHashSet<String>();
        for (int i = 0; i < args.length; i++)
            ss.add(args[i]);
        Iterator <String> i = ss.iterator();
        For (Object element: set)
          System.out.println(element.toString() + “”) ;
    }
}
```

---

## The TreeSet Class

- TreeSet is a concrete class that implements the SortedSet interface. You can use an iterator to traverse the elements in the sorted order. The elements can be sorted in two ways:
  + To use the Comparable interface
  + To specify a comparator for thee elements in the set if the class for the elements do not implement the Comparable interface , or you don't want to use the compareTo method in the class that implements the Comparable interface. This approach is referred to as order by comparator.

---

## Example

```java
import java.util.*;
public class TestTreeSet {
    public static void main(String[] args) { // Create a hash set
        Set<String> set = new HashSet<String>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        TreeSet<String> treeSet = new TreeSet<String>(set);
        System.out.println(treeSet);
        // Display the elements in the hash set
        for (Object element: set)
        System.out.print(element.toString() + " "); 
    }
}

```

---

## The Comparator Interface

- Sometimes you want to insert elements of different types into a tree set. The elements may not be instances of Comparable or are not comparable. You can define a comparator to compare these elements.

- To do so, create a class that implements the java.util.Comparator interface. The Comparator interface has two methods, compare and equals

  + public int compare(Object element1, Object element2)
  + public boolean equals(Object element)

---

## TreeSet Example

```java

import java.util.Comparator; //P25
public class GeometricObjectComparator implements Comparator<GeometricObject> {
    public int compare(GeometricObject o1, GeometricObject o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();
        if (area1 < area2)
          return -1;
        else if (area1 == area2)
          return 0;
        else
          return 1;
    }
}

```

---

## TreeSet Example

```java
import java.util.*;
public class TestTreeSetWithComparator {
    public static void main(String[] args) {
        // Create a tree set for geometric objects using a comparator
        Set<GeometricObject> set = new TreeSet<GeometricObject>
        (new GeometricObjectComparator());
        set.add(new Rectangle(4, 5));
        set.add(new Circle(40));
        set.add(new Circle(40));
        set.add(new Rectangle(4, 1));
        // Display geometric objects in the tree set
        System.out.println("A sorted set of geometric objects");
        for (GeometricObject element: set)
        System.out.println("area = " + element.getArea()); 
    }
}

```

---

## Map

- Table lookup abstraction
  + void put( Object key, Object value)
  + Object get (Object key)
- can grow as needed any Objects for key and value (keys tested for equality with equals, of course)
- API syntax independent of implementation (HashMap, LinkedHashMap, TreeMap)
- Iterators for keys, values, (key, value) pairs

---

## The Map Interface UML Diagram

---

## HashMap, TreeMap and LinkedHashMap

- The HashMap and TreeMap classes are two concrete implementations of the Map interface
- The HashMap class is efficient for locating a value, inserting a mapping, and deleting a mapping
- The TreeMap class, implementing SortedMap, is efficient for traversing the keys in a sorted order
- LinkedHashMap was introduced in JDK 1.4. It extends HashMap with a linked list implementation that supports an ordering of the entries in the map

---

## Example

```java
import java.util.*;
public class Test {
  public static void main(String[] args) {
    //map to hold student grades
    Map<String, Integer> theMap = new HashMap<String, Integer>();
    theMap.put("Korth, Evan", 100);
    theMap.put("Plant, Robert", 90);
    theMap.put("Coyne, Wayne", 92);
    theMap.put("Franti, Michael", 98);
    theMap.put("Lennon, John", 88);
    System.out.println(theMap);
    System.out.println("-------------------------------");
    System.out.println(theMap.get("Korth, Evan"));
    System.out.println(theMap.get("Franti, Michael")); 
  }
}
```

---

## Example

```java
public class CountOccurrenceOfWords { 
    public static void main(String[] args) {
      String text = "Have a good day. Have a good class. " + "Have a good visit. Have
      fun!";
      // Create a hash map to hold words as key and count as value
      TreeMap<String, Integer> map = new TreeMap<String, Integer>();
      String[] words = text.split("[ .!?]");
      for (int i = 0; i < words.length; i++) {
      if (words[i].length() > 1) {
      if (map.get(words[i]) != null) {
      int value = map.get(words[i]).intValue();
      value++;
      map.put(words[i], value); }
      else map.put(words[i], 1); } }
      // Get all entries into a set
      Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
      // Get key and value from each entry
      for (Map.Entry<String, Integer> entry: entrySet)
      System.out.println(entry.getValue() + "\t" + entry.getKey())
    }
}

```

---

## Summary

---

# END