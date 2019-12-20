package com.techelevator;

public class RectangleDemo {
	public static void main(String[] args) {

		Rectangle rectangle = new Rectangle(5, 3);

		Rectangle rect2 = new Rectangle(17, 8);

		rectangle.setHeight(25);
		rectangle.setWidth(-10);

		rect2.setHeight(17);
		rect2.setWidth(8);

		System.out.println("The height of Rectangle is " + rectangle.getHeight());
		System.out.println("The height of rect2 is " + rect2.getHeight());

		System.out.println("The area of the Rectangle is " + rectangle.getArea());

		System.out.println("The area of Rectangle is " + rectangle.getArea());

		System.out.println("Rectangle is larger than rect 2 is " + rectangle.isLargerThan(rect2));

		System.out.println("Rectangle is larger than 30x40 is " + rectangle.isLargerThan(30, 40));

		Rectangle rectOne = new Rectangle(10, 10);
		Rectangle rectTwo = new Rectangle(10, 10);

		if (rectOne.equals(rectTwo)) {
			System.out.println("The are equal");
		} else {
			System.out.println("The are not equal");
		}
		
		System.out.println(rectangle);
		System.out.println(rectangle.toString());

	}

}
