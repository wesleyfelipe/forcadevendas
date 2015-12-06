(function(angular) {
    var pedidosModule = angular.module('forcaDeVendas.pedidos', []);

    pedidosModule.controller('NovoPedidoController', ['$scope', 'PedidoService',
        function($scope, PedidoService) {

            $scope.formatPrice = function(price) {
                var formattedPrice;

                if (price.toLocaleString) {
                    formattedPrice = price.toLocaleString('pt-BR', {style: 'currency', currency: 'BRL'});
                } else {
                    formattedPrice = 'R$' + price;
                }

                return formattedPrice;
            };
        }
    ]);
})(angular);