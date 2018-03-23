package se.lexicon.ui;

import com.sun.java_cup.internal.runtime.Scanner;

import se.lexicon.model.FlightManager;
import se.lexicon.model.UIScannerGuard;
//import se.lexicon.model.FlihtManager;


public class SystemUIAdmin {
	
	private FlightManager fm = new FlightManager();
	
	UIScannerGuard scannerGuard = new UIScannerGuard();
	private int choice = 0;
	
	
	
	public void start() {
		
		System.out.println("");
		System.out.println("Enter 1 for Total flight income enter 2 for Flight profit");
		
		choice = scannerGuard.readInt("Enter a number: ");
		
		switch (choice) {
		
		case 1:
			System.out.println("Total income from flight is:");
		System.out.println(fm.getTotalFlightPrice();
		
		
		break;
		
		
		case 2:
			System.out.println("Flight Profit");
			
			
			
			break;
			
			
			
		default
		break;
		}
		
	}
	
	

}
