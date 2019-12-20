package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
	
	private PrintWriter out;
	private Scanner in;
	
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	
	public int menuOne() {
		out.println("Menu ONE");
		out.println("(1) Go to next menu");
		out.println("(2) Quit");
		out.flush();
		return in.nextInt();
	}
	
	public int menuTwo() {
		out.println("Menu Two");
		out.println("(1) Go to next menu");
		out.println("(2) Go Back to last menu");
		out.flush();
		return in.nextInt();
	}
	
	public int menuThree() {
		out.println("Menu Three");
		out.println("(1) Go back to menu 1");
		out.println("(2) Go back to last menu");
		out.flush();
		return in.nextInt();
	}
	
}
