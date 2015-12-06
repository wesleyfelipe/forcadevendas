(function(angular) {
	var carrinhoModule = angular.module('forcaDeVendas.carrinho', []);

	carrinhoModule.controller('CarrinhoController', [
			'$scope',
			'$location',
			'$route',
			'CarrinhoService',
			function($scope, $location, $route, CarrinhoService) {

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

				$scope.removerItem = function(item) {
					CarrinhoService.remove(item);
					if ($scope.itens.length == 0) {
						$route.current = '#/catalogo';
					} else {
						load();
					}
				}
				
				$scope.limparCarrinho = function(){
					CarrinhoService.clean();
					load();
				}

			} ]);

})(angular);