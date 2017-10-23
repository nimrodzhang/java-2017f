
## Error Handling with Exceptions

#### "Badly formed code will not be run."

---

## Outline

<br/>
- Concepts
- Java Exception Mechanism
- Design by Contract vs. Exceptions 

---

## Software Reliability

<br/>
- Correctness 正确性
  + 依据规约，完成任务
- Robustness 鲁棒性
  + 异常情况，合理反应
- Integrity  完整性
  + 非法访问或修改，合理反应

---

## Design by Contract

<br/>

- 方法学层面的思想：以尽可能小的代价开发出可靠性出众的软件

- 可以贯穿于软件创建的全过程，从分析到设计，从文档到调试，甚至可以渗透到项目管理中


<br/>
> <small>Bertrand Meyer：DbC是构建面向对象软件系统方法的核心。</small>
<br/>
> <small>James McKim：“只要你会写程序，你就会写契约。”</small>

---

## Contract

<br/>
- Every software element is intended to satisfy a certain <font color=red>goal</font>, for the benefit of other software elements (and ultimately of human users). 
- This goal is the element’s <font color=red>contract</font>.  
  + The contract of any software element should be
<font color=red>Explicit</font>. 
  + Part of the software element itself.

---

## A view of software construction

<br/>
- Constructing systems as structured collections of cooperating software elements — <font color=red>suppliers</font> and <font color=red>clients</font> — cooperating on the basis of clear definitions of <font color=red>obligations</font> and <font color=red>benefits</font>.		
- These definitions are the contracts.

---

## 葫芦娃的契约

<br/>

|   | 义务| 权益|
| - | - | - |
| Client  | 不能混进蛇精蝎子精  | 由小到大给葫芦娃们排序 |
| Supplier| 帮葫芦娃们由小到大排序| 只排葫芦娃 |


---

## Properties of Contracts

<br/>
- Binds two parties (or more): supplier, client.
- Is explicit (written).
- Specifies mutual obligations and benefits. 
- Usually maps obligation for one of the parties into benefit for the other, and conversely. 

---

## Contracts

<br/>
- 契约就是<font color=red>“规范和检查”</font>！
  + Precondition：针对method，它规定了在调用该方法之前必须为真的条件
  + Postcondition：针对method，它规定了方法顺利执行完毕之后必须为真的条件
  + Invariant：针对整个类，它规定了该类任何实例调用任何方法都必须为真的条件

---

## 再看葫芦娃的契约

<br/>

|   | 义务| 权益 |
| - |-| -|
| Client   | "Satisfy Preconditon": 只排葫芦娃   | "From Postcondition": 葫芦娃们由小到大给排好序 |
| Supplier | "Satisfy Postconditon": 葫芦娃们由小到大排好序| "From Precondition":只排葫芦娃          |


---

## Exception Handling and DbC

<br/>
- Exceptions are about dealing with things going wrong at <font color=red>runtime</font>.

- DbC is about <font color=red>statically</font> defining the conditions under which code is supposed to operate. 

---

## What are Exceptions?

- Many “exceptional” things can happen during the running of a program, e.g.:
  + <font color=green>User mis-types input</font>
  + <font color=green>Web page not available</font>
  + <font color=green>File not found</font>
  + <font color=#0099ff>Array index out of bounds</font>
  + <font color=#0099ff>Method called on a null object</font>
  + <font color=pink>Out of memory</font>
  + <font color=pink>Bug in the actual language implementation</font>

<span style="color:red">Exceptions are unexpected conditions in programs.</span><!-- .element: class="fragment" -->

---

## What do we want of exceptions?

- Ideally, a language (and its implementation) should:

  +  <font size=6><font color=red>Restrict</font> the set of possible exceptions to “reasonable” ones.</font>
  + <font size=6>Indicate <font color=red>where</font> they happened, and <font color=red>distinguish</font> between them.</font>
  + <font size=6>Allow exceptions to be dealt with in a <font color=red>different</font> place in the code from where they occur.</font>
  + <font size=6>so we <font color=#0099ff>throw</font> exceptions where they <font color=red>occur</font>, and <font color=#0099ff>catch</font> them where we want to <font color=red>deal with</font> them.</font>


---

## What do we want of exceptions?

<br/>
- Ideally, we don't want non-fatal exceptions to be thrown too far — this breaks up the modularity of the program and makes it hard to reason about.

---

## Exceptions in Java

- If a thrown exception is <font color=red>not</font> caught, it <font color=red>propagates out</font> to the caller and so on until <font color=#0099ff>**main**</font>. 

- If it is <font color=red>never</font> caught, it <font color=red>terminates</font> the program.

