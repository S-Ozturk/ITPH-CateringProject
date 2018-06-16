package com.project.catering.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double amount;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="INGREDIENT_ID")
    private Ingredient ingredient;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getIngredient() {
		return ingredient.getName();
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
}
