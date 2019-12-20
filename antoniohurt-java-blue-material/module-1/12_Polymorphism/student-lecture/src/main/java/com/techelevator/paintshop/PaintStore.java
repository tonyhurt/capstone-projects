package com.techelevator.paintshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintStore {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
				
		System.out.print("what size of the area are you painting? >>>");
		int area = in.nextInt();
		in.nextLine();
		
		List<Paint> paints = new ArrayList<Paint>();
		paints.add(new LatexPaint());
		paints.add(new OilPaint(true));
		paints.add(new OilPaint(false));
		
		for (Paint paint : paints) {
			double cost = paint.calculateCost(area);
			System.out.println("The " + paint.getName() + " will cost $" + cost);
		}
		
		}
			
	
	}
	
	
	
	
