(function(angular, window, undefined) {
	window.ForcaDeVendas = {
		app : angular.module('forcaDeVendas', [ 'ngRoute', 'ngCookies',
				'ngResource', 'forcaDeVendas.clientes', 'forcaDeVendas.login',
				'forcaDeVendas.Home', 'forcaDeVendas.catalogo',
				'forcaDeVendas.meusDados', 'forcaDeVendas.produto',
				'forcaDeVendas.carrinho', 'forcaDeVendas.pedidos' ])
	};

	ForcaDeVendas.app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/', {
			templateUrl : 'home/home.html',
			controller : 'HomeController',
			data : {
				headerPage : 1
			}
		}).when('/login', {
			templateUrl : 'login/login.html',
			controller : 'LoginController'
		}).when('/logout', {
			template : ' ',
			controller : 'LogoutController'
		}).when('/clientes', {
			templateUrl : 'clientes/clientes.html',
			controller : 'ClientesController',
			data : {
				headerPage : 2
			}
		}).when('/cadastro-cliente', {
			templateUrl : 'clientes/cadastroClientes.html',
			controller : 'CadastroController'
		}).when('/catalogo', {
			templateUrl : 'catalogo/catalogo.html',
			controller : 'CatalogoController',
			data : {
				headerPage : 3
			}
		}).when('/meus-dados', {
			templateUrl : 'meus-Dados/meus-dados.html',
			controller : 'MeusDadosController',
			data : {
				headerPage : 4
			}
		}).when('/carrinho', {
			templateUrl : 'carrinho/carrinho.html',
			controller : 'CarrinhoController',
			data : {
				headerPage : 5
			}
		}).when('/produtos/:idProduto', {
			templateUrl : function(param) {
				if (!param) {
					return 'home/home.html';
				}
				return 'produtos/produto.html';
			},
			controller : 'ProdutoController',
			data : {
				headerPage : 3
			}
		}).when('/pedidos', {
			templateUrl : 'pedidos/pedidos.html',
			controller : 'PedidosController',
			data : {
				headerPage : 6
			}
		}).when('/novo-pedido', {
			templateUrl : 'pedidos/novo-pedido.html',
			controller : 'NovoPedidoController',
			data : {
				headerPage : 6
			}
		}).when('/pedido/:idPedido', {
			templateUrl : 'pedidos/view-pedido.html',
			controller : 'PedidoViewController',
			data : {
				headerPage : 6
			}
		}).otherwise({
			redirectTo : '/login'
		});
	} ]);

	ForcaDeVendas.app.filter('startFrom', function() {
		return function(input, start) {
			start = +start; // parse to int
			return input.slice(start);
		}
	});

	ForcaDeVendas.app
			.run([
					'$location',
					'$rootScope',
					'$cookieStore',
					'$http',
					function($location, $rootScope, $cookieStore, $http) {
						$rootScope.global = $cookieStore.get('global') || {};

						if ($rootScope.global.currentUser) {
							$http.defaults.headers.common['X-Auth-Token'] = $rootScope.global.currentUser.token;
						}

						$rootScope
								.$on(
										'$locationChangeStart',
										function() {
											var newPath = $location.path(), restrictedPage = $
													.inArray(newPath,
															[ '/login',
																	'/logout' ]) === -1, loggedIn = $rootScope.global.currentUser;

											if (restrictedPage && !loggedIn) {
												$location.path('/login');
											}

											if (loggedIn
													&& newPath === '/login') {
												$location.path('/');
											}
										});
					} ]);
})(angular, window);