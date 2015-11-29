(function(angular) {
	var catalogoModule = angular.module('forcaDeVendas.catalogo', []);

	catalogoModule
			.controller(
					'CatalogoController',
					[
							'$scope',
							'ProdutoService',
							'MarcaService',
							'CategoriaService',
							'DepartamentoService',
							function($scope, ProdutoService, MarcaService,
									CategoriaService, DepartamentoService) {

								// Listagens
								var updateList = function updateList() {
									$scope.produtos = ProdutoService.query();
								};
								updateList();

								var updateMarcas = function updateMarcas() {
									$scope.marcas = MarcaService.query();
								}
								updateMarcas();

								var updateDepartamentos = function updateDepartamentos() {
									$scope.departamentos = DepartamentoService
											.query();
								}
								updateDepartamentos();

								var updateCategorias = function updateCategorias() {
									$scope.categorias = CategoriaService
											.query();
								}
								updateCategorias();

								// Filtros
								$scope.filter = {
									marca : '',
									categoria : '',
									departamento : ''
								};

								$scope.filterByMarca = function(marca) {
									$scope.filter = {
										marca : marca,
										categoria : '',
										departamento : ''
									}
								}

								$scope.filterByDepartamento = function(
										departamento) {
									$scope.filter = {
										marca : '',
										categoria : '',
										departamento : departamento
									}
								}

								$scope.filterByCategoria = function(categoria) {
									$scope.filter = {
										departamento : '',
										marca : '',
										categoria : categoria
									}
								}

								$scope.doFilter = function(produtos, filter) {
									var results = [];
									produtos
											.forEach(function(produto) {
												if ((filter.categoria == '' || filter.categoria == produto.categoria)
														&& (filter.departamento == '' || filter.departamento == produto.departamento)
														&& (filter.marca == '' || filter.marca == produto.marca)) {

													results.push(produto);

												}

											});
									return results;
								}

								// Paginação
								$scope.currentPage = 0;
								$scope.pageSize = 9;

								$scope.numberOfPages = function(produtos) {
									return Math.ceil(produtos.length
											/ $scope.pageSize);
								}

								$scope.getNumber = function(num) {
									return (new Array(num));
								}

								$scope.changePage = function(pageNum) {
									$scope.currentPage = pageNum;
								};

							} ]);

})(angular);
