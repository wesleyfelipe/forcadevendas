(function(angular) {
	var pedidosModule = angular.module('forcaDeVendas.pedidos', []);

	pedidosModule.controller('NovoPedidoController', [
			'$scope',
			'$http',
			'$window',
			'PedidoService',
			'CarrinhoService',
			'ClienteService',
			function($scope, $http, $window, PedidoService, CarrinhoService, ClienteService) {

				$scope.representante;
				$scope.listaClientes;
				$scope.totalItensPedido;
				$scope.precoTotalPedido;
				$scope.clientePedido;
				$scope.clienteSelecionado;
				$scope.enderecoEntrega;

				var init = function() {
					$http.get('/rest/recursos/representante/meus-dados')
							.success(function(representante) {
								$scope.representante = representante;
							});
					$scope.totalItensPedido = CarrinhoService.totalItens();
					$scope.precoTotalPedido = CarrinhoService.precoTotal();
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
					var pedido = {};
					pedido.idCliente = $scope.clientePedido.id;
					pedido.enderecoEntrega = {};
					pedido.enderecoEntrega.id = $scope.enderecoEntrega.id;
					pedido.itensPedido = [];
					CarrinhoService.list().forEach(function(item){
						pedido.itensPedido.push(parseItemPedido(item));
					});
					PedidoService.save(pedido, function(response) {
						CarrinhoService.clean();
					    $window.location.href = "#/catalogo";
					  });
				}
				
				var parseItemPedido = function(item){
					var itemPedido = {};
					itemPedido.idProduto = item.id;
					itemPedido.preco = item.precoPromocional;
					itemPedido.tamanho = item.tamanho;
					itemPedido.quantidade = item.quantidade;
					return itemPedido;
				}
				
			} ]);
})(angular);