package de.cookit.server;

import jersey.repackaged.com.google.common.collect.Lists;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class CookItApplication extends Application<CookItConfiguration>{

	public static void main(String[] args) throws Exception{
		new CookItApplication().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<CookItConfiguration> bootstrap) {
		final AssetsBundle bundle = new AssetsBundle("/html", "/");
		bootstrap.addBundle(bundle);
	}

	@Override
	public void run(CookItConfiguration configuration, Environment environment)
			throws Exception {
		
		final ServerAddress address = new ServerAddress("host", 1234);
		
		final MongoCredential credentials = MongoCredential.createCredential("user", "database", "password".toCharArray());
		
//		environment.jersey().register(new CookItResource(new MongoClient(address, Lists.newArrayList(credentials))));
		environment.jersey().register(new CookItResource(new MongoClient()));
	}

}
