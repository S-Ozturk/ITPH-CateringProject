package com.project.catering.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
	
	/*@ManyToMany
    @JoinTable(name="RECEPIE_INGREDIENT",joinColumns=@JoinColumn(name="RECEPIE_ID", referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="INGREDIENT_ID", referencedColumnName="ID"))
	private List<Ingredient> ingredients;*/
	
	@OneToMany(mappedBy = "recepie")
    private List<Recepie_Ingredient> Recepie_Ingredients = new ArrayList<Recepie_Ingredient>();
	
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
	
	
}
