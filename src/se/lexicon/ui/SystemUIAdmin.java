package se.lexicon.ui;



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
		System.out.println(fm.getNumberOfAvailableSeats());
		
		choice = scannerGuard.readInt("Enter a number: ");
		
		switch (choice) {
		
		case 1:
			System.out.println("Total income from flight is:");
			
			System.out.println(fm.getTotalFlightPrice(fm.getAllSeats()));
		
		
		break;
		
		
		case 2:
			System.out.println("Flight Profit");
			System.out.println(fm.countProfitPerFlight(fm.getAllSeats()));
			
			
			
			break;
			
			
			
		//default
		//break;
		}
		
	}
	
	

}
