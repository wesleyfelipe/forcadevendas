(function(angular) {
	var pedidosModule = angular.module('forcaDeVendas.pedidos');

	pedidosModule.controller('PedidoViewController', [ '$scope', '$route',
			'PedidoService', 'ClienteService', function($scope, $route, PedidoService, ClienteService) {
		
				$scope.pedido;
				$scope.clientePedido;
				$scope.enderecoEntrega;
				
				var loadPedido = function loadPedido() {
					PedidoService.get({
						id : $route.current.params.idPedido
					}, function(response) {
						$scope.pedido = angular.fromJson(response);
						loadCliente(response);
					});
				};
				loadPedido();
				
				var loadCliente = function(pedido){
					ClienteService.get({
						id: pedido.idCliente
					}, function(response){
						$scope.clientePedido = angular.fromJson(response);
					});
				}
				
			} ]);
})(angular);