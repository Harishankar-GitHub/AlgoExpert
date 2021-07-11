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
- The data in the memory is actually ***stored in the form of bits***.
- Bits are ***0's and 1's***.

* ***1 memory slot*** can hold ***8 bits***. And this is called a ***Byte***.
* 8 bits = 1 Byte
* When a data is stored in a memory slot, it is actually a byte of data (8 bits).

- So, ***2 power 8*** is the ***maximum value*** that can be represented in ***1 byte***.

> *Number 1 is stored in the form of binary numbers like 
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

- So Number 1 is stored like.. 
> memorySlot1[0000 00001] memorySlot2[0000 0000] memorySlot3[0000 0000] memorySlot4[0000 0000]

- Why the byte that has Number 1 is stored in the left most byte ?
***[Endianness](https://en.wikipedia.org/wiki/Endianness)*** is a concept of ordering of bytes when representing a number in binary.