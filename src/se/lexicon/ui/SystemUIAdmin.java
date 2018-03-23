package se.lexicon.ui;

//no saved customers in airplane will result in value 0 in both methods

import se.lexicon.model.FlightManager;
import se.lexicon.model.UIScannerGuard;
//import se.lexicon.model.FlihtManager;


public class SystemUIAdmin {
	
	private FlightManager fm = new FlightManager();
	
	UIScannerGuard scannerGuard = new UIScannerGuard();
	private int choice = 0;
	
	
	
	public void start() {
		
		System.out.println("");
		System.out.println("Statistics");
		System.out.println("1. Total flight income \n2. Flight profit \n3. Exit Statistics"); 
		//System.out.println(fm.getNumberOfAvailableSeats());
		
		choice = scannerGuard.readInt("Enter a number: ");		
		switch (choice) {
		
		case 1:
			System.out.println("Total income from flight is:  ");			
			System.out.println(fm.getTotalFlightPrice(fm.getAllSeats()));
			start();
			
		break;
		
		case 2:
			System.out.println("Flight Profit   ");
			System.out.println(fm.countProfitPerFlight(fm.getAllSeats()));
			start();			
			break;		
			
			
		case 3:
		
		System.out.println("Welcome back another time");
		break;
		
		default:
			System.out.println("Not a valid choice");
			break;
		}
		
	}
	
	

}
