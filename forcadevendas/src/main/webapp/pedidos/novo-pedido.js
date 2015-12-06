(function(angular) {
	var pedidosModule = angular.module('forcaDeVendas.pedidos', []);

	pedidosModule.controller('NovoPedidoController', [
			'$scope',
			'$http',
			'PedidoService',
			'CarrinhoService',
			'ClienteService',
			function($scope, $http, PedidoService, CarrinhoService, ClienteService) {

				$scope.representante;
				$scope.listaClientes;
				$scope.totalItensPedido;
				$scope.precoTotalPedido;
				$scope.clientePedido;
				$scope.clienteSelecionado;

				var init = function() {
					$http.get('/rest/recursos/representante/meus-dados')
							.success(function(representante) {
								$scope.representante = representante;
							});
					$scope.totalItensPedido = CarrinhoService.totalItens();
					$scope.precoTotalPedido = "R$ " + CarrinhoService.precoTotal();
					$scope.dataPedido = new Date();
					$scope.listaClientes = ClienteService.query();
				}
				init();
				
				$scope.findCliente = function(idCliente){
					ClienteService.get({
						id : idCliente
					}, function(response) {
						$scope.clientePedido = angular.fromJson(response);
					});
				}
				
				$scope.realizarPedido = function(){
					console.log("teste");
				}
				
			} ]);
})(angular);