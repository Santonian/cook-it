package de.cookit.server;

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
		environment.jersey().register(new CookItResource());
	}

}
