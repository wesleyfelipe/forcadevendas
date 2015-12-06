(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('AuthenticationService', ['$http', '$cookieStore', '$rootScope', 'CarrinhoService',
        function($http, $cookieStore, $rootScope, CarrinhoService) {
            var clearCredentials = function clearCredentials() {
                    $rootScope.global = {};
                    $cookieStore.remove('global');
                    $http.defaults.headers.common['X-Auth-Token'] = undefined;
                };

            return {
                login: function(user, password, successCallback, errorCallback) {
                    var credentials = {
                        username: user,
                        password: password
                    };

                    $http.post('/rest/login', credentials)
                        .success(function(response) {
                            successCallback(response);
                        }.bind(this))
                        .error(function(response, status) {
                            errorCallback(response);
                        });
                },

                logout: function(callback) {
                    clearCredentials();
                    CarrinhoService.clean();
                    callback();
                },

                setCredentials: function(user, token) {
                    $rootScope.global = {
                        currentUser: {
                            username: user,
                            token: token
                        }
                    };

                    $http.defaults.headers.common['X-Auth-Token'] = token;
                    $cookieStore.put('global', $rootScope.global);
                }
            }
        }
    ]);
})(angular);