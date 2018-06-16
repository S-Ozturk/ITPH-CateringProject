package com.project.catering.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class MealList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name, mealType;
	private double caloriePerPerson;
	
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "mealList", orphanRemoval=true)
    private List<MealList_Recepie> recepies;
    
    @OneToMany(mappedBy = "mealList")
    private List<OrderMeal_MealList> orderMeals;
    
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
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public double getCaloriePerPerson() {
		return caloriePerPerson;
	}
	public void setCaloriePerPerson(double caloriePerPerson) {
		this.caloriePerPerson = caloriePerPerson;
	}
	public List<MealList_Recepie> getRecepies() {
		return recepies;
	}
	public void setRecepies(List<MealList_Recepie> recepies) {
		this.recepies = recepies;
	}
	
	
}
