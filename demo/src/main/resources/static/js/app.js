var app=angular.module("MyCatalogue",[]);
app.controller("catController", function($scope,$http){
	$scope.produits=[];
	$scope.motCle=null;
	$scope.page=0;
	$scope.charger=function(){
		$http.get("/produitMotcle?mc="+$scope.motCle+"&page="+$scope.page)
		.success(function(data){
			$scope.produits=data;
			$scope.pages= new Array(data.totalPages)
		});
	};
	$scope.goToPage=function(p){
		$scope.page=p;
		$scope.charger();
	};
});