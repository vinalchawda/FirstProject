package com.fdmgroup.bookstore.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Runner1 {

	public static void main(String [] s) throws InterruptedException
	{
		Employee e = new Employee("vinal", 101);
		
		System.out.println(e.getName());
		System.out.println();
		
		Animal a = new Animal();
		a.eat();
		
		Animal a1 = new Dog();
		a1.eat();//Runtime Polymorphism or Method ovrriding
		
		Animal a2 = new Dog();
		a2.sit();
		a2.sit("Sam");//Compile time Polymorphism or Method overloading
		
		
		
	List<String> list=new ArrayList<String>();
	
	list.add("Pushpak");
	list.add("Vinal");
	
	for(String s1:list) {
		
		System.out.println(s1.equalsIgnoreCase("Pushpak"));
		
		
		Thread.sleep(100);
	}
	
	  try {
		  int aaaa=7/0;
	  }	
	  catch(Exception ex) {
		 // throw new Exception*(;)
		  
	  }
	}
}
