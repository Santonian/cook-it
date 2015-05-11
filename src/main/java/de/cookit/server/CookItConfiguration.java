package de.cookit.server;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;


public class CookItConfiguration extends Configuration {

    @Valid
    @NotNull
	private DatabaseConfiguration database = new DatabaseConfiguration();
    
    @JsonProperty()
	public DatabaseConfiguration getDatabase() {
		return database;
	}

    @JsonProperty()
	public void setDatabase(DatabaseConfiguration database) {
		this.database = database;
	}
    
    
}
