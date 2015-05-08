var cookitApp = angular.module('cookitApp', ['ngResource'])


cookitApp.factory("Ingredient", function($resource){
	return $resource('/service/cookit/storeIngredient')
	
});

cookitApp.controller("ingredientsController", function($scope, Ingredient){
	$scope.ingredientTypes = [
	               {name: "Gemüse"}, 
	               {name: "Gewürz"}, 
	               {name: "Frucht"}
	               ];
	
	
	
	$scope.storeIngredient = function() {
		Ingredient.save($scope.ingredient)
	}
});