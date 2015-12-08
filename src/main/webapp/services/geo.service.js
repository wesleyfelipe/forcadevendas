(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('GeoService', ['$resource',
        function($resource) {
            return {
            	pais: $resource('/rest/recursos/pais', {}, {
            		query: {method: 'GET', params: {}, isArray: true}
            	}),
            	estado: $resource('/rest/recursos/estado', {}, {
            		query: {method: 'GET', params: {}, isArray: true}
            	}),
            	cidade: $resource('/rest/recursos/cidade', {}, {
            		query: {method: 'GET', params: {}, isArray: true}
            	})
            };
        }]);
})(angular);