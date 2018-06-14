package com.project.catering.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name, type, unitType;
	private double caloriePerUnit;

	@OneToMany(mappedBy = "ingredient")
    private List<Recepie_Ingredient> recepies;
    
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public double getCaloriePerUnit() {
		return caloriePerUnit;
	}
	public void setCaloriePerUnit(double caloriePerUnit) {
		this.caloriePerUnit = caloriePerUnit;
	}
}
