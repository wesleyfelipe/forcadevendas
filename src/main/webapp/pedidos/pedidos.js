(function(angular) {
    var pedidosModule = angular.module('forcaDeVendas.pedidos', []);

    pedidosModule.controller('PedidosController', ['$scope', '$window', 'PedidoService',
        function($scope, $window, PedidoService) {
            var updateList = function updateList() {
                $scope.pedidos = PedidoService.query();
            };

            updateList();

            $scope.formatPrice = function(price) {
                var formattedPrice;

                if (price.toLocaleString) {
                    formattedPrice = price.toLocaleString('pt-BR', {style: 'currency', currency: 'BRL'});
                } else {
                    formattedPrice = 'R$' + price;
                }

                return formattedPrice;
            };
            
            $scope.visualizarPedido = function(idPedido){
				$window.location.href = '#/pedido/'+ idPedido;
			}
        }
    ]);
})(angular);