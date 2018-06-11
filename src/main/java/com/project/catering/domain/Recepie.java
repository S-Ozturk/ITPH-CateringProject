package com.project.catering.domain;

import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "recepie", orphanRemoval=true)
	//@Fetch(FetchMode.SELECT)
	//@JoinTable(name = "recepie_ingredient", joinColumns = @JoinColumn(name = "recepie_Id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Recepie_Ingredient> ingredients;
    
    @OneToMany(/*fetch = FetchType.EAGER,*/ mappedBy = "recepie")
    //@JoinTable(name = "meal_list_recepie", joinColumns = @JoinColumn(name = "recepieformeal_Id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<MealList_Recepie> mealLists;
    
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
	public List<Recepie_Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Recepie_Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
