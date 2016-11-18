# Array and Linear Search
**Array**

Typically, array elements are stored in adjacent memory cells. And index is used to calculate an offset to find the desired element.
>*Primitive int in Java is 4 bytes(32 bits).*

Assume we have address stand from 200. If we want the third data value, we take the address of the start of the array and the ***offset multiply the size of an array element*** to find the element we want.
>Location of data[2] is 200 + 2*4 = 208

An arrya in Java, in terms of manipulating its data, has one method, **clone()**, and one ***immutable field***, length.

In this case, we should use **java.util.Arrays class**. It has some static methods that are usefull working with arrays.

*Arrays.equals*
>To compare two array. Arrays.equals(a, b);
>Be aware that:
    - a.equals(b); // check identity
    - a == b; // check indentity
    - Arrays.equals(a, b) //check equality 

*Arrays.sort*
>Arrays.sort(a);

*Arrays.toString()*
>To print an array. System.out.println(Arrays.toString(a)); 

*Three ways to copy an array*
>1. int[] d = Arrays.copyOf(c, c.length);
    -  The second parameter specifies the length of the new array. It could be less, equal or bigger than the original length. And the rest are 0.
>2. int[] d = c.clone(); 
    - Shadow copy.
>3. System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
    - This is a better and more flexible way to copy data between arrays.

***Resize***
How can we resize the array?
> It is done by creating a new array with a different length and copying all or some of the values from the old array to the new array.




