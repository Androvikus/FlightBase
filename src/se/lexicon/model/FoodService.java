package se.lexicon.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FoodService {
	
	private List<Dish> dishes;

	public FoodService() {
		super();
		Dish dish1 = new Dish(ComfortType.BUSINESS, "Entrecote med svamp", "Stekt av mästerkock", 345);
		Dish dish2 = new Dish(ComfortType.BUSINESS, "Kolja med rysk kaviar", "Kaviar från svarta marknaden", 359);
		Dish dish3 = new Dish(ComfortType.BUSINESS, "Finsk rotfruktslåda, eko", "Handplockade rotfrukter", 375);
		
		Dish dish_e1 = new Dish(ComfortType.ECONOMY, "Hamburgare med pommes frites", "Simple and fast", 115);
		Dish dish_e2 = new Dish(ComfortType.ECONOMY, "Fiskgratäng med mos", "En lagom måltid", 110);
		Dish dish_e3 = new Dish(ComfortType.ECONOMY, "Pannkakor med sylt", "Sylt med låg sockerhalt", 95);
		
		dishes.add(dish1);
		dishes.add(dish2);
		dishes.add(dish3);
		dishes.add(dish_e1);
		dishes.add(dish_e2);
		dishes.add(dish_e3);		
	}
	
	public void addDish(Dish dish) {
		dishes.add(dish);
	}
	
	public List<Dish> getAllDishes(){
		return Collections.unmodifiableList(dishes);
	}
	/**
	 * Returns dishes with supplied ComfortType
	 * @param comfortType
	 * @return
	 */
	public List<Dish> getDishesByComfortType(ComfortType comfortType){
		return dishes.stream().filter(d -> d.comfortType == comfortType).collect(Collectors.toList());
	}
	
	//Ska kunna söka ut dishes på valfritt vilkor... ej testad
	public List<Dish> getDishByPredicate(Predicate<? super Dish> predicate){
		return dishes.stream().filter(predicate).collect(Collectors.toList());
	}
	
}