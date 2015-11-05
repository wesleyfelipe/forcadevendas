(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('AuthenticationService', ['$http', function($http) {
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

            setCredentials: function(token) {
                $http.defaults.headers.common['X-Auth-Token'] = token;
            },

            clearCredentials: function() {
                $http.defaults.headers.common['X-Auth-Token'] = '';
            }
        }
    }]);
})(angular);