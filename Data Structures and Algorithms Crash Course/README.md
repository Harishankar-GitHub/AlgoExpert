# AlgoExpert - Data Structures and Algorithms Crash Course

Complexity Analysis
-

#### 3 Key Terms

- ***Complexity Analysis***

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
		
- ***Time Complexity***

> A measure of ***how fast an algorithm runs***, time complexity is a central concept in the field of algorithms and in coding interviews.

> ***It's expressed using Big O notation.***
		
- ***Space Complexity***

> A measure of ***how much auxiliary memory an algorithm takes up***, space complexity is a central concept in the field of algorithms and in coding interviews.

> ***It's expressed using Big O notation.***
	
Memory
-

> ***The bedrock of all data structures, memory is the underlying concept that you absolutely need to know in order to understand why data structures work the way they do.***

#### 4 Key Terms

- ***Bit***

> Short for **binary digit**, a bit is a fundamental unit of information in Computer Science that represents a state with one of two values, typically **0** and **1**. 

---

- ***Byte***

> A group of 8 **bits**. For example 01101000 is a byte.
> A single byte can represent up to **256** data values (**2 power 8**).
> Since a **binary number** is a number expressed with 2 symbols, like **0** and **1**, a byte can effectively represent all of the numbers between 0 and 255, inclusive, in binary format. 

- The following bytes represent the numbers 1,2,3, and 4 in binary format. 
	- 1: 00000001
	- 2: 00000010
	- 3: 00000011
	- 4: 00000100

---

- ***Fixed-Width Integer*** 

> An integer represented by a fixed amount of bits. For example, a 32-bit integer is an integer represented by 32 bits (4 bytes), and a 64-bit integer is an integer represented by 64 bits (8 bytes).

> The following is the 32-bit representation of Number 1, with clearly separated bytes.
> `00000000 00000000 00000000 00000001`

> The following is the 64-bit representation of Number 10, with clearly separated bytes.
> `00000000 00000000 00000000 00000000 00000000 00000000 00000000 00001010`

> Regardless of how large an integer is, its fixed-width-integer representation is, by definition, made up of a constant number of bits.
> It follows that, regardless of how large an integer is, an operation performed on its fixed-width-integer representation consists of a constant number of bit manipulations, since the integer is made up of a fixed number of bits.

---

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

Big O Notation
-

> ***The speed and memory usage of an algorithm aren't necessarily fixed; they might change depending on the input. So how do we express the performance of an algorithm then? Enter Big O Notation, a powerful tool that allows us to generalize the space-time complexity of an algorithm as a function of its input size.***

> The notation used to describe the ***time complexity*** and ***space complexity*** of algorithms.

> Variables used in Big O notation denote the size of inputs to algorithms. For example, ***O(n)*** might be the time complexity of an algorithm that traverses through an array of length ***n***; similarly, ***O(n+m)*** might be the time complexity of an algorithm that traverses through an array of length ***n*** and through a string of length ***m***.

> The following are examples of common complexities and their Big O notations, ordered from fastest to slowest:

- ***Constant:*** O(1)
- ***Logarithmic:*** O(log(n))
- ***Linear:*** O(n)
- ***Log-linear:*** O(nlog(n))
- ***Quadratic:*** O(n<sup>2</sup>)
- ***Cubic:*** O(n<sup>3</sup>)
- ***Exponential:*** O(2<sup>n</sup>)
- ***Factorial:*** O(n!)

> Note that in the context of coding interviews, Big O notation is usually understood to describe the ***worst-case*** complexity of an algorithm, even though the worst-case complexity might differ from the ***average-case*** complexity.

> For example, some sorting algorithms have different time complexities depending on the layout of elements in their input array. In rare cases, their time complexity will be much worse than in more common cases. Similarly, an algorithm that takes in a string and performs special operations on uppercase characters might have a different time complexity when run on an input string of only uppercase characters vs. on an input string with just a few uppercase characters.

> Thus, when describing the time complexity of an algorithm, it can sometimes be helpful to specify whether the time complexity refers to the average case or to the worst case (e.g., "this algorithm runs in O(nlog(n)) time on average and in O(n<sup>2</sup>) time in the worst case").

