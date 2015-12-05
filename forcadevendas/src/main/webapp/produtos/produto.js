(function(angular) {
	var produtoModule = angular.module('forcaDeVendas.produto', []);

	produtoModule.controller('ProdutoController', [ '$scope', '$route',
			'$location', 'ProdutoService', 'CarrinhoService',
			function($scope, $route, $location, ProdutoService, CarrinhoService) {

				$scope.teste;
				$scope.produto;
				var load = function() {
					ProdutoService.get({
						id : $route.current.params.idProduto
					}, function(response) {
						$scope.produto = angular.fromJson(response);
						$scope.produto.tamanho = 36;
						$scope.quantidade = 1;
					});
				}
				load();
				
				$scope.addItemAoCarrinho = function(item){
					CarrinhoService.add(item);
				}

			} ]);

})(angular);
