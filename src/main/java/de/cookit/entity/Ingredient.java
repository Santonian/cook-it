package de.cookit.entity;

import org.mongodb.morphia.annotations.Id;


//{
//	  "name": "Kartoffel",
//	  "type": {
//	    "name": "Gemüse"
//	  }
//	}
public class Ingredient {
	@Id
	public String id;
	
	public String name;
	
	public IngredientType type;

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public IngredientType getType() {
		return type;
	}
	
	
}
