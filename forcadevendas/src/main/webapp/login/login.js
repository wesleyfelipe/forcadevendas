(function(angular) {
    var loginModule = angular.module('forcaDeVendas.login', []);

    loginModule.controller('LoginController', ['$scope', '$http', '$location', 'AuthenticationService',
        function($scope, $http, $location, AuthenticationService) {
            $scope.credentials = {};
            $scope.ui = {
                error: false
            };

            var onLoginSuccess = function onLoginSuccess(response) {
                if (response.token) {
                    AuthenticationService.setCredentials($scope.credentials.username, response.token);
                    $location.path('/');
                } else {
                    $scope.ui.error = true;
                }
            },

            onLoginError = function onLoginError(response) {
                $scope.ui.error = true;
            };

            $scope.login = function login() {
                AuthenticationService.login($scope.credentials.username, $scope.credentials.password, 
                    onLoginSuccess, onLoginError);
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