package de.cookit.server;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatabaseConfiguration {

	@NotNull
	private String name;
	
	@NotEmpty
	private String host;
	
	private Integer port;
	
	@NotEmpty
	private String database;
	
	@NotNull
	private String user;
	
	@NotNull
	private String password;

	@JsonProperty
    public String getName() {
		return name;
	}

	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getHost() {
		return host;
	}

    @JsonProperty
	public void setHost(String host) {
		this.host = host;
	}

    @JsonProperty
	public Integer getPort() {
		return port;
	}

    @JsonProperty
	public void setPort(Integer port) {
		this.port = port;
	}

    @JsonProperty
	public String getDatabase() {
		return database;
	}

    @JsonProperty
	public void setDatabase(String database) {
		this.database = database;
	}

    @JsonProperty
	public String getUser() {
		return user;
	}

    @JsonProperty
	public void setUser(String user) {
		this.user = user;
	}

    @JsonProperty
	public String getPassword() {
		return password;
	}

    @JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
