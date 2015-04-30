var cookitApp = angular.module('cookitApp', [])

cookitApp.controller("ingredientsController", function($scope){
	$scope.ingredientTypes = [
	               {name: "Gemüse"}, 
	               {name: "Gewürz"}, 
	               {name: "Frucht"}
	               ];
	
	
	
});