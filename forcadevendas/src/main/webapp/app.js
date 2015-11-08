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
            })
            .when('/cadastroClientes', {
        		templateUrl: 'clientes/cadastroClientes.html',
        		controller: 'CadastroController'
            })
            .otherwise({
                redirectTo: '/clientes'
            });
    }]); 
    
})(angular, window);