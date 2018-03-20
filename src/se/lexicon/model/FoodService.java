package se.lexicon.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FoodService {
	
	private List<Dish> dishes;

	public FoodService() {
		super();
	}
	
	public void addDish(Dish dish) {
		dishes.add(dish);
	}
	
	public List<Dish> getAllDishes(){
		return Collections.unmodifiableList(dishes);
	}
	
	public List<Dish> getDishesByComfortType(ComfortType comfortType){
		return dishes.stream().filter(d -> d.comfortType == comfortType).collect(Collectors.toList());
	}
}
