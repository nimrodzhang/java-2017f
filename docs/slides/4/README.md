# 面向对象编程 - 一些细节

---


## Class

- 对象的“生成模板”
  + 属性（状态）
  + 方法（行为）
  

---

## 初始化（构造）

从”对象模版“生成“对象实例“

- 每个对象拥有一份属性拷贝
- 对象共享方法（代码）的定义
- 每个对象有一个标识（id）

---

## 构造函数（Constructor）

```java
class Human(){
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
class Human(){
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
class Human(){
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
class Man(){
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


```java
package cn.edu.nju;

class java-2017f{

}
```

组织管理、避免冲突、访问控制 （PP. 210-220)

---

# END