package com.project.catering.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(Recepie_IngredientId.class)
public class Recepie_Ingredient {

	@Id
	private long recepie_Id;
	
	@Id
	private long ingredient_Id;
	
	private double ingredient_amount;
	
	@ManyToOne
	//@PrimaryKeyJoinColumn(name="RECEPIE_ID", referencedColumnName = "ID")
	@JoinColumn(name = "recepie_Id", updatable = false, insertable = false)
    private Recepie recepie;
	
	@ManyToOne
	//@PrimaryKeyJoinColumn(name="INGREDIENT_ID", referencedColumnName = "ID")
	@JoinColumn(name = "ingredient_Id", updatable = false, insertable = false)
    private Ingredient ingredient;
	
	/*public void setRecepieId(long recepie_Id) {
		this.recepie_Id = recepie_Id;
	}
	public void setIngredientId(long ingredient_Id) {
		this.ingredient_Id = ingredient_Id;
	}*/
	public long getRecepie_Id() {
		return recepie_Id;
	}
	public void setRecepie_Id(long recepie_Id) {
		this.recepie_Id = recepie_Id;
	}
	public long getIngredient_Id() {
		return ingredient_Id;
	}
	public void setIngredient_Id(long ingredient_Id) {
		this.ingredient_Id = ingredient_Id;
	}
	public double getIngredient_amount() {
		return ingredient_amount;
	}
	public void setIngredient_amount(double ingredient_amount) {
		this.ingredient_amount = ingredient_amount;
	}
	
	/*public Recepie getRecepie() {
		return recepie;
	}

	public void setRecepie(Recepie recepie) {
		this.recepie = recepie;
	}*/
	
	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
}
