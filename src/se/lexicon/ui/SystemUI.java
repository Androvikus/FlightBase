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
		
		System.out.println("Welcome to FlightBase Booking System \n" + "1. Book a flight \n" + "2. Exit Booking System");
		choice = scannerGuard.readInt("Ange en siffra: ");
		
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
					Dish dish = chooseDish(scannerGuard);
					
					if(fm.canAddCustomer(comfortType)) {
						Customer newCustomer = new Customer(firstname, Surname, dish);
						//summary comfirm
						
						//add
						System.out.println("Summary:\n");
						fm.presentReceipt(newCustomer, comfortType, new Seat(comfortType)); 
						if(scannerGuard.readLine("Comfirm booking (Y/N)? ")=="y") {
							fm.addCustomer(newCustomer, comfortType);
							
						}
						
					}
					else {
						//get another comfort type
						ComfortType otherComfortType = (comfortType==ComfortType.BUSINESS)?ComfortType.ECONOMY:ComfortType.BUSINESS;
						String do_redo = scannerGuard.readLine("Do you want to search for " + otherComfortType + " (Y/N) ? ");
					
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
						
						//mark status
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
		
		int choice = scannerGuard.readInt("Ange en siffra: ");
		
		
		
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
		
		
		
		
	/*
	switch(choice) {
		case 1:
			//System.out.println("Choose comfort type");
			try 
			{
				comfortType = enterComfortType(scannerGuard);
			} 
			catch (Exception e1) 
			{
				System.out.println("");
			}
			break;
		case 2:
			break;
		}	
	 */
		
		
		
		
		
		
		
		
		
		
		
		
		
/*
		// Loop-condition
		boolean isRunning = true;

		// Try-with-resources to auto-close scanner on error or exit
		try(Scanner scanner = new Scanner(System.in)) {

			// Run at least once.
			do {

				// Inner loop error handling
				try {

					System.out.println("Welcome to FlightBase Booking System \n" + "1. Book a flight \n" + "2. Exit Booking System");
					String keyboard = scanner.next();

					switch (keyboard) {

						case "1":
							System.out.println("Enter firstname:");
							isRunning = false;
							break;
						case "2":
							System.out.println("Exiting program...");
							isRunning = false;
							break;
							
						default:
							System.out.println(keyboard + " is not a valid option. Please try again.");

					}

					// Catch any and all program-specific exceptions here to de-clutter your switch-case
					// in case of checked and/or custom exceptions.

				} catch (Exception e) {
					System.out.println("Exception caught in inner try : " + e.getMessage());

				}

			} while (isRunning);

		} catch (Exception e) {
			System.out.println("Exception caught in outer try : " + e.getMessage());

		} finally {

			// Any tasks needed for cleaning up/saving/etc should be performed here.
			// The scanner auto-closes so don't worry about that.

		}
*/
	}


