package de.cookit

import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.MongoClient
import de.cookit.entity.Ingredient
import de.cookit.entity.IngredientType
import de.cookit.server.CookItResource
import org.bson.types.ObjectId
import spock.lang.Ignore
import spock.lang.Specification

import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response


class CoffeeShopResourceSpecification extends Specification {
	final static String TEST_DBNAME = "cookit-test"
	
	//functional test
    def 'should save all fields to the database when ingredient is saved'() {
        given:
        def mongoClient = new MongoClient()
        def database = mongoClient.getDB(TEST_DBNAME)
        def collection = database.getCollection('Ingredient')
		collection.drop();
		
        def cookIt = new CookItResource(mongoClient, TEST_DBNAME)
        def myType = new IngredientType("Gemüse")
        def ing = new Ingredient("Kartoffel", myType)
		
        when:
        Response response = cookIt.storeIngredient(ing)

        then:
        collection.count == 1
        def createdIng = collection.findOne()
        println createdIng
        createdIng['name'] == "Kartoffel"
        createdIng['type'].name == myType.name
        createdIng['_id'] != null

        cleanup:
        mongoClient.close()
    }
}