#### Example

Let's have an ***Array a = [. . .]***
***Length*** of the Array is ***N***

We have ***3 algorithms***,
- ***A<sub>1</sub>(a) => 1 + a[0]***
- ***A<sub>2</sub>(a) => sum(a)***
- ***A<sub>3</sub>(a) => pair(a)***
> ***Note: Assuming the array is always non-empty***

##### 1st Algorithm (A<sub>1</sub>(a))
> The logic of 1st Algorithm is 1 + a[0] which is nothing but ***adding 1 to the first element*** in the array.

##### 2nd Algorithm (A<sub>2</sub>(a))
> The logic of 2nd Algorithm is just ***adding all the elements*** in the array.

##### 2nd Algorithm (A<sub>3</sub>(a))
> The logic of 3rd Algorithm is to print the pairs.
> For instance, if the array had 3 elements [1,2,3] then the ***pairs*** would look like,
> ***1,1 | 1,2 | 1,3***
> ***2,3 | 2,2 | 2,3***
> ***3,1 | 3,2 | 3,3***

> If we have an ***array with 3 elements*** [1,2,3], then the ***execution time*** of all these algorithms might be ***very quick and similar, almost instant***.

> If we ***increase the size of the array to 10,000 elements*** ?
> Here we can ***notice the difference*** in the ***execution time*** between all 3 algorithms.

>- ***A<sub>1</sub>(a)*** ***will always have the same execution time*** irrespective of the array length.
>- ***A<sub>2</sub>(a)*** ***might take couple of seconds*** as it needs to calculate the sum of all the elements in the array.
>- ***A<sub>3</sub>(a)*** ***will take a lot of time*** as it needs to cover more number of combinations as the length of the array increases.

- So, one ***cannot determine the time complexity*** of an algorithm ***in terms of seconds or milliseconds etc***.
- We can clearly see that ***if the size of the array increases***, all 3 algorithms have ***difference in its execution time***.
- So the ***speed*** of these 3 algorithms clearly ***depend on the size of the array***.

>* So the Time Complexity of ***A<sub>1</sub>(a)*** is O(1) or Constant.
	- Because it doesn't depend on the size of the array.
>* The Time Complexity of ***A<sub>2</sub>(a)*** is O(n) or Linear.
	- As the size of the array increases, the time complexity also increases.
>* The Time Complexity of ***A<sub>3</sub>(a)*** is O(n<sup>2</sup>) or Quadratic.
	- For each iteration, we have to traverse through each element in the array.
	- So the time complexity is n * n that is O(n<sup>2</sup>) or Quadratic.

> This way of measuring applies to Space Complexity as well.

Logarithm
-

> A mathematical concept that's widely used in Computer Science and that's defined by the following equation:
> **log<sub>b</sub>(x) = y** if and only if **b<sup>y</sup> = x**

> In the context of coding interviews, the logarithm is used to describe the complexity analysis of algorithms, and its usage always implies a logarithm of base **2**. In other words, the logarithm used in the context of coding interviews is defined by the following equation:
> **log<sub>2</sub>(n) = y** if and only if **2<sup>y</sup> = n**
> This can also be written like: **log(n) = y** if and only if **2<sup>y</sup> = n**

> So what is log(1) ? The answer is the value of **y** in **2<sup>y</sup> = n**
> **log(1) = 2<sup>0</sup> = 1**, so **log(1) = 0**
> **log(4) = 2<sup>2</sup> = 4**, so **log(4) = 2**
> **log(16) = 2<sup>4</sup> = 4**, so **log(16) = 4**

> Basically to find **log(N)** we need to find **2<sup>?</sup> = N**

> **Another concept:**
> 2<sup>x</sup> = 2<sup>4</sup> = 2<sup>3+1</sup> = 2<sup>3</sup> * 2
> When the power is increased by 1, the value is doubled.
> In this example: 2<sup>4</sup> = 16
> 2<sup>5</sup> = 32
> Here, the power is increased from 4 to 5 and the value is doubled from 16 to 32.
> The more the value increases, the exponent or the power is increased by tiny amount.
> So this relation 2<sup>?</sup> = N is equal to log(N) = y (y is ?)
> This tells what log(N) really represents.
> log(N) increases only by a tiny amount as N increases.
> When N doubles, log(N) only increases by 1.

