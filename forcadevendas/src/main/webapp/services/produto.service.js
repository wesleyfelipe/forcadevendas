(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('ProdutoService', ['$resource',
        function($resource) {
            return $resource('/rest/recursos/produto/:id');
        }]);
})(angular);