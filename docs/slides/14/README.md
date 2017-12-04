
## 输入输出

<small>I/O是Java最重要的API之一</small>

<small>https://docs.oracle.com/javase/tutorial/essential/io/index.html</small>

🚺

---

## java.io

- 标准Java包
  + 定义输入/输出类
  + 支持console，files，network connections......
  + 支持raw I/O（未经处理的二进制数据），formatted I/O（经过一定编码处理后符合某种特定格式的数据）
  + 不支持绘制和显示图形界面，不支持鼠标
- 基于Stream

---

## Stream

- A ***stream*** is an abstraction of the continuous one-way flow of data.
- 流是一种有序的字节数据对象。流又分为输入流（InputStream）和输出流（OutputStream）。输入流从外部资源（文件，内存，socket等）读入字节数据到Java对象；输出流则把Java对象（字节数据等）写入到外部资源。
- 所有Java I/O都可以归类为以下两类：1.字节数据输入输出I/O；2.字符数据输入输出I/O。

---

## Stream

![](http://yp.njuics.cn:7911/Stream.jpeg)<!-- .element height="60%" width="60%" -->

---

## Input Stream

- source可以是键盘输入、磁盘文件、物理设备、另外一个程序，或者同一个程序中的数组或字符串

![](http://yp.njuics.cn:7911/InputStream.jpeg)<!-- .element height="60%" width="60%" -->

---

## Output Stream

- destination可以是控制台、磁盘文件、物理设备、另外一个程序，或者同一个程序中的数组或字符串

![](http://yp.njuics.cn:7911/OutputStream.jpeg)<!-- .element height="60%" width="60%" -->

---

## 流的特性

- FIFO：先进先出，最先写入输出流的数据最先被输入流读到
- 顺序存取：可以一个接一个地往流中写入一串字节，读出时也将按写入顺序读取一串字节，不能随机访问中间的数据。
- 只读或只写，每个流只能是输入流或输出流的一种，不能同时具备两个功能，在一个数据传输通道中，如果既要写又要读，则要分别提供两个流。

<span style="color:#0099ff">特例：RandomAccessFile</span><!-- .element: class="fragment" -->

---

## 字节流 vs 字符流

- 面向字节的流（Byte Stream）：数据的处理以字节为基本单位
  + 每次读写8位二进制，也称为二进制字节流或位流
- 面向字符的流（Character Stream）：用于字符数据的处理
  + 一次读写16位二进制，并将其作为一个字符而不是二进制位来处理

<span style="color:#0099ff">Java语言的字符编码采用的是16位的Unicode码，而普通文本文件中采用的是8位ASCII码</span><!-- .element: class="fragment" -->


---

## 面向字节的输入流

- 字节流以字节为传输单位，用来读写8位的数据，除了能够处理纯文本文件之外，还能用来处理二进制文件的数据。
- InputStream类（抽象类）中包含一套所有输入都需要的方法，可以完成最基本的从输入流读入数据的功能。

![](http://yp.njuics.cn:7911/ByteInputStreamTree.png)<!-- .element height="60%" width="60%" -->


---

## 面向字节的输出流

- OutputStream类（抽象类）中包含一套所有输出都需要的方法，可以完成最基本的向输出流写入数据的功能。表10-8列出了其中常用的方法及说明。 

![](http://yp.njuics.cn:7911/ByteOutputStreamTree.jpg)<!-- .element height="60%" width="60%" -->

---

## 面向字符的输入流

- 字符流是针对字符数据的特点进行过优化的，因而提供一些面向字符的有用特性，字符流的源或目标通常是文本文件。
- Reader和Writer的子类又可以分为两大类：一类用来从数据源读入数据或往目的地写出数据（称为节点流），另一类对数据执行某种处理（称为处理流）。

![](http://yp.njuics.cn:7911/ReaderTree.jpg)<!-- .element height="60%" width="60%" -->


---

## 面向字符的输出流

![](http://yp.njuics.cn:7911/WriterTree.jpg)<!-- .element height="60%" width="60%" -->


---

## 缓冲流

- <font size=6>为了提高数据的传输效率，引入了缓冲流（Buffered Stream）的概念，即为一个流配备一个缓冲区（Buffer），一个缓冲区就是专门用于传送数据的一块内存。</font>

- <font size=6>当向一个缓冲流写入数据时，系统将数据发送到缓冲区，而不是直接发送到外部设备。缓冲区自动记录数据，当缓冲区满时，系统将数据全部发送到相应的外部设备。</font>

- <font size=6>当从一个缓冲流中读取数据时，系统实际是从缓冲区中读取数据，当缓冲区为空时，系统就会从相关外部设备自动读取数据，并读取尽可能多的数据填满缓冲区。</font>

---

让你的葫芦娃们抖动起来！


---

# END