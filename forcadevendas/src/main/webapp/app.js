(function(angular, window, undefined) {
    window.ForcaDeVendas = {
        app: angular.module('forcaDeVendas', [
            'ngRoute',
            'ngCookies',
            'ngResource',
            'forcaDeVendas.clientes',
            'forcaDeVendas.login',
            'forcaDeVendas.Home',
            'forcaDeVendas.catalogo'
        ])
    };

    ForcaDeVendas.app.config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'home/home.html',
                controller: 'HomeController',
                data: {
                    headerPage: 1
                }
            })
            .when('/login', {
                templateUrl: 'login/login.html',
                controller: 'LoginController'
            })
            .when('/logout', {
                template: ' ',
                controller: 'LogoutController'
            })
            .when('/clientes', {
                templateUrl: 'clientes/clientes.html',
                controller: 'ClientesController',
                data: {
                    headerPage: 2
                }
            })
            .when('/cadastroClientes', {
        		templateUrl: 'clientes/cadastroClientes.html',
        		controller: 'CadastroController'
            })
            .when('/catalogo', {
        		templateUrl: 'catalogo/catalogo.html',
        		controller: 'CatalogoController',
        		data: {
                    headerPage: 3
                }
            })
            .otherwise({
                redirectTo: '/login'
            });
    }]);

    ForcaDeVendas.app.run(['$location', '$rootScope', '$cookieStore', '$http',
        function($location, $rootScope, $cookieStore, $http) {
            $rootScope.global = $cookieStore.get('global') || {};

            if ($rootScope.global.currentUser) {
                $http.defaults.headers.common['X-Auth-Token'] = $rootScope.global.currentUser.token;
            }

            $rootScope.$on('$locationChangeStart', function() {
                var newPath = $location.path(),
                    restrictedPage = $.inArray(newPath, ['/login', '/logout']) === -1,
                    loggedIn = $rootScope.global.currentUser;

                if (restrictedPage && !loggedIn) {
                    $location.path('/login');
                }

                if (loggedIn && newPath === '/login') {
                    $location.path('/');
                }
            });
        }
    ]);
})(angular, window);