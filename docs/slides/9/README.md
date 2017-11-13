
## 范型 Generics


<small>--这可能是《Thinking in Java》中最难理解的一章。</small>

---

## Java Generics

- A way to control a class type definitions
- Otherwise known as *parameterised types* or *templates*
- A way of improving the clarity of code
- A way of avoiding (**casts**) in code, turning run-time errors (typically **ClassCastException**) into compile-time errors.

---

## Without Generics

```java
class Stack{
  void push(Object o){...}
  Object pop(){...}
}
String s = "Hello";
Stack st = new Stack();
...
st.push(s);
...
s = (String)st.pop();
```

---

## With Generics

```java
class Stack<A>{ // 类参数
  void push(A a){...}
  A pop(){...}
}
String s = "Hello";
Stack<String> st = new Stack<String>();
st.push(s);
...
s = st.pop();

```


---

## 泛型是什么

泛型：参数化类型。

---

## 葫芦娃中的例子

``` java
public class Position {
    private Object holder;
    public Position(Object holder) { 
        this.a = a; 
    }
    Object get() { 
        return a; 
    }
}
```

Postion里放任意东西<!-- .element: class="fragment" -->

---

## 改进

``` java
public class Position {
    private Creature holder;
    public Position(Creature holder) { 
        this.a = a; 
    }
    Creature get() { 
        return a; 
    }
}
```

通过构造方法和get方法我们能看出Position里放的是Creature<!-- .element: class="fragment" -->

---

## 但如果是这样呢？
``` java
public class Position {
    private Creature holder;
}
```

从外部观察，何以了解Position是放Creature的？<!-- .element: class="fragment" -->

---

## 显式说明一下

``` java
public class Position<T>{
    private T holder;
}
```
显式表达“某种不确定”: Position里是要放东西的，但不确定是什么东西 <!-- .element: class="fragment" -->

---

## 再明白一点

``` java
public class Position<T extends Creature>{
    private T holder;
}
```

显式表达Position是跟某种Creature有关系的 <!-- .element: class="fragment" -->


---

## 定义一个Computer 

``` java
public class Computer{

    private HDD mHarddisk;   // 机械硬盘
    
    Computer(HDD harddisk){
        mHarddisk = harddisk;
    }
    
    public Data readDisk(){
        return mHarddisk.read();
    }
    
    public void writeDisk(Data data){
        mHarddisk.write(data);
    }
}
```

如果安装的是SSD怎么办？ <!-- .element: class="fragment" -->

---

## 定义一个SSDComputer ？

``` java
public class SSDComputer{

    private SSD mHarddisk;   // SSD硬盘
    
    Computer(SSD harddisk){
        mHarddisk = harddisk;
    }
    
    public Data readDisk(){
        return mHarddisk.read();
    }
    
    public void writeDisk(Data data){
        mHarddisk.write(data);
    }
}
```

这当然不好！ <!-- .element: class="fragment" -->

---

## 抽象一下
``` java

public interface Disk{};
public class SSD extends Disk{};
public class HHD extends Disk{};
public class SSDComputer{

    private Disk disk;   // 抽象的硬盘
    
    Computer(Disk disk){
        disk = disk;
    }
    
    public Data readDisk(){
        return disk.read();
    }
    
    public void writeDisk(Data data){
        disk.write(data);
    }
}
```

基于多态实现设计抽象（解耦） <!-- .element: class="fragment" -->

---

## 用范型来做

``` java
public class Computer<T extends Disk>{
    private T disk;   // 参数类
    Computer(T disk){
        disk = disk;
    }
    public Data readDisk(){
        return disk.read();
    }
    public void writeDisk(Data data){
        disk.write(data);
    }
    public T getDisk(){
        return disk;
    }
    public void setDisk(T disk){
        return this.disk = disk;
    }

    public static void main(String[] args) {
        Computer<SSD> computer = new Computer<SSD>(new SSD());
        SSD disk = computer.getDisk(); // No cast needed
        //computer.setDisk(new HHD()); // error!
    }
}
```

---

## 泛型方法



---

## Rewrite 葫芦娃 with Generics



---

# END