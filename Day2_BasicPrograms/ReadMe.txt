Arrays :

Linear Data Structure
It contains Homogenous collection of elements
Continous memory allocation
Size is fixed
Store multiple values in a single variable of single data type
We can access an element using index number
Can be used to access the random elements 
Faster in accessing an elements becuase of having contiguous memory allocation 
and access it using index no's.
We can store both primitive and non-primitive type(reference type)
int[] 
Employees[]
Array elements can be modified or mutable and the index no's are numbered from 0 to n-1
Arrays are by default stored as an objects in java
Arrays are created dynamically during run time in java .
Arrays are created on the heap memory.

An exception - ArrayIndexOutOfBoundsException
an arrays in java can be duplicated with Object.clone()
Arrays.equals() method

Space/Memory wastage will be there if elements are not same as the size is 

int a =10 //  hold only one value at a time
int[] a = {3,4,5,6} // holds multiple values at a time.

use cases
In a class there are 60 students and we want to store their roll numbers 
int rollno1;
int rollno2;

Strings :

A String is a sequence of characters enclosed in double quotes

String name = "Niti"  

String is also reference type  -- An object of the String class (java.lang.String)

Immutable -- Once you have created , it cannot be changed

internally it works as  an character array


Some string functions :

length 
charAt(index)
equals(str)
indexOf()
toUpperCase()
toLowerCase()
substring(begin,end)
isEmpty
replace(old, new)
trim
startsWith
endsWith
split
contains



There are 3 types of control statements
1. Sequential  --- step by step
2. Iterational -- for , while(true) , dowhile (at least once the program will execution even if the condition is false)
3. Conditional Statements - if ( single if condition  , multiple if condition  , nested if conditions)


int i=10;
do
{

// statements
}
while(i>10)

while(i>=10)
{
//statements
i++;
}



for(int i=0 ; i>10 ; i++)
{
}


while(true)
{

sysout("Enter your choice : (1- ADD , 2-View , 3-Update , 4- Delete , 5 - Exite");
int choice = sc.nextInt();

switch(choice)

{

case 1:
 // statements 
 break;
case 2:
 // statements 
 break;
case 3:
 // statements 
 break;
case 4:
   system.exit(0);
   return;
default :
 // statements 
 break;




}


if(country="India")
 {
 }
 else if(state ="Delhi")
 {
 
 }
 else if()
 {
 }


