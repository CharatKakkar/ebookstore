

var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function () {
        $http.get('/ebookstore/rest/cart/'+$scope.cartId).success(function (data) {
           $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/ebookstore/rest/cart/'+$scope.cartId).success(function (){        	
        	$scope.refreshCart();	 	
        });
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
    

    $scope.addToCart = function (productId,productName) {
    	if($scope.qty== undefined){
    		$http.put('/ebookstore/rest/cart/add/'+productId +'/c/'+ 1).success(function () {
    		alert(1 + " copy of " +productName + " has been successfully added to the cart!")
    		});    		
    	}
    	else{
    		$http.put('/ebookstore/rest/cart/add/'+productId +'/c/'+ $scope.qty).success(function () {
        		alert($scope.qty + " copies of " +productName + " has been successfully added to the cart!")
        		}); 
    		}   
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/ebookstore/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart();
        });
    };

    $scope.grandTotal = function () {
        var grandTotal=0;
        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].itemTotal;
        }
        return grandTotal;             
    };
    
    $scope.$watch(function() {
    	if ($scope.grandTotal()!=0){ 
    		$scope.ShowSave = true;
    	}else{
    		$scope.ShowSave = false;
    	 }
    });

});