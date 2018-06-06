package com.project.catering.domain;

import java.io.Serializable;

public class MealList_RecepieId implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1201595825572159138L;

	private long mealList_Id;

	private long mealRecepie_Id;
	
	public int hashCode() {
	    return (int)(mealList_Id + mealRecepie_Id);
	  }

	  public boolean equals(Object object) {
	    if (object instanceof MealList_RecepieId) {
	    	MealList_RecepieId otherId = (MealList_RecepieId) object;
	      return (otherId.mealList_Id == this.mealList_Id) && (otherId.mealRecepie_Id == this.mealRecepie_Id);
	    }
	    return false;
	  }
}
