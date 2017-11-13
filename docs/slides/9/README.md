
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
class Stack<A>{
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


## Rewrite 葫芦娃 with Generics



---

# END