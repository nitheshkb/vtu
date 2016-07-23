var myModule = angular.module('Home');
myModule.factory('serviceId', function($http) {
	var factory = {};

	factory.getDeptrank = function(username, password, callback) {
	
		$http.get('/vtu/webapi/department/rank?year='+username+'&sem='+password).success(
				function(response) {
					callback(response);
					console.log("IN service");
				});
	
	
	}

	return factory;
});