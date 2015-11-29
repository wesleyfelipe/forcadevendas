(function(angular) {
	var catalogoModule = angular.module('forcaDeVendas.catalogo', []);

	catalogoModule.controller('CatalogoController', [ '$scope',
			'ProdutoService', 'MarcaService', 'CategoriaService', function($scope, ProdutoService, MarcaService, CategoriaService) {
				var updateList = function updateList() {
					$scope.produtos = ProdutoService.query();
				};
				updateList();
				
				var updateMarcas = function updateMarcas(){
					$scope.marcas = MarcaService.query();
				}
				updateMarcas();
				
				var updateCategorias = function updateCategorias(){
					$scope.categorias = CategoriaService.query();
				}
				updateCategorias();

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
