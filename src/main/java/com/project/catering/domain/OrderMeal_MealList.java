package com.project.catering.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(OrderMeal_MealListId.class)
public class OrderMeal_MealList {

	@Id
	private long orderMeal_Id;
	
	@Id
	private long mealList_Id;
	
	private int mealList_amount;
	private boolean cooked;
	
	@ManyToOne
	@JoinColumn(name = "orderMeal_Id", updatable = false, insertable = false)
    private OrderMeal orderMeal;
	
	@ManyToOne
	@JoinColumn(name = "mealList_Id", updatable = false, insertable = false)
    private MealList mealList;
	
	public long getOrderMeal_Id() {
		return orderMeal_Id;
	}
	public void setOrderMeal_Id(long orderMeal_Id) {
		this.orderMeal_Id = orderMeal_Id;
	}
	public long getMealList_Id() {
		return mealList_Id;
	}
	public void setMealList_Id(long mealList_Id) {
		this.mealList_Id = mealList_Id;
	}
	public double getMealList_amount() {
		return mealList_amount;
	}
	public void setMealList_amount(int mealList_amount) {
		this.mealList_amount = mealList_amount;
	}
	public MealList getMealList() {
		return mealList;
	}
	public void setMealList(MealList mealList) {
		this.mealList = mealList;
	}
	public boolean isCooked() {
		return cooked;
	}
	public void setCooked(boolean cooked) {
		this.cooked = cooked;
	}
	
}
