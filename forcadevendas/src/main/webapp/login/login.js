(function(angular) {
    var loginModule = angular.module('forcaDeVendas.login', []);

    loginModule.controller('LoginController', ['$scope', '$http', '$location', 'AuthenticationService',
        function($scope, $http, $location, AuthenticationService) {
            $scope.credentials = {};

            $scope.login = function login() {
                AuthenticationService.login($scope.credentials.username, $scope.credentials.password, function(response) {
                    if (response.token) {
                        AuthenticationService.setCredentials($scope.credentials.username, response.token);
                        console.log('You\'re logged in');
                        $location.path('/');
                    }
                });
            };

            $scope.doSomething = function() {
                $http.get('/rest/recursos/cliente').success(function(response) {
                    console.log('Behold the data', response);
                });
            };
        }
    ]);

    loginModule.controller('LogoutController', ['$location', 'AuthenticationService', 
        function($location, AuthenticationService) {
            AuthenticationService.logout(function() {
                $location.path('/login');
            });
        }
    ]);
})(angular);