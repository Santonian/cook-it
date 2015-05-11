package de.cookit.server;

import jersey.repackaged.com.google.common.collect.Lists;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import de.thomaskrille.dropwizard_template_config.TemplateConfigBundle;
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
		bootstrap.addBundle(new TemplateConfigBundle());
	}

	@Override
	public void run(CookItConfiguration configuration, Environment environment)
			throws Exception {
		
		final DatabaseConfiguration databaseConfiguration = configuration.getDatabase();
		
		final ServerAddress address;
		if(databaseConfiguration.getPort() == null){
			address = new ServerAddress(databaseConfiguration.getHost());
		}else{
			address = new ServerAddress(databaseConfiguration.getHost(), databaseConfiguration.getPort());
		}
		
		if(databaseConfiguration.getUser().isEmpty() && databaseConfiguration.getPassword().isEmpty()){
			environment.jersey().register(new CookItResource(new MongoClient(address)));
		}else{
			final MongoCredential credentials = MongoCredential.createCredential(databaseConfiguration.getUser(), databaseConfiguration.getDatabase(), databaseConfiguration.getPassword().toCharArray());
			environment.jersey().register(new CookItResource(new MongoClient(address, Lists.newArrayList(credentials))));
		}
	}

}
