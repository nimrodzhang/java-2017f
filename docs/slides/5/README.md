
# 设计原则

## Change is the eternal truth.

---

## SOLID


- SRP (The Single-Responsibility Principle)
- OCP (The Open-Closed Principle) 
- ISP (The Interface-Segregation Principle) 
- LSP (The Liskov Substitution Principle)
- DIP (The Dependency-Inversion Principle) 

---

## SRP 单一职责原则

- A class should have only one reason to change. 
- What is a Responsibility?
- An axis of change is an axis of change only if the changes actually occur.  

---

## 来个例子

<br/>

![](http://www.plantuml.com/plantuml/png/Iyv9B2vM24fDBadCIyz9hUPIKD0koyzCKKWfIYpNq0HnK_9Bat9I5HABKXE10hLSGE2UdrjGMf9OafcVbvWJxvwQdvjQKbGPxrXGa9EP31PMqDMrGnZBvLwKM901bCh1emRE0ekxXte20000) <!-- .element height="50%" width="50%" --> 


---

## Applying SRP

<br/>
![](http://www.plantuml.com/plantuml/png/Iyv9B2vM24fDBadCIyz9hUPIKD0koyzCKKWfIYpNqEIgvU9A1YjnJytFJIqfoaoEHrMSab-Qb9Ega5YKcWXHpkMUdrjGMf9OafcVbvWJ3zLN6UzOK92JcGmMLj3LjSDc89TxKM911b1H3ePgOjIuXtfomTNXj0DDHQWd0000)<!-- .element height="50%" width="50%" -->


---

## SRP Violation


<br/>
```java
interface Modem{
    public void dial (String pno);
    public void hangup();
    public void send (char c);
    public char recv();
}
```

---

## Applying SRP

<br/>
![](http://www.plantuml.com/plantuml/png/yymhIIrAIqnELN19B4cCTyv8pCjBpU7oX0ixvmC5aaioy_Euk92LADZKwEeg-EQdfER6U-OMvAJcfkQL98BL8RJWLWG0)<!-- .element height="30%" width="30%" --> 

 <font color=#0099ff>Note：如果应用程序的变化方式总是导致这两个职责同时变化，那么就不必分离它们！</font>

---

## OCP 开放封闭原则

- Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification. 

- <font color=red>OCP is the heart of OO design!</font>

---

## OCP Inside

- Two primary attributes
  + Open for extension: the behavior of the module can be extended
  + Closed for modification: extending the behavior of a module does not result in changes to the source or binary code of the module.

- Do not modify soucecode, but change behavior.

- <font color=yellow>Is it possible?</font>

---

## Abstraction is the key!

<br/>
![](http://www.plantuml.com/plantuml/png/Syv9B2vMSCx9JCqhuShBBqbLo4bDAx62YYXa5YlafMQMPAGMAUGNfEOfvEKNAIJdv1UdfkXnEOEr1gSMbQKMSN51DUZgsa650000) 

---

## Applying OCP

<br/>
![](http://www.plantuml.com/plantuml/png/yymhIIrAIqnELN3EoKpDAudtX0bmEUSa5XSh1ASMbQKMGJaGDLnv-IMf2ZcfQILMK165p6A5fFoI38NyWjGyXSIy58NadFpYr1GkBdHJ5MngT7KHXe8rw-hQOTWE0000)

---

## Template Pattern

<br/>
![](http://www.plantuml.com/plantuml/png/IqmgBYbAJ2vHICv9B2vM2CZFoKokhEPIKD0koyzCKIW0yzrAyv9BClFpD3I14jM9K2srK3N5gKLbcScfI8fgkRWWnddc5kIavgRcbII2P136OjK2iLl1faPN5qqZ0000)

 <font color=#0099ff>A clear separation of generic functionality from the detailed implementation of that functionality！</font>

---

## Heuristics

- OCP是面向对象设计的核心所在！
  + 灵活性、可重用性、可维护性
  + 使用OOPL不代表遵循了OCP
  + 肆意抽象亦不是一个好主意
- 100%的封闭不可能，必须有策略地对待这个问题。
  + 对程序中呈现出频繁变化的那些部分做出抽象，拒绝不成熟的抽象和抽象本身一样重要。


---

## LSP Liskov替换法则

- Subtypes must be substitutable for their base types. 
<br/></br/>
- If for each object o1 of type S there is an object o2 of type T such that for all programs P defined in terms of T, the behavior of P is unchanged when o1 is substituted for o2 then S is a subtype of T. [Liskov88] 



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

## final 

pp262-271


---

## final的变量



常量声明(经常和static关键字一起使用)

```java
public static final int i = 0;

i=1; // compilation errorerror

```

---

## final方法

代表这个方法不可以被子类的方法重写。

```java
class Man extends Human{
    public final void hitChild(){
        //beat and KO!
    }
}
 
class Father extends Man{
    @Override
    public final void hitChild(){
        // beat harder ...
        return // compilation error: overridden method is final
    }
}

```

“父类中这件事已经做得够好了，子类无法超越”


---

## final类


```java
final class Father extends Man{ 

}

class Son extends Father{ //compilation error: cannot inherit from final class

}

```
“老子整个已经不可超越”


---


## Polymorphism


多态性是指对象能够有多种形态。

- 男人是人
- 男人是动物
- 男人是一种存在

---

## 多态是”继承“的产物

```java

class Man extends Human {
    ...
}

class Human extends Creature{
    ...
} 

class Creature extends Being{
    ...
}
```

---

## 多态意味着什么？

```java
class Creature extends Being{
    public void eat(){
        System.out.println("eating");
    }
}
class Human extends Creature{
    @Override
    public void eat{
        System.out.println("cooking...eating")
    }
} 
class Woman extends Human {
    @Override
    public void eat{
        System.out.println("cooking...photoing...eating");
    }
}

Being you = new Woman();
you.eat(); //??
```

---

## 再举个例子

```java
class Shape{  
    void draw(){
        System.out.println("Draw Shape");
    }  
}  
class Circle extends Shape{  
    void draw(){
        System.out.println("Draw Circle");
    }  
}   
class Triangle extends Shape{  
    void draw(){
        System.out.println("Draw Triangle");
    }  
}  
class Square extends Shape{  
    void draw(){
        System.out.println("Draw Square");
    }  
}  
public class Test {  
     public static void main(String[] args) {  
         Shape[] shapes = {new Circle(), new Triangle(), new Square()};  
         for(Shape s : shapes){  
             s.draw();  
         }  
     }  
}  
```
执行结果？


---

## 再看一个例子
```java
class Shape{  
    private void draw(){  
        System.out.println("Draw Shape");  
    }  
      
    void show(){  
        draw();  
    }  
}  
  
class Circle extends Shape{  
    void draw(){  
        System.out.println("Draw Circle");  
    }  
}  
  
public class Test {
     public static void main(String[] args) {  
         Shape s = new Circle();  
         s.show();  
     }  
}  
```
执行结果？

---

## 多态形成的条件

- 继承
- 重写
- 父类引用指向子类对象

实际上是由Java中的”动态绑定“机制造成的。<!-- .element: class="fragment" -->

---

## 动态绑定

https://stackoverflow.com/questions/19017258/static-vs-dynamic-binding-in-java


http://www.jianshu.com/p/0677f366db08


---

## 再想想，Why？

## 抽象思维（编程）的支撑！<!-- .element: class="fragment" -->

---

## 抽象类

当一个类没有足够的信息来描述一个具体的对象，而需要其他具体的类来支撑它，那么这样的类我们称它为抽象类。


--- 

## 举个例子

```java
class Human {
    public void meetLouisVuitton(){
        //??
    }
}
```

---

## Abstract Class
```java
abstract class Human {
    public abstract void meetLouisVuitton();
}
class Man extends Human {
    @Override
    public void meetLouisVuitton(){
        pass();
    }
}
class Woman extends Human {
    @Override
    public void meetLouisVuitton(){
        enter();
    }
}

```

Why？应对不确定。<!-- .element: class="fragment" -->

---


## Interface

当所有行为都不确定时，来一份Interface。

接口比抽象类更抽象。

接口是用来建立类与类之间的协议（protocol）。


---

## 举个例子

```java
public interface Communicate{
    public String talkTo(String message);
}

public Man extends Human implements Communicate{
    ...
    public String talkTo(String message){
        return process(message);
    }
}
public Woman extends Human implements Communicate{
    ...
    public String talkTo(String message){
        return "我不听我不听我不听";
    }
}
```

---

## Why？

抽象的行为协议定义

接口与实现的分离


---

## 多继承

```java
interface A{
    public void a();
}
interface B{
    public void b();
}

class C implements A,B {
    public void a(){
        ...
    }
    public void b(){
        ...
    }
}
```
为什么Java不支持多继承多个父类但支持实现多个接口？<!-- .element: class="fragment" -->

---

## 接口中的成员变量

- 成员变量必须是`public static final`

为什么? 公有化，标准化、规范化。<!-- .element: class="fragment" -->

---


## Inner Classes

pp. 345-388

Why Inner Classes？<!-- .element: class="fragment" -->

下次再说<!-- .element: class="fragment" -->

---


## 再看葫芦娃


![](https://camo.githubusercontent.com/a5cc35d2179c5bf861f6a8eeca25fc5fa3e876a2/687474703a2f2f656e676c6973682e6372692e636e2f6d6d736f757263652f696d616765732f323030392f30362f32342f34363334636172746f6e312e6a7067)

---


# END