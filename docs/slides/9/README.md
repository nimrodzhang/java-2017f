
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

## 再定义一个Computer 

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

``` java
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1); //autoboxing
        gm.f(1.0);
        gm.f(1.0F);
        gm.f(‘c’);
        gm.f(gm);
    }
}
```

---

## 再看容器

``` java
public class Holder<T> {
    private T obj;
    public void set(T obj){
        this.obj = obj;
    }
    public T get(){
        return obj;
    }
    public static void main(String[] args){
        Holder<Integer> holder = new Holder<>();
        holder.set(1);
        //holder.set("Abc"); // error
        Integer obj = holder.get(); //无须cast
    }       
}
```
多完美！ <!-- .element: class="fragment" -->
可惜这只是编译时刻... 因为运行时的类型信息被擦掉了<!-- .element: class="fragment" -->

---

## 擦除

``` java
public class Computer<T extends Disk>{
    private T disk;   // 运行时disk是Disk类型
    Computer(T disk){
        disk = disk;
    }
}
```

<small>Java泛型的实现方式就是将类型参数用边界类型替换，在上面的例子中就是把T用Disk替换。这种实现方式看上去就像是把具体的类型（某种硬盘，机械的或者是固态的），擦除到了边界类型（它们的父类Disk)。</small>

---

## 擦除的后果

``` java
ppublic class Holder<T> {
    private T obj;
    public void set(T obj){
        this.obj = obj;
    }
    public T get(){
        return obj;
    }
    public void testT(Object arg){
        if (arg instanceof T){ ... } //编译错误
        T var = new T(); //编译错误
        T[] array = new T[100]; //编译错误
        }
    }
}
```

这劳什子有何用？！<!-- .element: class="fragment" -->

---

## T存在的意义
```java
public class Holder<T> {
    private T obj; //在编译时，该类中的所有的T都会被替换为边界类型Object。
    public void set(T obj){
        this.obj = obj;
    }
    public T get(){
        return obj;
    }
    public static void main(String[] args){
        Holder<Integer> holder = new Holder<>();
        //编译器会检查实参是不是一个Integer，
        //虽然这里的1是int类型，但是因为自动包装机制的存在，
        //他会被转化为一个Integer，因此能够通过类型检查。
        holder.set(1); 
        //编译器也会进行类型检查，
        //并且自动插入一个Object类型到Integer类型的转型操作。
        Integer obj = holder.get();
    }       
}
```

---

## 范型的实际实现

- 对泛型的处理全部集中在编译期，在编译时，编译器会执行如下操作。
  - 会将泛型类的类型参数都用边界类型替换。
  - 对于传入对象给方法形参的指令，编译器会执行一个类型检查，看传入的对象是不是类型参数所指定的类型。
  - 对于返回类型参数表示对象的指令，也会执行一个类型检查，还会插入一个自动的向下转型，将对象从边界类型向下转型到类型参数所表示的类型。


---

## 如果真想生成范型对象？

```java
class Holder<T>{
    private T t;
    public void init(IFactory<T> factory){
        this.t = factory.create();  // 此处即为new T()的工厂方法的实现
    }
}

interface IFactory<T>{  //接口也可以参数化
    T create();
}

class IntegerFactory implements IFactory<Integer>{
    public Integer create(){
        return new Integer(10);
    }
}

public class newTwithFactory{
    public static void main(String[] args){
        Holder<Integer> holder = new Holder<>();
        holder.init(new IntegerFactory());
    }
}
```

---

## 或者可以使用RTTI

``` java
class Holder<T>{
    private T t;
    private Class<T> kind;
    public Holder(Class<T> kind){
        this.kind = kind;
    }
    public void init(){
        try{
            this.t = kind.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Holder<Integer> holder = new Holder<>(Integer.class);
        holder.init();
    }
}
```

---


---

## Rewrite 葫芦娃 with Generics



---

# END