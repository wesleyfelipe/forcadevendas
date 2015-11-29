(function(angular) {
	var catalogoModule = angular.module('forcaDeVendas.catalogo', []);

	catalogoModule.controller('CatalogoController', [ '$scope',
			'ProdutoService', function($scope, ProdutoService) {
				var updateList = function updateList() {
					$scope.produtos = ProdutoService.query();
				};

				updateList();

				$scope.currentPage = 0;
				$scope.pageSize = 9;
				
				$scope.numberOfPages = function(produtos) {
					return Math.ceil(produtos.length / $scope.pageSize);
				}

				$scope.getNumber = function(num) {
					return (new Array(num));
				}
				
				$scope.changePage= function(pageNum){
				    $scope.currentPage = pageNum;
				};
				
			} ]);

})(angular);
