(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('AuthenticationService', ['$http', '$cookieStore', '$rootScope',
        function($http, $cookieStore, $rootScope) {
            var clearCredentials = function clearCredentials() {
                    $rootScope.global = {};
                    $cookieStore.remove('global');
                    $http.defaults.headers.common['X-Auth-Token'] = undefined;
                };

            return {
                login: function(user, password, callback) {
                    var credentials = {
                        username: user,
                        password: password
                    };

                    $http.post('/rest/login', credentials)
                        .success(function(response) {
                            callback(response);
                        }.bind(this));
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