- If a method can generate (checked) exceptions but does <font color=red>not</font> handle them, it has to explicitly <font color=red>declare</font> that it throws them so that clients know what to expect.

---

## Exceptions in Java

<br/>
- In Java, the basic exception handling construct is to:
  + <font color=red>try</font>: a block of code which normally executes ok
  + <font color=red>catch</font>: any exceptions that it generates, and
  + <font color=red>finally</font>: do anything we want to do irrespective of what happened before. 


---

## Catch Exceptions

<br/>
```java
try{
  //Code that might generate exceptions
}
catch (ExceptionType1 e1){
  //Handle exceptions of ExceptionType1
}
catch (ExceptionType2 e2){
  //Handle exceptions of ExceptionType2
}
catch (ExceptionType3 e3){
  //Handle exceptions of ExceptionType3
}
finally{
  //Activities that happen every time
}
```

<span style="color:#0099ff">Termination vs. Resumption</span><!-- .element: class="fragment" -->

---

## Catch Ordering

- All ***catch*** clauses are checked in order. An error occurs if the super-type is arranged before the sub-type.

```java
class SuperException extends Exception { }
class SubException extends SuperException { }
class BadCatch {
  public void goodTry() {
    try { 
      throw new SubException();
    } catch (SuperException superRef) { 
      ...
    } catch (SubException subRef) {
      ...// never be reached
    } // an INVALID catch ordering
  }
}
```

---

## Catch Ordering

<br/>

- If exceptions are thrown in current "catch" and "finally", the "catch" clauses will not be rechecked. They are passed to the outside.

---

## Report Exceptions

<br/>

- Declare and Throw

```java
public boolean method(int x) throws MyException{
    //some code
    throw new MyException(...);
}
```

<span style="color:#0099ff">Exception Propagation</span><!-- .element: class="fragment" -->

---

## Create Exceptions

<br/>
```java
class SimpleException extends Exception{}

public class InheritingExceptions {
  public void f() throws SimpleException {
    System.out.println("Throw SimpleException from f()");
    throw new SimpleException();
  }

  public static void main(String[] args){
    InheritingExceptions sed = new InheritingExceptions();
    try{
      sed.f();
    } catch(SimpleException e){
      System.out.println("Caught it!");
    }
  }
}
```

---

## Getting information from exceptions

- java.lang.Throwable

```java
public Throwable();
public Throwable(String message);
public Throwable(String message, Throwable cause);
public Throwable(Throwable cause);

```


```java
public String getMessage();
public String getLocalizedMessage();
public String toString();
public void printStackTrace();

```

---

## Rethrowing exceptions

<br/>
```java
try {
  // some statements;
}
catch(TheException ex) {
  //perform operations before exits;
  throw ex;
}

```

---

## Chained Exception

<br/>
```java
public class ChainedExceptionDemo {
  public static void main(String[] args) {
    try {
      method1();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public static void method1() throws Exception {
    try {
      method2();
    }
    catch (Exception ex) {
      throw new Exception("New info from method1", ex);
    }
  }
  public static void method2() throws Exception {
      throw new Exception("New info from method2");
  }
}

```

---

## Chained Exception

