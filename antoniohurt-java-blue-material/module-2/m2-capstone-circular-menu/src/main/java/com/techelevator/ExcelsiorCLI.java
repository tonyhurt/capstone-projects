package com.techelevator;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import com.techelevator.view.Menu;

public class ExcelsiorCLI {

	private Menu menu;


	public ExcelsiorCLI(DataSource datasource, Menu menu) {
		this.menu = menu;
		// create your DAOs here
	}

	public void run() {

		//menusTheWrongWay();
		
		menusTheRightWay();
	}
	
	/* MENUS THE RIGHT WAY - START */
	private void menusTheRightWay() {
		
		while (true) {
			int choice = menu.menuOne();
			
			if (choice == 1) {
				showMenuTwoRight();
			} 
			if (choice == 2) {
				break;
			}
		}
		
	}
	
	private void showMenuTwoRight() {
		while (true) {
			int choice = menu.menuTwo();
			if (choice == 1) {
				boolean back = showMenuThreeRight();
				if (back) {
					break;
				}
			}
			if (choice == 2) {
				break;
			}
		}
	}
	
	private boolean showMenuThreeRight() {
		boolean back = false;
		while (true) {
			int choice = menu.menuThree();
			if (choice == 1) {
				back = true;
				break;
			}
			if (choice == 2) {
				back = false;
				break;
			}
		}
		return back;
	}
	/* MENUS THE RIGHT WAY - END */
	
	
	/* MENUS THE WRONG WAY - START */
	private void menusTheWrongWay() {
		showMenuOneWrong();		
	}
	
	private void showMenuOneWrong() {
		while (true) {
			int choice = menu.menuOne();
			if (choice == 1) {
				showMenuTwoWrong();
			}
			if (choice == 2) {
				System.exit(0);
			}
		}
		
	}
	
	private void showMenuTwoWrong() {
		while (true) {
			int choice = menu.menuTwo();
			if (choice == 1) {
				showMenuThreeWrong();
			}
			if (choice == 2) {
				showMenuTwoWrong();
			}
		}
		
	}
	
	private void showMenuThreeWrong() {
		while (true) {
			int choice = menu.menuThree();
			if (choice == 1) {
				showMenuOneWrong();
			}
			if (choice == 2) {
				showMenuTwoWrong();
			}
		}
	}
	/* MENUS THE WRONG WAY - END */
	
	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/excelsior-venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		Menu menu = new Menu(System.in, System.out);
		
		ExcelsiorCLI application = new ExcelsiorCLI(dataSource, menu);
		application.run();
	}
	
}
