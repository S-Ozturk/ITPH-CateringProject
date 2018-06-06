package com.project.catering.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(MealList_RecepieId.class)
public class MealList_Recepie {

	@Id
	private long mealList_Id;
	
	@Id
	private long mealRecepie_Id;
	
	private int recepie_amount;
	
	@ManyToOne
	@JoinColumn(name = "mealList_Id", updatable = false, insertable = false, referencedColumnName = "id")
    private MealList mealList;
	
	@ManyToOne
	@JoinColumn(name = "mealRecepie_Id", updatable = false, insertable = false, referencedColumnName = "id")
    private Recepie mealRecepie;
	
	public long getMealRecepie_Id() {
		return mealRecepie_Id;
	}
	public void setMealRecepie_Id(long mealRecepie_Id) {
		this.mealRecepie_Id = mealRecepie_Id;
	}
	public Recepie getRecepie() {
		return mealRecepie;
	}
	public void setRecepie(Recepie mealRecepie) {
		this.mealRecepie = mealRecepie;
	}
	public MealList getMealList() {
		return mealList;
	}
	public void setMealList(MealList mealList) {
		this.mealList = mealList;
	}
	public long getMealList_Id() {
		return mealList_Id;
	}
	public void setMealList_Id(long mealList_Id) {
		this.mealList_Id = mealList_Id;
	}
	public int getRecepie_amount() {
		return recepie_amount;
	}
	public void setRecepie_amount(int recepie_amount) {
		this.recepie_amount = recepie_amount;
	}
	
}
