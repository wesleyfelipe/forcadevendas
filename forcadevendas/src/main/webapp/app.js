(function(angular, window, undefined) {
    window.ForcaDeVendas = {
        app: angular.module('forcaDeVendas', [
            'ngRoute',
            'forcaDeVendas.clientes'
        ])
    };

    ForcaDeVendas.app.config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/clientes', {
                templateUrl: 'clientes/clientes.html',
                controller: 'ClientesController'
            }).
            otherwise({
                redirectTo: '/clientes'
            });
    }]);
})(angular, window);