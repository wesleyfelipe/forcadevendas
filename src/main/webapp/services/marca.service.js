(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('MarcaService', ['$resource',
        function($resource) {
            return $resource('/rest/recursos/marca');
        }]);
})(angular);