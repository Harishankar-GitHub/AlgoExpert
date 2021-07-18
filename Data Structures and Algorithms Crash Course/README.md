# AlgoExpert - Data Structures and Algorithms Crash Course

Complexity Analysis
-
> A problem can have many solutions.
Are they all same ? Which is better ?
What makes one solution better than another ?
***It is based on the complexity.***

> It is not about the complexity of the solution.
It is actually, the ***process of determining how efficient*** an algorithm is.
It usually ***involves finding both the time complexity and space complexity of an algorithm***.
		
> The ***faster an algorithm*** runs, the ***better the Time Complexity*** is.
***Less memory*** an algorithm takes, the ***better its Space Complexity is***.

> Complexity Analysis is effectively used to determine how ***"good"*** an algorithm is and
whether it's ***"better"*** than another one.
		
Time Complexity
-
> A measure of ***how fast an algorithm runs***, time complexity is a central concept in the field of algorithms and in coding interviews.

> ***It's expressed using Big O notation.***
		
Space Complexity
-
> A measure of ***how much auxiliary memory an algorithm takes up***, space complexity is a central concept in the field of algorithms and in coding interviews.

> ***It's expressed using Big O notation.***
	
Memory
-

#### 4 Key Terms

- ***Bit***

> Short for **binary digit**, a bit is a fundamental unit of information in Computer Science that represents a state with one of two values, typically **0** and **1**. 

- ***Byte***

> A group of 8 **bits**. For example 01101000 is a byte.
> A single byte can represent up to **256** data values (**2 power 8**).
> Since a **binary number** is a number expressed with 2 symbols, like **0** and **1**, a byte can effectively represent all of the numbers between 0 and 255, inclusive, in binary format. 

- The following bytes represent the numbers 1,2,3, and 4 in binary format. 
	- 1: 00000001
	- 2: 00000010
	- 3: 00000011
	- 4: 00000100

- ***Fixed-Width Integer*** 

> An integer represented by a fixed amount of bits. For example, a 32-bit integer is an integer represented by 32 bits (4 bytes), and a 64-bit integer is an integer represented by 64 bits (8 bytes).

> The following is the 32-bit representation of Number 1, with clearly separated bytes.
> `00000000 00000000 00000000 00000001`

> The following is the 64-bit representation of Number 10, with clearly separated bytes.
> `00000000 00000000 00000000 00000000 00000000 00000000 00000000 00001010`

> Regardless of how large an integer is, its fixed-width-integer representation is, by definition, made up of a constant number of bits.
> It follows that, regardless of how large an integer is, an operation performed on its fixed-width-integer representation consists of a constant number of bit manipulations, since the integer is made up of a fixed number of bits.

- ***Memory***

	- Broadly speaking, memory is the foundational layer of computing, where all data is stored.
	- In the context of coding interviews, it's important to note the following points:
		- Data stored in memory is stored in bytes, and by extension, bits.
		- Bytes in memory can "point" to other bytes in memory, so as to store references to other data.
		- The **amount of memory** the machine has is **bounded, making it valuable to limit how much memory an algorithm takes up**.
		- Accessing a byte or a fixed number of bytes (like 4 bytes or 8 bytes in the case of **32-bit** and **64-bit** integers) is an elementary operation, which can be loosely treated as a single unit of operational work.

---

#### ***How data is stored ?***

- The data in the memory is actually ***stored in the form of bits***.
- Bits are ***0's and 1's***.

* ***1 memory slot*** can hold ***8 bits***. And this is called a ***Byte***.
* 8 bits = 1 Byte
* When a data is stored in a memory slot, it is actually a byte of data (8 bits).

- So, ***2 power 8*** is the ***maximum value*** that can be represented in ***1 byte***.

> *Numbers stored in the form of binary numbers: 
1 = 0000 0001
2 = 0000 0010
3 = 0000 0011 etc.*

- The right most bit represents 2 power 0.
- The second right most bit represents 2 power 1 and so on.

* Any piece of data can be transformed into 1's and 0's into Base2 format or Binary Number format.
* Then that data is stored in blocks of 8 bits, in other words Byte.
* In 1 block of memory, we can store ***1 Byte*** and the ***maximum value of that is 2 power 8***.

#### *So how do we store data that is greater than 2 power 8 ?*

- We ***just increase the number of bits***.
- Imagine we have 32 bits or 64 bits.

* Type int represents a 32-bit integer *(In Java. Might vary for other languages)*.
* Type long represents a 64-bit integer *(In Java. Might vary for other languages)*.

- If we need to store 1 in the memory, it is stored as int.
- Type int is a 32-bit integer.
- So, 32-bit/8 = 4 Bytes.
- *Number 1 consumes 4 Bytes. i.e., It takes 4 back to back memory slots to store Number 1*.

* We ***need free memory slots*** to store data.
* Also, we ***need back to back, continuous memory slots***.

> ***For a 32-bit integer, it will take 4 memory slots.
For a 64-bit integer, it will take 8 memory slots.
Long would take more memory slots.***

- So ***Number 1 is stored like***.. 

| MemorySlot - 1 - `[0000 00001]` | MemorySlot - 2 - `[0000 0000]` | MemorySlot - 3 - `[0000 0000]` | MemorySlot - 4 -`[0000 0000]` |
|--|--|--|--|

- Why the byte that has Number 1 is stored in the ***left most byte*** ?
***[Endianness](https://en.wikipedia.org/wiki/Endianness)*** is a concept of ordering of bytes when representing a number in binary.

- ***How a list of numbers is stored ?***
	- The list of numbers is also stored the same way as Number 1 is stored.
	- For example: To store the list ***[1,2]***, we need 8 memory slots.
	- Because, 4 memory slots to store Number 1 and another 4 for Number 2.
	- Thus we need 8 back to back memory slots.

- ***How a string is stored ?***
	- A character can be mapped to a number.
	- [ASCII - American Standard Code for Information Interchange](https://en.wikipedia.org/wiki/ASCII)
		- [ASCII Table - W3Schools](https://www.w3schools.com/charsets/ref_html_ascii.asp)
		- [ASCII Table - https://ascii.cl/](https://ascii.cl/)
	- For instance, Character
		- ***"A"*** is mapped to ***65***
		- **"B"** is mapped to ***66*** and so on.
	- ***Every character*** in the string is ***mapped to a number using*** a mapping like ***ASCII***.
	- And those ***numbers*** are going to be ***turned to a bunch of bytes***.
	- And those ***bytes are stored as a list of numbers***.
	- This is how a string is stored.

- ***Pointers***
	- We can store the data not only in the form of Numbers/Strings but also ***the reference of another data***.
	- This is called Pointers.
	- ***For example***:
		- There's a ***memory slot with address 00010010***.
		- ***In this memory slot***, we need to ***store the data*** that is in ***another memory slot***.
		- So ***instead of storing the data again*** here, ***we can store the memory address of another memory slot*** where the data that we need is actually present.
