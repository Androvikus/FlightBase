package se.lexicon.ui;

import java.util.Scanner;

import se.lexicon.model.FlightManager;
import se.lexicon.model.UIScannerGuard;

public class SystemUI {
	private FlightManager fm;
	Scanner scanner;
	UIScannerGuard scannerGuard;
	
	
	// Start the applications UI
	public void start() {
		fm = new FlightManager();
		scannerGuard = new UIScannerGuard();
	
		
		//Meny
		int choice = 0;
		int subChoice = 0;
		
		System.out.println("Welcome to FlightBase Booking System \n" + "1. Book a flight \n" + "2. Exit Booking System");
		choice = scannerGuard.readInt("Ange en siffra: ");
		
		switch(choice) {
		case 1:
			System.out.println("Test: Valt att boka");
			try 
			{
				//subChoice = garageUI.chooseVehicleTypeMenu(garageUI.scannerGuard);
			} 
			catch (Exception e1) 
			{
				System.out.println("error in Booking System, please try later");
			}
			break;
		case 2:
			break;
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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


