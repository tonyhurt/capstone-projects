package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> instructors = new ArrayList<String>();
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Andrew"); // need to add Rachelle under Andrew, needed at index 3 
		instructors.add("Stephanie");
		instructors.add("Carson");
		

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		
		for (int i = 0 ; i < instructors.size() ; i++) {
			System.out.println(instructors.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		instructors.add("John");
		
		for (int i = 0 ; i < instructors.size() ; i++) {
			System.out.println(instructors.get(i));
		}
		 
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		instructors.add(3, "Rachelle");
		
		for (int i = 0 ; i < instructors.size() ; i++) {
			System.out.println(instructors.get(i));
		}
		

		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		instructors.remove(6);
		
		for (int i = 0 ; i < instructors.size() ; i++) {
			System.out.println(instructors.get(i));
		}
		
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		if (instructors.contains("Andrew")) {
		System.out.println("Andrew is in the list");
		} else {
			System.out.println("Andrew is missing from the list");
		}
		
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		
		String[] instructorsArray = instructors.toArray( new String [instructors.size()] );

		
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");
		
		
		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object 
		 * representative of a primitive value */
		
		Integer employees = new Integer (25);
		Integer employees2 = 25;
		Integer piecesOfCake = new Integer("24");
		
		if (employees > piecesOfCake) { 
			System.out.println("Burn the building down");
		}
		
		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		
		Integer objX = 10;
		int intY = 20;
		intY = objX + 5;
		objX = intY + 10;
		
		Double accountBalance = null;
		//double newBalance = accountBalance + 100;
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
//		for (int i = 0 ; i < instructors.size() ; i++) {
//			System.out.println(instructors.get(i));
//		}
		
		 for ( String instructorName : instructors) {
			 System.out.println( instructorName );
		 }

		 double[] doubles = { 2.5d, 3.14d, 1.2d, 0.75d };
		 
		 for (double d : doubles) {
			 System.out.println(d);
		 }
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		
		Queue<String> tasks = new LinkedList<String>();
		
		tasks.offer("Clean dishes");
		tasks.offer("Sweep floor");
		tasks.offer("Clean counters");
		tasks.offer("Scrub ceiling");

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////

		while ( !tasks.isEmpty() ) {
			System.out.println("The next task is " +  tasks.poll() 
			+ " there are " + tasks.size() + " tasks left");
		}
		
		
		
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();
		
		Stack<String> history = new Stack<String>();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		history.push("http://www.techelevator.com");
		history.push("http://stackoverflow.com");
		history.push("https://google.com");
		history.push("https://dashboard.techelevator.com");

		
		////////////////////
		// POPPING THE STACK
		////////////////////
		
		while ( !history.isEmpty() ) {
			String previousPage = history.pop();
			System.out.println("Previous Page " + previousPage);
			
		}
		
		//Use Case: Reverse a List
		int [] nums = { 10, 20, 30, 40, 50 };
		
		Stack<Integer> numStack = new Stack<Integer>();
		
		for (int n : nums ) {
			numStack.push(n);
		}
		
		List<Integer> numList = new ArrayList<Integer>();
		while ( !numStack.isEmpty() ) {
			numList.add( numStack.pop() ); 
		}

	}
}
