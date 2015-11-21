(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('ClienteService', ['$resource',
        function($resource) {
            return $resource('/rest/recursos/cliente');
        }]);
})(angular);