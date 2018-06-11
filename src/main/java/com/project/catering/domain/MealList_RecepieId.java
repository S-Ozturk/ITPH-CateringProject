package com.project.catering.domain;

import java.io.Serializable;

public class MealList_RecepieId implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1201595825572159138L;

	private long mealList_Id;

	private long recepie_Id;
	
	public int hashCode() {
	    return (int)(mealList_Id + recepie_Id);
	  }

	  public boolean equals(Object object) {
	    if (object instanceof MealList_RecepieId) {
	    	MealList_RecepieId otherId = (MealList_RecepieId) object;
	      return (otherId.mealList_Id == this.mealList_Id) && (otherId.recepie_Id == this.recepie_Id);
	    }
	    return false;
	  }
}
