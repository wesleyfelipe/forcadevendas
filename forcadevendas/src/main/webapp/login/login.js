(function(angular) {
    var loginModule = angular.module('forcaDeVendas.login', []);

    loginModule.controller('LoginController', ['$scope', '$http', 'AuthenticationService',
        function($scope, $http, AuthenticationService) {
            $scope.credentials = {};

            $scope.login = function login() {
                AuthenticationService.login($scope.credentials.username, $scope.credentials.password, function(response) {
                    if (response.token) {
                        AuthenticationService.setCredentials(response.token);
                        console.log('You\'re logged in');
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
})(angular);