(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('CategoriaService', ['$resource',
        function($resource) {
            return $resource('/rest/recursos/categoria');
        }]);
})(angular);