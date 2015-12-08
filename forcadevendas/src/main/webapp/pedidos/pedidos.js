(function(angular) {
    var pedidosModule = angular.module('forcaDeVendas.pedidos', []);

    pedidosModule.controller('PedidosController', ['$scope', '$window', 'PedidoService',
        function($scope, $window, PedidoService) {
            var updateList = function updateList() {
                $scope.pedidos = PedidoService.query();
            };

            updateList();
            
            $scope.visualizarPedido = function(idPedido){
				$window.location.href = '#/pedido/'+ idPedido;
			}
        }
    ]);
})(angular);