> When we relate this with the Time Complexity Analysis, when we have an algorithm with a Time Complexity of log(N), that is incredibly good because that means that as the input increases/doubles, the number of elementary operations that we perform in the algorithm only increases by 1.

> Hence the log(N) complexity is exceedingly better than a linear complexity.
> Even though the O(N), linear time is already pretty good for an algorithm, log(N) time is going to be way better as the size of the input increases.

> Why log(N) is so powerful ?
> if **2<sup>20</sup> = 1 Million** (For example)
> **2<sup>30</sup> = 1 Billion** (For example)
> The value increased from 1 Million to 1 Billion which is a huge difference but the log value increased just by 10 which is very small.
> The complexity of log(N) really represents a complexity that is not increased fast as the size of the input increases.

> **Example with an algorithm:**
> There's an array [0,1,2,3,4,5,6,7]
> We cut it half and eliminate the right side till we get 1 number and we process it.
> So after the first operation the array will look like [0,1,2,3]
> Then after second operation [0,1]
> Then after third operation [0]
> At every step, the algorithm cuts the array into half.
> In total, the amount of operations that we perform with this algorithm on the original array is basically equal to log(N).
> In this case log(8) where 8 is the size of the array.
> log(8) = 3 and we performed 3 operations in total in the algorithm.

