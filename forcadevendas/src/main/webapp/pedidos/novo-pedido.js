(function(angular) {
	var pedidosModule = angular.module('forcaDeVendas.pedidos', []);

	pedidosModule.controller('NovoPedidoController', [
			'$scope',
			'$http',
			'PedidoService',
			'CarrinhoService',
			function($scope, $http, PedidoService, CarrinhoService) {

				$scope.representante;
				$scope.totalItensPedido;
				$scope.precoTotalPedido;

				var init = function() {
					$http.get('/rest/recursos/representante/meus-dados')
							.success(function(representante) {
								$scope.representante = representante;
							});
					$scope.totalItensPedido = CarrinhoService.totalItens();
					$scope.precoTotalPedido = "R$ " + CarrinhoService.precoTotal();
					$scope.dataPedido = new Date();
				}
				init();
				
			} ]);
})(angular);