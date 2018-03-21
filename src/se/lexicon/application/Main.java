package se.lexicon.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import se.lexicon.model.Airplane;
import se.lexicon.model.ComfortType;
import se.lexicon.model.Customer;
import se.lexicon.model.FlightManager;
import se.lexicon.model.FoodService;
import se.lexicon.model.Seat;
import se.lexicon.ui.SystemUI;

public class Main {

    public static void main(String[] args) {
    	

    	//test area
    	
    	FlightManager fm = new FlightManager();//Airplane plan1 = new Airplane(10);
    	FoodService fs = new FoodService();
    	
    	
    	Customer c1 = new Customer("Kalle","Blomkvist", null);
    	Customer c2 = new Customer();
    	Customer c3 = new Customer();
    	Customer c4 = new Customer();
    	Customer c5 = new Customer();
    	Customer c6 = new Customer();
//    	Customer c7 = new Customer();
//    	Customer c8 = new Customer();
//    	Customer c9 = new Customer();
//    	Customer c10 = new Customer();
//    	Customer c11 = new Customer();
    
    	
    	
    	
    	
    	
    	try 
    	{
			fm.addCustomer(c1, ComfortType.BUSINESS);
			fm.addCustomer(c2, ComfortType.BUSINESS);
			fm.addCustomer(c3, ComfortType.BUSINESS);
			fm.addCustomer(c4, ComfortType.BUSINESS);
			fm.addCustomer(c5, ComfortType.BUSINESS);
			fm.addCustomer(c6, ComfortType.BUSINESS);
		} 
    	catch (Exception e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(fm.getAllSeats().size());
		System.out.println(fm.getAllSeats().get(3).toString());//note: rewrite to show whole List content
	//	fm.getAllSeats().remove(3);
		System.out.println(fm.getAllSeats().size());
		
		
		Airplane airplane = new Airplane();	
		System.out.println(fm.getTotalFlightPrice(airplane.getSeats()));
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c1, ComfortType.BUSINESS));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c2, ComfortType.BUSINESS));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c3, ComfortType.BUSINESS));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c4, ComfortType.BUSINESS));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c5, ComfortType.BUSINESS));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c6, ComfortType.BUSINESS));//over fill business
//    	
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c1, ComfortType.ECONOMY));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c2, ComfortType.ECONOMY));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c3, ComfortType.ECONOMY));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c4, ComfortType.ECONOMY));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c5, ComfortType.ECONOMY));
//    	System.out.println(plan1.putCustomerOnFirstAvailableWithSpecifiedType(c6, ComfortType.ECONOMY));//over fill ECONOMY
//    	
    	
    	
    	
    	
    	
    	//end of test area
    	
//        SystemUI ui = new SystemUI();
//        ui.start();

    }
}
