(function(angular) {
	var carrinhoModule = angular.module('forcaDeVendas.carrinho', []);

	carrinhoModule.controller('CarrinhoController', [ '$scope',
			'CarrinhoService', function($scope, CarrinhoService) {
				$scope.produtos;

				var load = function() {
					$scope.produtos = CarrinhoService.list();
				}
				load();

			} ]);

})(angular);