![](http://yp.njuics.cn:7911/exceptions.jpg)<!-- .element height="60%" width="60%" -->

---

## Exception matching

- When an exception is thrown, the exception-handling system looks through the <font color=red>"nearest"</font> handlers in the order they are written. When it finds a match, the exception is considered handled, and no further serarching occurs.

- A derived-class object will match a handler for the base class.

---

## Example

<br/>
```java

class Annoyance extends Exception{}
class Sneeze extends Annoyance{}

public class Human{
  public static void main(String[] args){
    try{
      throw new Sneeze();
    } catch(Sneeze s){
      System.out.println("Caught Sneeze");
    } catch(Annoyance a){
      System.out.println("Caught Annoyance");
    }

    try{
      throw new Sneeze();
    } catch(Annoyance a){
      System.out.println("Caught Annoyance");
    }
  }
}

```


---

## Exceptions and Logging

- 1: Send error output to the *standard error* stream by writing to **System.err**.

```java
class MyException extends Exception{
  public MyException(){}
  public MyException(String msg){super(msg);}
}

public class FullConstructors {
  public static void f() throws MyException{
    System.out.println("Throwing MyException from f()");
    throw new MyException();
  }
  public static void g() throws MyException{
     System.out.println("Throwing MyException from g()");
    throw new MyException("Originated in g()");
  }

  public static void main(String[] args){
    try{
      f();
    } catch(MyException e){
      e.pringStackTrace(System.out);
    }
    try{
      g();
    } catch(MyException e){
      e.printStackTrace(System.out);
    }
  }
}
```
<span style="color:red"><font size=6>e.printStackTrace()</font></span><!-- .element: class="fragment" -->

---

## Exception and Logging

- 2: Log the output using the **java.util.logging** facility.

```java
import java.util.logging.*;
import java.io.*;

class LoggingException extends Exception{
  private static Logger logger = Logger.getLogger("LoggingException");
  public LoggingException(){
    StringWriter trace = new StringWriter();
    printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }
}

public class LoggingExceptions{
  public static void main(String[] args){
    try{
      throw new LoggingException();
    } catch(LoggingException e){
      System.err.println("Caught "+e);
    }
  }
}

```

---

## Classification of Errors

- <font color=red>*Syntax errors*</font> arise because the rules of the language have not been followed. They are detected by the compiler.

- <font color=red>*Runtime errors*</font> occur while the program is running if the environment detects an operation that is impossible to carry out.

- <font color=red>*Logic errors*</font> occur when a program doesn't perform the way it was intended to.

---

## Java Exceptions

<br/>
![](http://www.plantuml.com/plantuml/png/XP5D3e8m44RtFGKNu0Pkq6X2ejGOekjIHbejhMcdaOM7D_m4J96mQx_t9fEPeSK3E4QRJnn7kR3cpGe5P7prODzmUA4qUWQiDPQCk0ztYZcN6JmOhykfDB1IkeYIMxx8A0gmO-P2VF4QPGrJEGcJeOMLA6f0oIVrlvbvfSv6Qlnfkw2ckeI6UgJtRJkwM_MLWegfn5Q-1erhUZTwY1mXtH5wvIZrarKmd6NAhzAYP-h4k91wZjk5Xrc_wFRllW00)

---

## System Errors

<br/>
- <font color=red>System errors</font> are thrown by JVM and represented in the <font color=#0099ff>***Error***</font> class. The <font color=#0099ff>***Error***</font> class describes internal system errors. Such errors rarely occur.
- If one does, there is little you can do beyond
notifying the user and trying to terminate the
program gracefully.

---

## Exceptions

<br/>
- <font color=red>Exceptions</font> are represented in the <font color=#0099ff>***Exception***</font> class that describes errors caused by your program and external circumstances. These errors can be caught and handled by your program.

---

## Runtime Exceptions

<br/>
- <font color=red>Runtime exceptions</font> are represented in the
<font color=#0099ff>***RuntimeException***</font> class that describes programming
errors, such as bad casting, accessing an out-of-bounds
array, and numeric errors.

---

## Checked Exceptions vs. Unchecked Exceptions

- ***RuntimeException***, ***Error*** and their subclasses are known as <font color=red>unchecked exceptions</font>.
   - In most cases, unchecked exceptions reflect programming logic errors that are not recoverable.
     - For example: *NullPointerException*,
*IndexOutOfBoundsException*


---

## Checked Exceptions vs. Unchecked Exceptions

- These are the logic errors that should be corrected in the program. Unchecked exceptions can occur anywhere in the program. To avoid cumbersome overuse of try-catch blocks, Java does not mandate you to write code to catch unchecked exceptions.

- All other exceptions are known as <font color=red>checked
exceptions</font>, meaning that the compiler forces the
programmer to check and deal with the exceptions.


---

## Tips

- Exception handling is not supposed to replace a simple test.

case a:
```java
If (!s.empty()) s.pop();

```
case b:
```java
try { //10 times longer than (a)
   s.pop();
}
catch (EmptyStackException e){
}
```
<span style="color:red">Which one is better?</span><!-- .element: class="fragment" -->

---

## Tips

- Do not micromanage exceptions.


```java
for (i=0 ; i<100; i++) {
  try { n=s.pop(); }
  catch (EmptyStackException s) {...}
  try { out.writeInt(n); }
  catch (IOException e) {...}
}

```

case b:
```java
try { 
  for (i=0 ; i<100; i++) { n=s.pop(); out.writeInt(n);}
}
catch (IOException e) {...}
catch (EmptyStackException s) {...}
```
<span style="color:red">Which one is better?</span><!-- .element: class="fragment" -->

---

## Tips

<br/>
- Create custom exception classes if the predefined classes are not sufficient.
- Calculate some alternative result instead of what the method was supposed to.

---

## DbC vs. Exception

- Exceptions are about dealing with things going wrong at runtime.
- DbC is about statically defining the conditions under which code is supposed to operate.
- The two are nicely complementary.
- <font color=red>Unchecked exceptions</font> are “what happens when the contract is broken”.
- <font color=red>Checked exceptions</font> are expected to happen from time to time, so are not contract violations. 

---

## How about assertion?

**To be continued!**

---

# END