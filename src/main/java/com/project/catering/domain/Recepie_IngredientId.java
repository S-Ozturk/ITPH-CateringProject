package com.project.catering.domain;

import java.io.Serializable;

public class Recepie_IngredientId implements Serializable{

	 private long recepie_Id;

	 private long ingredient_Id;
	
	public int hashCode() {
	    return (int)(recepie_Id + ingredient_Id);
	  }

	  public boolean equals(Object object) {
	    if (object instanceof Recepie_IngredientId) {
	    	Recepie_IngredientId otherId = (Recepie_IngredientId) object;
	      return (otherId.recepie_Id == this.recepie_Id) && (otherId.ingredient_Id == this.ingredient_Id);
	    }
	    return false;
	  }
}
