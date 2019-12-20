package com.techelevator;

public class Rectangle {
	
	private int height;
	private int width = 10;
	
	
	public Rectangle() {
		
	}
	
	public Rectangle(int width, int height) {
		this.height = Math.abs(height);
		this.width = Math.abs(width);
		
	}
	
	
	public void setHeight(int height) {
		this.height = Math.abs(height);
	}
	
	public void setWidth(int width) {
		this.width = Math.abs(width);
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getArea() {
		return this.height * this.width;
	}
	
	public boolean isLargerThan(Rectangle other) {
		return getArea() > other.getArea();
	}
	
	public boolean isLargerThan(int height, int width) {
		return getArea() > ( height * width );
	}
	
	@Override
	public boolean equals(Object obj) {
		Rectangle other = (Rectangle) obj;
		return this.height == other.height && this.width == other.width;
	}
	
	@Override
	public String toString() {
		return this.width + "x" + this.height + " - " + this.getArea() + "sq ft";
	}
	
}
