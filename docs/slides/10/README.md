
## 测试



---

## 软件测试

“使用人工和自动手段来运行或测试某个系统的过程，其目的在于检验它是否满足规定的需求或弄清楚预期结果与实际结果之间的差别。”

---


## 测试金字塔模型


![](https://res.infoq.com/news/2017/10/micro-service-build-test-culture/zh/resources/851-1509263405983.png)

Mike Cohn


---

## 测试过程

![](https://res.infoq.com/news/2017/10/micro-service-build-test-culture/zh/resources/492-1509263405982.png) <!-- .element height="50%" width="60%" -->

在软件开发中是一个很重要的方面，良好的测试可以在很大程度决定一个应用的命运。

---

## 单元测试 

单元测试中的“单元”在Java中可以理解为某个类中的某一个方法，因此“单元测试”就是针对Java中某个类中的某一个方法中的逻辑代码进行验证即测试该方法是不是可以正常工作。 


---

## 为什么需要进行单元测试

- 单元测试的测试相对于集成测试的测试成本较低
- 提高开发效率
- 提升项目工程代码质量
- 快速定位Bug

---

## 如何进行单元测试

- 第三方测试工具（框架）
  - JUnit
  - TestNG
  - Spock
  - ...

测试本身不是Java语言层面的内容


---

## JUnit

https://github.com/junit-team/junit4/wiki/Download-and-Install

---

## 简单示例

```java
public class Math {
    /**
     * 阶乘
     * @param n
     * @return
     */
    public int factorial(int n) throws Exception {
        if (n < 0) {
            throw new Exception("负数没有阶乘");
        } else if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
```

如何验证`factorial()`是对的？

---


## 编写一个“测试类”

``` java
import org.junit.Test;
import static org.junit.Assert.*;

public class MathTest {
    @Test
    public void testFactorial() throws Exception {
        assertEquals(120, new Math().factorial(5));
    }
}
```

---

## 在IDE中

---

为葫芦娃配上单元测试


---

# END