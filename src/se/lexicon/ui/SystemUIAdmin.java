package se.lexicon.ui;

import com.sun.java_cup.internal.runtime.Scanner;

import se.lexicon.model.UIScannerGuard;
//import se.lexicon.model.FlihtManager;

public class SystemUIAdmin {
	
	UIScannerGuard scannerGuard = new UIScannerGuard();
	int choice = 0;
	
	public void start() {
		
		System.out.println("");
		System.out.println("Enter 1 for Total flight income enter 2 for Flight profit");
		
		choice = scannerGuard.readInt("Enter a number: ");
		
		
	}
	
	

}
