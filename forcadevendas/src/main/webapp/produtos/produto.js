(function(angular) {
	var produtoModule = angular.module('forcaDeVendas.produto', []);

	produtoModule.controller('ProdutoController', [ '$scope', '$route',
			'$location', 'ProdutoService',
			function($scope, $route, $location, ProdutoService) {

				$scope.teste;
				$scope.produto;
				var load = function() {
					ProdutoService.get({
						id : $route.current.params.idProduto
					}, function(response) {
						$scope.produto = angular.fromJson(response);
					});
				}
				load();

			} ]);

})(angular);
