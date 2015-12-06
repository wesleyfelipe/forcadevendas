(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('PedidoService', ['$resource',
        function($resource) {
            return $resource('/rest/recursos/pedido');
        }]);
})(angular);