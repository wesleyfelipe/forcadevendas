(function(angular) {
	var carrinhoModule = angular.module('forcaDeVendas.carrinho', []);

	carrinhoModule.controller('CarrinhoController', [
			'$scope',
			'$window',
			'CarrinhoService',
			function($scope, $window, CarrinhoService) {

				$scope.itens;

				var load = function() {
					$scope.itens = CarrinhoService.list();
				}
				load();

				$scope.calcularSubtotal = function(preco, qtde) {
					if (preco == null || qtde == null) {
						return '-';
					}
					return (preco * qtde).toFixed(2);
				}

				$scope.calcularTotal = function() {
					var total = 0;
					$scope.itens.every(function(item) {
						var subtotal = $scope.calcularSubtotal(
								item.precoPromocional, item.quantidade);
						if (subtotal === '-') {
							return false;
						}
						total += parseFloat(subtotal);
						return true;
					});

					if (total == 0) {
						return '-';
					}

					return total.toFixed(2);
				}

				$scope.calcularQtdeTotal = function() {
					var total = 0;
					$scope.itens.every(function(item) {
						if (!item.quantidade) {
							return false;
						}
						total += parseInt(item.quantidade);
						return true;
					});

					if (total == 0) {
						return '-';
					}

					return total;
				}
				
				$scope.gravarCarrinho = function(){
					CarrinhoService.save($scope.itens);
					load();
				}

				$scope.removerItem = function(item) {
					CarrinhoService.remove(item);
					load();
				}

				$scope.limparCarrinho = function() {
					CarrinhoService.clean();
					load();
				}
				
				$scope.criarPedido = function(){
					$window.location.href = '#/novo-pedido';
				}

			} ]);

})(angular);