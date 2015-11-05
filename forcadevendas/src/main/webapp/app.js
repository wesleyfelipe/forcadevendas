(function(angular, window, undefined) {
    window.ForcaDeVendas = {
        app: angular.module('forcaDeVendas', [
            'ngRoute',
            'forcaDeVendas.clientes',
            'forcaDeVendas.login'
        ])
    };

    ForcaDeVendas.app.config(['$routeProvider', function($routeProvider) {
        
        $routeProvider.
            when('/clientes', {
                templateUrl: 'clientes/clientes.html',
                controller: 'ClientesController'
            })
            .when('/login', {
                templateUrl: 'login/login.html',
                controller: 'LoginController'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }]);
})(angular, window);