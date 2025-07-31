package com.example;

class Person
{
	
int id;
String name;

public Person(int id, String name) {
	
	this.id = id;
	this.name = name;
}

public Person()
{
	
	this(101 , "Niti");   // constructor chaining

}

public void display()
{
	
	System.out.println("ID :" + this.id + "Name :" + this.name );
}

// this cannot be used in static 
//static 
//{
//this.id = 30;	
//}

static
{
	
System.out.println("Static Block Called :");	
}

}

public class ThisKeywordExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p = new Person();
		p.display();

	}

}
