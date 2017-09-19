# 面向对象编程

---

## 编程范式 

Programming Pradigms

- 命令式编程 Imperative programming
  - Focuses on describing _how_ a program operates.
- 声明式编程 Declarative programming
  - Focuses on _what_ the program should accomplish without specifying how the program should achieve the result.

---

## 命令式编程

原始命令式 (汇编)

&rarr; 过程式 (Procedural programming): Fortran, ALGOL, COBOL and BASIC

&rarr; 结构化程序设计 (Structured programming): Pascal (C严格意义上不是结构化语言)

---


## 过程式编程

自顶向下，逐步求精。

---

## 结构化编程

有序控制，降低复杂度。

---

但是，他们都是面向“解空间”的。

即针对现实中“做什么”的问题直接给出在机器中“怎么做”的解决方案。

&nbsp;

<span style="color:green">**这种编程语言迫使我们以机器视角进行编程** </span> <!-- .element: class="fragment" -->

---

## 面向对象编程


## 从“用什么做”开始考虑

---

## 如何把大象装进冰箱？

为了把大象装进冰箱，需要3个过程。

1. 把冰箱门打开
2. 把大象装进去
3. 把冰箱门关上

每个过程有一个阶段性的目标，依次完成这些过程，就能把大象装进冰箱。


这是<span style="color:red">面向过程</span>。

---

## 如何把大象装进冰箱？

为了把大象装进冰箱，需要做三个动作（或者叫行为）。
每个动作有一个执行者，它就是对象。 

1. 冰箱，你给我把门打开
2. 大象，你给我钻到冰箱里去
3. 冰箱，你给我把门关上

每个执行者依次做这些动作，大象就装进了冰箱。

这是<span style="color:red">面向对象</span>

---

“面向过程”是做一件事，是对机器行为的说明；“面向对象”是造一堆东西，是对现实中对象的刻画。

---

_“面向对象编程的首要工作就是认识待解决问题所涉及的基本对象和他们间的相互关系”_
<div align="right"><small>- 徐家福，《对象式程序设计语言》</small></div>

然后通过将这些对象映射到计算机中，实现计算机对现实问题的模拟，得到与应用问题结构对应（一致）的程序系统结构。 <!-- .element: class="fragment" -->

<span style="color:gold">**这样使我们能从问题的角度进行编程**</span> <!-- .element: class="fragment" -->


---

Simula, 1967, Ole-Johan Dahl and Kristen Nygaard

Smalltalk, 1970s, Alan Kay

![AlanKay](https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Alan_Kay_%283097597186%29.jpg/1920px-Alan_Kay_%283097597186%29.jpg)  <!-- .element height="40%" width="40%" --> 

---

## 面向对象（Object Oriented）

- Everything is an object. 
- A program is a bunch of objects telling each other what to do, by sending messages. 

---

## 对象：现实世界中对象的映射和抽象
- Each object has its own memory, and is made up of other objects. 
- Every object has a type (class). 
- An object has an interface, determined by its class.

---

“你”、“我”、“他／她”：对象（Object）

“人”：类型（Class）

```java
class Human{

}
Human you, me, him, her;
```

---

![](http://www.shuoshuokong.org/uploads/allimg/160919/2-160919104204.jpg)

“你（对象）不是人（类型）！”

---

# END