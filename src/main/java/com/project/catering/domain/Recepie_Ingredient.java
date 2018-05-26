package com.project.catering.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recepie_Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double ingredient_amount;
	
	@ManyToOne
    @JoinColumn(name="RECEPIE_ID")
    private Recepie recepie;
	
	@ManyToOne
    @JoinColumn(name="INGREDIENT_ID")
    private Ingredient ingredient;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getIngredient_amount() {
		return ingredient_amount;
	}
	public void setIngredient_amount(double ingredient_amount) {
		this.ingredient_amount = ingredient_amount;
	}
}
