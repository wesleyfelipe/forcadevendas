(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('DepartamentoService', ['$resource',
        function($resource) {
            return $resource('/rest/recursos/departamento');
        }]);
})(angular);