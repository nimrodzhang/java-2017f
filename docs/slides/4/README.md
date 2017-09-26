# 面向对象の一些细节

---

面向对象编程首先认识待解决问题所涉及的基本对象和他们间的相互关系，然后将这些现实对象映射到计算机中，实现计算机对现实问题的模拟，将“问题空间”直接映射到“解空间”。

---

## Class

- 对象的“生成模板”
  + 属性（状态）
  + 方法（行为）

```java
class Human {
    int age;
    boolean gender;
    void walk() {};
}
```

---

## UML

![](http://www.plantuml.com/plantuml/png/Iyv9B2vMy2ZDJSnJgEPI08BCl1A5nFHKQp0dAJy_9nKebPwQbv9Q114hoyzCKIXFpCdMqBJcgWK0)  

![](http://s.plantuml.com/logoc.png) [PlantUML](http://www.plantuml.com/)

---

## 初始化（构造）

从”对象模版“生成“对象实例“

```java
Human you = new Human();
```

- 每个对象拥有一份属性拷贝
- 对象共享方法（代码）的定义
- 每个对象有一个标识（id，内存地址）
- 通过对象引用（Object Reference）可访问对象方法和属性


---

## 构造函数（Constructor）

```java
class Human {
    int age;
    boolean gender;
    Human(){ //default constructor
        age = 0;
        gender = false;
    }
    Human(int age){ //overloading
        gender = true;
        this.age = age;
    }
    Human(boolean gender){
        this(0) //calling constructors from constructors
        this.gender = gender;
    }
}

```

---

## 成员变量初始化 （P185）

按在类中定义顺序逐个初始化（或赋予默认值），然后执行构造函数。

---

## 静态变量


```java
class Human {
    static int total;

    int age;
    boolean gender;
    Human(){ //default constructor
        Human.total++;
        age = 0;
        gender = false;
    }
    ...
}

```

---

## Static Blocks
```java
class Human {
    static int total;
    static{
        total = 2; //Adam and Eve
    }
    int age;
    boolean gender;
    Human(){ //default constructor
        Human.total++;
        age = 0;
        gender = false;
    }
    ...
}

```

---

## Instance initialization

```java
class Man {
    Object girlfriend;
    {
        girlfriend = new Dog();
    }
    ...
}

```

---

## 数组初始化
PP. 193-204

---

## Enum 怎么理解？

```java
enum GENDER {
    MALE, FEMALE, NOTTELLING
}

public static void main(String[] args){
    GENDER gender = GENDER.MALE;
    System.out.println(gender.toString() + " " + gender.ordinal())
}
```

---

## 对象消亡

- 垃圾回收（Garbage Collection）
  + Stop-and-Copy
  + Mark-and-Sweep

vs. [Reference Counting](https://en.wikipedia.org/wiki/Reference_counting)

---

## Stop-and-Copy

![](http://www.memorymanagement.org/_images/two-space.svg)

---

## Mark-and-Sweep

![](http://3.bp.blogspot.com/-LNBSfvedEEM/VkxZomXBkvI/AAAAAAAAACI/EhsDaD0k-1g/s1600/output_oPN0rV.gif)

---

## package

```bash
Huam.java
```
```java
package cn.edu.nju.java;

class Human{

}
```
```bash
Society.java
```
```java
import cn.edu.nju.java.Human;

```

---

## CLASSPATH

```bash
CLASSPATH=.:CLASSPATH=/path/to/some/folder:/path/to/other.jar
```

```bash
/path/to/some/folder/cn/edu/nju/java/Human.class

java Human
```

<span style="color:red">Why?</span> <!-- .element: class="fragment" -->

The class loading problem.<!-- .element: class="fragment" -->

---

## package

<span style="color:red">Why?</span> <!-- .element: class="fragment" -->

组织管理、避免冲突、访问控制 （PP. 210-220) <!-- .element: class="fragment" -->


---

## 访问控制

- Modifier
  + public
  + protected
  + private
  + _default_

---

## public

```java

enum Appearance {
    BEAUTIFUL, UGLY
}
public class Human{
    public Appearance appearance;
}
```

Interface access

---

## protected

```java
public class Human{
    protected float money;
}
```
<small>注：此例并不恰当</small>

Inheritance access 

---

## private

```java
enum Mood {
    GOOD, BAD
}
public class Human{
    private Mood mood;
}
```

You can't touch that!

---

## default


```java

enum Performance {
    GOOD, BAD
}
public class Human{
    Performance performance;
}
```

Package friendly

---

## Modifiers

- class
- member
- method

<span style="color:red">Why?</span> <!-- .element: class="fragment" -->

封装  <!-- .element: class="fragment" -->

---

## Encapsulation


Encapsulation is to hide the implementation details from users

![](https://alssl.askleomedia.com/wp-content/uploads/2009/01/cpu-600x490.jpg) <!-- .element height="40%" width="40%" --> 


<span style="color:red">Why?</span> <!-- .element: class="fragment" -->

---

## Encapsulating for

![](https://qph.ec.quoracdn.net/main-qimg-00d9d179877f83e537c65a770cd052e1.webp)

Flexibility, Reusability, Maintainability.


---

## 代码重用（复用）

- Composition
- Inheritance
- Delegation


---

## Composition

```java
public class Heart {
    ...
}

public class Liver {
    ...
}

public class Human {
    private Heart battery;
    private Liver screen;
    ...
}

```

---

## Composition in UML
![](http://www.plantuml.com/plantuml/png/yoZDJSnJK39KKj3IrGNJ7gc9HILS7XZYFfbbgKK0)

“部分”的生命期不能比“整体”还要长

--- 

## 弱合成

- Aggregation
- Association


---

## Aggregation

![](http://www.plantuml.com/plantuml/png/SquiKb0oL5B8rzK5qwvvwPbvgLpEoC8cIWhX6QcfEG00)


“部分”可独立存在


---

## Association

![](http://www.plantuml.com/plantuml/png/2qZDByX9LNZKC4VhKSDS1LrT4DCGn0pFByhEp4iFo4bCJWK0)

对象可以向另一个对象通过某种方式发送消息

---

## Inheritance

![](http://www.plantuml.com/plantuml/png/SquiKh2fqTLLS4hDgm80)

Initialize the base first


--- 

## Delegating
```java
public class Car {
    public Window[] windows = new Window[4];
}

public class Jetta extends Car{

}

Car myCar = new Jetta();

//手摇式玻璃
myCar.windows[0].open();

```


--- 

## Delegating
```java
public class Car {
    public Window[] windows = new Window[4];
}

public class Tesla extends Car{
    public void openWindow(int i){
        this.windows[i].open(); //delegate
    }
}

Car hisCar = new Tesla();

//自动式玻璃
hisCar.openWindow(1);

```

--- 

## 代码复用？

![](https://developer.apple.com/library/content/documentation/General/Conceptual/CocoaEncyclopedia/Art/delegation1.jpg)

---

## A system class

```java

public class Window {
    private Button btnClose;

    private void btnCloseClicked(){
        ///???
    }
}

```

---

## Customizing it by extending it

```java

public class MyWindow extends Window {
    private Button btnClose;

    private void btnCloseClicked(){
        // bala bala
    }
}

```

---

## Or implementing a delegate

```java

public class Window {
    private Button btnClose;
    
    private WindowDelegate delegate;

    private void btnCloseClicked(){
        delegate.windowClosing();
    }
}

public class WindowDelegate {
    public windowClosing(){
        //bala bala
    }
}

```


<span style="color:red">Why?</span> <!-- .element: class="fragment" -->


---
# END