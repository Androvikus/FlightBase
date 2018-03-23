package se.lexicon.ui;

import java.util.Scanner;

import se.lexicon.exception.ExampleException;
import se.lexicon.model.ComfortType;
import se.lexicon.model.CountAndReceiptService;
import se.lexicon.model.Customer;
import se.lexicon.model.Dish;
import se.lexicon.model.FlightManager;
import se.lexicon.model.Seat;
import se.lexicon.model.UIScannerGuard;

public class SystemUI {
	private FlightManager fm = new FlightManager();
	Scanner scanner;
	UIScannerGuard scannerGuard = new UIScannerGuard();
	ComfortType comfortType;
	//Customer customer = new Customer();
	
	// Start the applications UI
	public void start() {
		
		//Meny
		int choice = 0;
		int subChoice = 0;
		
		System.out.println("Welcome to FlightBase Booking System \n" + "1. Book a flight \n" + "2. Exit Booking System \n");
		
		System.out.println("Number of available seats are: " + fm.getNumberOfAvailableSeats());
		
		choice = scannerGuard.readInt("Enter a number: ");
		
		switch(choice) {
		case 1:
			//System.out.println("Choose comfort type");
			try 
			{
				boolean redo=false;
				boolean businessClassFull = false;
				boolean economyClassFull = false;
				String firstname = enterFirstname(scannerGuard);
				String Surname = enterSurname(scannerGuard);
				comfortType = enterComfortType(scannerGuard);
				do {
					
					
					if(fm.canAddCustomer(comfortType)) {
						Customer newCustomer = new Customer(firstname, Surname);
						//summary comfirm
						
						Dish dish = chooseDish(scannerGuard);
						fm.assignDishToCustomerWithComfortType(newCustomer, dish, comfortType);
						
						//add
						System.out.println("Summary:\n");
						fm.presentReceipt(newCustomer, comfortType, new Seat(comfortType)); 
						if(scannerGuard.readLine("Comfirm booking (Y/N)? ").equalsIgnoreCase("y")) {
							fm.addCustomer(newCustomer, comfortType);
							
						}
						
					}
					else {
						//get another comfort type
						ComfortType otherComfortType = (comfortType==ComfortType.BUSINESS)?ComfortType.ECONOMY:ComfortType.BUSINESS;
						String do_redo = scannerGuard.readLine("Booking full. Do you want to search for " + otherComfortType + " (Y/N) ? ");
					
						if(comfortType==ComfortType.BUSINESS) {
							businessClassFull=true;
						}
						if(comfortType==ComfortType.ECONOMY) {
							economyClassFull=true;
						}
						if(do_redo.equalsIgnoreCase("y")) {
							redo=true;
							comfortType = otherComfortType;
						}
						
					}
					start();
				}while(redo && (!businessClassFull || !economyClassFull));
				}
			 
			catch (Exception e1) 
			{
				System.out.println("");
			}
 		case 2:
			break;
		}
	}


	private Dish chooseDish(UIScannerGuard scannerGuard) {
		System.out.println("Choose Dish");
		
		
		
		if(comfortType != null && comfortType != ComfortType.BUSINESS) {
			//fm.getAvailableDishesByComfortType(ComfortType.ECONOMY)
			int count=1;
			for(Dish dish : fm.getAvailableDishesByComfortType(ComfortType.ECONOMY)) {
				System.out.println(count + ": " + dish);
				count++;
			}
		}
		else if(comfortType != null && comfortType != ComfortType.ECONOMY) {
			int count=1;
			for(Dish dish : fm.getAvailableDishesByComfortType(ComfortType.BUSINESS)) {
				System.out.println(count + ": " + dish);
				count++;
			}
		}
		
		int choice = scannerGuard.readInt("Enter a number: ");
		
		
		
		return fm.getAvailableDishesByComfortType(comfortType).get(choice-1);
	}


	private String enterSurname(UIScannerGuard scannerGuard) {
		System.out.println("Enter your Surname");
		String surname = scannerGuard.readLine("");
		return surname;
	}


	private String enterFirstname(UIScannerGuard scannerGuard) {
		System.out.println("Enter your Firstname");
		String firstname = scannerGuard.readLine("");
		return firstname;
	}


	private ComfortType enterComfortType(UIScannerGuard scannerGuard) throws ExampleException {
		
		int choice = 0;
		choice = scannerGuard.readInt("Choose comfort type \n" + "1. Business Class \n" + "2. Economy Class");
		if(choice == 1) {
			comfortType = ComfortType.BUSINESS;
			 
		}
		else if(choice == 2) {
			comfortType = ComfortType.ECONOMY;
			
		}
		else {
			System.out.println("You have entered the wrong number, please enter number 1 or 2");
		}
		return comfortType;
	}
		
}