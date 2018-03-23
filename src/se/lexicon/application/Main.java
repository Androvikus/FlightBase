package se.lexicon.application;

import se.lexicon.model.Airplane;
import se.lexicon.model.ComfortType;
import se.lexicon.model.Customer;
import se.lexicon.model.FlightManager;
import se.lexicon.model.FoodService;
import se.lexicon.ui.SystemUI;

public class Main {

    public static void main(String[] args) {
    	

//    	//test area
//    	
//
//    	FlightManager fm = new FlightManager();//Airplane plan1 = new Airplane(10);
//    	FoodService fs = new FoodService();
//    	
//    	
//    	Customer c1 = new Customer("Kalle","Blomkvist", null);
//    	Customer c2 = new Customer();
//    	Customer c3 = new Customer();
//    	Customer c4 = new Customer();
//    	Customer c5 = new Customer();
//    	Customer c6 = new Customer();
////    	Customer c7 = new Customer();
////    	Customer c8 = new Customer();
////    	Customer c9 = new Customer();
////    	Customer c10 = new Customer();
////    	Customer c11 = new Customer();
//    
//    	
//    	
//    	
//    	
//    	
//    	try 
//    	{
//			fm.addCustomer(c1, ComfortType.BUSINESS);
//			fm.addCustomer(c2, ComfortType.BUSINESS);
//			fm.addCustomer(c3, ComfortType.BUSINESS);
//			fm.addCustomer(c4, ComfortType.BUSINESS);
//			fm.addCustomer(c5, ComfortType.BUSINESS);
//			fm.addCustomer(c6, ComfortType.BUSINESS);
//		} 
//    	catch (Exception e) 
//    	{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println(fm.getAllSeats().size());
//		System.out.println(fm.getAllSeats().get(0).toString());//note: rewrite to show whole List content
//	//	fm.getAllSeats().remove(3);
//		System.out.println(fm.getAllSeats().size());
//		
//		
//		Airplane airplane = new Airplane();	
//		System.out.println(fm.getTotalFlightPrice(airplane.getSeats()));
//    	
 
        SystemUI ui = new SystemUI();
        ui.start();

    }
}
