package com.project.catering.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Recepie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name, unitType,recepieType;
	private double caloriePerPortion, portionPerRecepie;
	
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "recepie")
    private List<Recepie_Ingredient> ingredients;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getRecepieType() {
		return recepieType;
	}
	public void setRecepieType(String recepieType) {
		this.recepieType = recepieType;
	}
	public double getCaloriePerPortion() {
		return caloriePerPortion;
	}
	public void setCaloriePerPortion(double caloriePerPortion) {
		this.caloriePerPortion = caloriePerPortion;
	}
	public double getPortionPerRecepie() {
		return portionPerRecepie;
	}
	public void setPortionPerRecepie(double portionPerRecepie) {
		this.portionPerRecepie = portionPerRecepie;
	}
	
	/*public void addIngredient(Ingredient ingredient, double amount) {
		Recepie_Ingredient recepie_Ingredient = new Recepie_Ingredient();
	    recepie_Ingredient.setIngredient(ingredient);
	    recepie_Ingredient.setRecepie(this);
	    recepie_Ingredient.setIngredientId(ingredient.getId());
	    recepie_Ingredient.setRecepieId(this.getId());
	    recepie_Ingredient.setIngredient_amount(amount);
	    if(this.ingredients == null)
	       this.ingredients = new ArrayList<>();

	    this.ingredients.add(recepie_Ingredient);
	    // Also add the recepie_Ingredient object to the ingredient.
	    //ingredient.getRecepies().add(recepie_Ingredient);
	}*/
	
}
