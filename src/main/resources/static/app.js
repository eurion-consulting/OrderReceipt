var app = angular.module('receipts', ["ngCookies", "angular-jwt"]);
 
app.controller('pageController', function(authService, receiptService, $scope, $http, $cookies, jwtHelper) {
    
    var _cookies = $cookies.getAll();
    console.log('Listing all cookies..', _cookies);
    
    for(cookie in _cookies){
    	console.log(cookie);
    }
    
    $scope.isAuditor = false;
	
    $scope.getToken = function() {
        var token = $cookies.get("access_token");
        var payload = jwtHelper.decodeToken(token);
        console.log("Payload from JWT: " + payload)
    }
    
    $scope.lookUp = function(){
    	console.log('Call lookup..');
    	receiptService.lookup($scope.receiptId).then(function(receipt){
    			$scope.receipt = receipt;
    		}
    	);
    }
    
    $scope.login = function() {
    	$scope.token = true;
    }
    
    $scope.logout = function() {
    	$scope.userName = '';
        $scope.token = null;
        
        //cause the spring app to prompt for user credentials 
        //$http.defaults.headers.common.Authorization = '';
    }
    
    $scope.loggedIn = function() {
        return $scope.token !== null;
    }
   
});

app.service('authService', function($http) {
    
    this.login = function(username) {
    	return $http.post('/auth/login', {name: username}).then(function(response) {
	        //remove $scope reference as this should be clean service. Define it in the controller
    		$scope.token = response.data.token;
	    	$http.defaults.headers.common['Authorization'] = 'Bearer ' + response.data.token;
	        //TODO: decode - assign roles, and extract state data
	    	return $scope.token;
        });
    };

    this.hasRole = function(role) {
    	return $http.get('/auth/role/' + role).then(function(response){
	        console.log(response);
	        return true;
	    });
	};
    
});

app.service('receiptService', function($http) {
    
	this.lookup = function(receiptId) {
        console.log('Call REST service with ReceiptID = ' + receiptId);
    	return $http.get('/receipts/' + receiptId).then(function(response) {
        	console.log(response.data);
    		return response.data;
        });
     };
});