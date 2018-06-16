package com.project.catering.domain;

import java.io.Serializable;

public class OrderMeal_MealListId implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 8566569656161565763L;

	private long orderMeal_Id;

	private long mealList_Id;
	
	public int hashCode() {
	    return (int)(orderMeal_Id + mealList_Id);
	  }

	  public boolean equals(Object object) {
	    if (object instanceof OrderMeal_MealListId) {
	    	OrderMeal_MealListId otherId = (OrderMeal_MealListId) object;
	      return (otherId.orderMeal_Id == this.orderMeal_Id) && (otherId.mealList_Id == this.mealList_Id);
	    }
	    return false;
	  }
}