> Now let us double the size of the array and we apply the same algorithm.
> [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
> In the first operation the array becomes half [0,1,2,3,4,5,6,7]
> After that the number of operations required to complete the algorithm is exactly equal when we had 8 elements in the previous example.
> The total operations when size is 8 is 3 and when the size is 16, the operations is 4, just increased by 1.
> Here, we doubled the input (N) but the log(N) is just increased by 1.

> So this algorithm has a time complexity of log(N).
> The number of operations that we perform with the algorithm increases only by 1 as we double the size of input. 

> In plain English, if an algorithm has a logarithmic time complexity (**O(log(n)**), where n is the size of the input), then whenever the algorithm's input doubles in size (i.e., whenever **n** doubles), the number of operations needed to complete the algorithm only increases by one unit. Conversely, an algorithm with a linear time complexity would see its number of operations double if its input size doubled.
> As an example, a linear-time-complexity algorithm with an input of size 1,000 might take roughly 1,000 operations to complete, whereas a logarithmic-time-complexity algorithm with the same input would take roughly 10 operations to complete, since **2<sup>10</sup> ~= 1,000**.

Arrays
-

> A linear collection of data values that are accessible at numbered indices, starting at index 0.
> The following are an array's standard operations and their corresponding time complexities:

 - **Accessing a value at a given index:** O(1)
 - **Updating a value at a given index:** O(1)
 - **Inserting a value at the beginning:** O(n)
 - **Inserting a value in the middle:** O(n)
 - **Inserting a value at the end:**
	 - Amortized (gradually write off the initial cost of an asset over a period) O(1) when dealing with a **dynamic array**
		 - In ***Java***, ***Array is Static Array*** and ***ArrayList is Dynamic Array***.
		 - In a Dynamic Array, when 1<sup>st</sup> element is inserted, the array looks like: ***[1]***
		 - When 2<sup>nd</sup> element is inserted, the array looks like: ***[1,2]***
		 - When the 3<sup>rd</sup> element needs to be inserted, the array automatically doubles the memory allocated. Now the array becomes ***[1,2, , ]***
		 - And then the 3rd element is inserted: ***[1,2,3, ]***
		 - So the ***memory is doubled when there's 1,2,4,8.. elements and so on***.
		 - This can also be written as ***O(1), O(2), O(4), O(8).. and so on***.
		 - When the last element is inserted, the memory will be doubled.
		 - Let's consider the last element as ***N***.
		 - Before that, the memory will be doubled when there is ***N/2*** elements.
		 - Before that it will be doubled when there is ***N/4, N/8.. and so on till 1***.
		 - The ***series N + N/2 + N/4 + N/8 .. till 1*** is mathematically known as ***2N***.
		 - So the insertion operation ***typically takes O(2N)*** which can be written as ***O(N)***
		 - ***O(N)*** is ***mathematically correct***.
		 - But ***conceptually***, insertion ***takes O(N) only when the memory of the array gets doubled***.
		 >- For example: if an array has ***8 elements*** and we try to ***insert 9<sup>th</sup> element***, the memory of the array gets ***doubled and becomes 16***. And then the 9<sup>th</sup> element gets inserted. After this, 10<sup>th</sup>, 11<sup>th</sup>, 12<sup>th</sup>, 13<sup>th</sup>, 14<sup>th</sup>, 15<sup>th</sup> and 16<sup>th</sup> elements are inserted at ***O(1) time complexity***.
		 >- As we get lot of O(1) insertions and very few O(N) insertions, the number of O(N) insertions become negligible. Therefore we ***conceptually*** consider ***O(1) as the insertion time in the Dynamic Array***.
	 - O(n) when dealing with a **static array**
 - **Removing a value at the beginning:** O(n)
 - **Removing a value at the middle:** O(n)
  - **Removing a value at the end:** O(1)
  - **Copying the array:** O(n)

> A ***static array*** is an implementation of an array that allocates a fixed amount of memory to be used for storing the array's values. Appending values to the array therefore involves copying the entire array and allocating new memory for it, accounting for the extra space needed for the newly appended value. This is a linear-time operation.

> A ***dynamic array*** is an implementation of an array that preemptively allocates double the amount of memory needed to store the array's values. Appending values to the array is a constant-time operation until the allocated memory is filled up, at which point the array is copied and double the memory is once again allocated for it. This implementation leads to an amortized constant-time insertion-at-end operation. 

> A lot of popular programming languages like JavaScript and Python implement arrays as dynamic arrays.

Linked Lists
-

> The data structure whose singular purpose in life is to be reversed. :stuck_out_tongue_winking_eye:

#### 3 Key Terms

- ***Singly Linked List***

> A data structure that consists of nodes, each with some value and a pointer to the next node in the linked list. A linked list node's value and next node are typically stored in ***value*** and ***next*** properties respectively.

> The first node in the linked list is referred to as the ***head*** of the linked list, while the last node in the linked list, whose ***next*** property points to the ***null*** value is known as the ***tail*** of the linked list.

> Below is the visual representation of a singly linked list whose nodes hold integer values:

> `0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null`

> A singly linked list typically exposes its head to its user for easy access. While finding a node in a singly linked list involves traversing through all of the nodes leading up to the node in question (as opposed to instant access with an array), adding or removing nodes simply involves overwriting ***next*** pointers (assuming that you have access to the node right before the node that you're adding or removing).

> The following are a singly linked list's standard operations and their corresponding time complexities:

* ***Accessing the head:*** O(1) 
* ***Accessing the tail:*** O(n)
* ***Accessing a middle node:*** O(n)
* ***Inserting/Removing the head:*** O(1)
* ***Inserting/Removing the tail:*** O(n) to access + O(1)
* ***Inserting/Removing a middle node:*** O(n) to find where to insert + O(1) to create new node
* ***Searching for a value:*** O(n)

---

- ***Doubly Linked List***

> Similar to a ***singly linked list***, except that each node in a doubly linked list also has a pointer to the previous node in the linked list. The previous node is typically stored in a ***prev*** property.

> Just as the ***next*** property of a doubly linked list's ***tail*** points to the ***null*** value, so too does the ***prev*** property of a doubly linked list's head.

> Below is a visual representation of a doubly linked list whose nodes hold integer values.

> `null <- 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 -> null` 

> While a doubly linked list typically exposes both its head and tail to its user, as apposed to just its head in the case of a singly linked list, it otherwise behaves very similarly to a singly linked list.

> The following are a doubly linked list's standard operations and their corresponding time complexities:

* ***Accessing the head:*** O(1) 
* ***Accessing the tail:*** O(1)
* ***Accessing a middle node:*** O(n)
* ***Inserting/Removing the head:*** O(1)
* ***Inserting/Removing the tail:*** O(1)
* ***Inserting/Removing a middle node:*** O(n) to find where to insert + O(1) to create new node
* ***Searching for a value:*** O(n)

---

- ***Circular Linked List***

> A linked list that has no clear ***head*** or ***tail***, because its *"tail"* points to its *"head"*, effectively forming a closed circle.

> A circular linked list can be either a ***singly circular linked list*** or a ***doubly circular linked list***.

---

> ***Linked List*** is very ***similar***, at least conceptually to an ***Array***.
> Where ***Linked List differs*** from an Array is ***how it is implemented*** or ***how it is stored in memory***.
> ***Linked Lists*** are gonna ***store elements anywhere in the memory*** and they are gonna ***connect the elements using pointers***.

#### ***How the elements in the Linked List are stored ?***

>- ***In memory***, an element in the linked list is ***stored*** in a structure called ***Node***.
>- A Node contains the ***Value*** and ***Address*** of the next element, ***basically 2 memory slots***. 1 for the Value and another one for the Address of the next element.
>- The ***next element can be anywhere in the memory*** (not necessary to be in the next memory slot or contiguous).
>- The ***node of the last element*** in the linked list (Singly Linked List) will have the value in 1 memory slot and another memory slot will have nothing or rather it will point to something like null address.
>- This is ***common among Linked Lists*** (Singly, Doubly and Circular).
>- In the memory canvas, there are certain addresses that kind of act like null value or none value in coding.

Hash Tables
-

> A data structure that provides fast insertion, deletion, and lookup of key/value pairs.

> ***Under the hood***, a hash table uses a ***dynamic array*** of linked lists to efficiently store key/value pairs. When inserting a key/value pair, a hash function first maps the key, which is typically a string (or any data that can be hashed, depending on the implementation of the hash table), to an integer value and, by extension, to an index in the underlying dynamic array. Then, the value associated with the key is added to the linked list stored at that index in the dynamic array, and a reference to the key is also stored with the value.

> Hash Tables rely on highly optimized hash functions to minimize the number of ***collisions*** that occur when storing values: cases where two keys map to the same index.

> Below is an example of what a hash table might look like under the hood:

```
[
	0: (value1, key1) -> null
	1: (value2, key2) -> (value3, key3) -> (value4, key4)
	2: (value5, key5) -> null
	3: (value6, key6) -> null
	4: null
	5: (value7, key7) -> (value8, key8)
	6: (value9, key9) -> null
]
```

> In the hash table above, the keys ***key2***, ***key3***, and ***key4*** collided by all being hashed to ***1***, and the keys ***key7*** and ***key 8*** collided by both being hashed to ***5***.

> The following are a hash table's standard operations and their corresponding time complexities:

- ***Inserting a key/value pair:*** O(1) on average; O(n) in the worse case
- ***Removing a key/value pair:*** O(1) on average; O(n) in the worse case
- ***Looking up a key:*** O(1) on average; O(n) in the worse case

> The worst-case linear-time operations occur when a hash table experiences a lot of collisions, leading to long linked lists internally, which take O(n) time to traverse.

> However, in practice and especially in coding interviews, we typically assume that the hash functions employed by hash tables are so optimized that collisions are extremely rare and constant-time operations are all but guaranteed.

---

Stacks and Queues
-

#### 2 Key Terms

> Push. Pop. FIFO. LIFO. That pretty much sums up stacks and queues.

- ***Stack***

> An array like data structure whose elements follow the ***LIFO*** rule: **L**ast **I**n **F**irst **O**ut.

> A stack is often compared to a stack of books on a table; the last book that's placed on the stack of books is the first one that's taken off the stack.

> The following are a stack's standard operations and their corresponding time complexities:
- ***Pushing an element onto the stack:*** O(1)
- ***Popping an element off the stack:*** O(1)
- ***Peeking at the element on the top of the stack:*** O(1)
- ***Searching for an element in the stack:*** O(n)

> A stack is typically implemented with a ***dynamic array*** or with a ***singly linked list***.

- ***Queue***

> An array like data structure whose elements follow the ***FIFO*** rule: **F**irst **I**n **F**irst **O**ut.

> A queue is often compared to a group of people standing in line to purchase items at a store: the first person to get in line is the first one to purchase items and to get out of the queue.

> The following are a queue's standard operations and their corresponding time complexities:
- ***Enqueuing an element into the queue:*** O(1)
- ***Dequeuing an element out of the queue:*** O(1)
- ***Peeking at the element at the front of the queue:*** O(1)
- ***Searching for an element in the queue:*** O(n)

> A queue is typically implemented with a ***doubly linked list***.

Strings
-

> Not a standalone data structure per se, strings are generally considered to be a data type that behaves like a data structure.

> One of the fundamental data types in Computer Science, strings are stored in ***memory*** as ***arrays*** of integers, where each character in a given string is mapped to an integer via some character-encoding standard like ***ASCII***.

> Strings behave much like normal arrays, with the main distinction being that, in most programming languages (C++ is a notable exception), strings are ***immutable***, meaning that they can't be edited after creation. This also means that simple operations like appending a character to a string are more expensive than they might appear.

> The canonical example of an operation that's deceptively expensive due to string immutability is the following:
```
string = "this is a string"
newString = ""

for character in string:
	new string += character
```
> The operation above has a time complexity of ***O(n<sup>2</sup>)*** where n is the length of the ***string***, because each addition of a character to ***newString*** creates an entirely new string and is itself an ***O(n)*** operation. Therefore, ***n O(n)*** operations are performed, leading to an ***O(n<sup>2</sup>)*** time-complexity operation overall.

- ***Traverse a String:*** O(n) T, O(1) S
- ***Copying a String:*** O(n) ST
- ***Get a character:*** O(1) ST
- ***Adding/Updating a String:*** O(n) ST

Graphs
-

> These collections of edges and vertices might look as banal as a child's scribble on a restaurant table, but they're of fundamental importance in discrete mathematics. The eponymous field of "graph theory" is dedicated to their study, and their importance in mathematics carries over to computer science.

#### 7 Key Terms

- ***Graph***

> A collection of nodes or values called ***vertices*** that might be related; relations between vertices are called ***edges***.

> Many things in life can be represented by graphs; for example, a social network can be represented by a graph whose vertices are users and whose edges are friendships between the users. Similarly, a city map can be represented by a graph whose vertices are locations in the city and whose edges are roads between the locations.

- ***Graph Cycle***

> Simply put, a cycle occurs in a ***graph*** when three or more ***vertices*** in the graph are connected so as to form a closed loop.

> Note that the definition of a graph cycle is sometimes broadened to include cycles of length two or one; in the context of coding interviews, when dealing with the questions that involve graph cycles, it's important to clarify what exactly constitutes a cycle.

- ***Acyclic Graph***

> A ***graph*** that has ***no cycles***.

- ***Cyclic Graph***

> A ***graph*** that has ***at least one cycle***.

- ***Directed Graph***

> A ***graph*** whose edges are directed, meaning ***that they can only be traversed in one direction***, which is specified.

> For example, a graph of airports and flights would likely be directed, since a flight specifically goes from one airport to another (i.e., it has a direction), without necessarily implying the presence of a flight in the opposite direction.

- ***Undirected Graph***

> A graph whose edges are undirected , meaning ***they can be traversed in both directions***.

> For example, a graph of friends would likely be undirected, since a friendship is, by nature, bidirectional.

- ***Connected Graph***

> A graph is connected if ***for every pair of vertices*** in the graph ***there's a path of one or more edges*** connecting the given vertices.

> In case of a ***directed graph***, the graph is:
- ***strongly connected*** if there are ***bidirectional*** connections ***between the vertices of every pair of vertices*** (i.e., for every vertex-pair *(u,v)* you can reach *v* from *u* and *u* from *v*)
- ***weakly connected*** if there are ***connections*** (but ***not necessarily bidirectional ones***) between the vertices of every pair of vertices.

> A graph that isn't connected is said to be ***disconnected***.

---

> ***Connectivity***, ***Direction*** and ***Cycles*** are three very ***important concepts*** in Graphs.

> The following are a graph's standard operations and their corresponding time and space complexities:
- ***Space Complexity for storing a Graph:*** O(V + E)
- ***Time Complexity for traversing a Graph:*** O(V + E)
	- ***V*** - Vertices
	- ***E*** - Edges
- ***Traversing a Graph:***
	- ***2*** main traversal ***methods***:
		- ***DFS*** (***D***epth ***F***irst ***S***earch)
		- ***BFS*** (***B***readth ***F***irst ***S***earch)

> ***Depth First Search*** - Traversing the graph deeper first.
> ***Breadth First Search*** - Traversing wider before going deep.

Trees
-

> A special type of graph, trees excel at storing data hierarchically and are ***commonly used as a means of testing your knowledge of recursion during coding interviews***.

#### 7 Key Terms

- ***Tree***

> A ***data structure that consists of nodes***, each with some ***value*** and ***pointers to child-nodes***, which recursively form subtrees in the tree.

> The first node in a tree is referred to as the ***root*** of the tree, while the nodes at the bottom of the tree (the nodes with no child-nodes) are referred to as ***leaf nodes*** or simply ***leaves***. The ***paths*** between the root of a tree and its leaves are called ***branches***, and the ***height*** of a tree is the length of its longest branch. The ***depth*** of a tree node is its distance from its tree's root; this is also known as the node's ***level*** in a tree.

> A tree is effectively a ***graph*** that's ***connected***, ***directed***, and ***acyclic***, that has an explicit root node, and whose nodes all have a single ***parent*** (except for the root node, which effectively has no parent). Note that in most implementations of trees, tree nodes don't have a pointer to their parent, but they can if desired.

> There are many ***types of trees*** and tree-like structures, ***including binary trees***, ***heaps***, and ***tries***.

- ***Binary Tree***

> A tree whose ***nodes have up to two child-nodes***.

> The structure of a binary tree is such that ***many of its operations have a logarithmic time complexity***, making the binary tree an incredibly attractive and commonly used data structure.

- ***K-ary Tree***

> A tree whose ***nodes have up to k child-nodes***. A binary tree is a k-ary tree where ***k == 2***.

- ***Perfect Binary Tree***

> A binary tree ***whose interior nodes all have two child-nodes*** and ***whose leaf nodes all have same depth***. Example:
```
								    1
				    /								\
					2								3
		/					\			/						\
		4					5			6						7
	/		\			/		\	/		\				/		\
	8		9			10		11	12		13				14		15
```

- ***Complete Binary Tree***

> A binary tree that's almost perfect; its ***interior nodes all have two child-nodes***, but its ***leaf nodes don't necessarily all have the same depth***. Furthermore, the ***nodes in the last level*** of a complete binary tree are ***as far left as possible***. Example:
```
									 1
				    /								\
					2								3
		/					\			/						\
		4					5			6						7
/				\
8				9
```
> Conversely, the ***following binary tree isn't complete***, because the ***nodes in its last level aren't as far as left as possible***.
```
									 1
				    /								\
					2								3
		/					\			/						\
		4					5			6						7
							/			\
							8			9
```

- ***Balanced Binary Tree***

> A binary tree whose ***nodes all have left and right subtrees whose heights differ by no more than 1***.

> A balanced binary tree is such that the ***logarithmic time complexity*** of its operations is ***maintained***.

> For example, ***inserting a node at the bottom*** of the following ***imbalanced binary tree***'s left subtree would clearly ***not be a logarithmic-time operation***, since it would ***involve traversing through most of the tree's nodes***:
```
										1
								    /		\
									2		3
								/
								4
							/
							8
						/
						10
```
> The following is an example of a ***balanced binary tree***:
```
								    1
				    /								\
					2								3
		/					\			/						\
		4					5			6						7
	/		\			/
	10		9			8
```

- ***Full Binary Tree***

> A binary tree whose ***nodes all have either two child-nodes or zero child-nodes***. Example:
```
										1
								    /		\
									2		3
										/		\
										6		7
									/		\
									8		9
```

---

- ***Storing a tree*** (whatever type of tree it may be): O(n)
- ***Traversing a tree:*** O(n)

---