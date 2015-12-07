(function(angular) {
    var clientesModule = angular.module('forcaDeVendas.clientes');

    clientesModule.controller('EditarClienteController', ['$scope', '$route', '$http', 'ClienteService', 'GeoService',
    	function($scope, $route, $http, ClienteService, GeoService) {
    		$scope.cliente = {
				pais: undefined,
				estado: undefined,
				cidade: undefined
			};

    		$scope.paises = GeoService.pais.query(function() {
				// $scope.cliente.pais = $scope.paises[0];
				// $scope.getEstados($scope.cliente.pais.id);
			});

			$scope.getEstados = function getEstados(pais) {
				$scope.estados = GeoService.estado.query({
					pais: pais
				}, function() {
					// $scope.cliente.estado = $scope.estados[0];
					// $scope.getCidades($scope.cliente.estado.id);
				});
			};

			$scope.getCidades = function getCidades(estado) {
				$scope.cidades = GeoService.cidade.query({
					estado: estado
				}, function() {
					// $scope.cliente.cidade = $scope.cidades[0];
				});
			};

			var idCliente = $route.current.params.id;

    		var loadCliente = function loadCliente() {
    			ClienteService.get({
    				id: idCliente
    			}, function(response) {
    				$scope.cliente = response;

    				$scope.paises.$promise.then(function() {
    					$scope.cliente.pais = $scope.paises.find(function(element) {
		    				if (element.nome === $scope.cliente.enderecoComercial.pais) {
		    					return element;
		    				}
		    			});

    					$scope.getEstados($scope.cliente.pais.id);

    					$scope.estados.$promise.then(function() {
    						$scope.cliente.estado = $scope.estados.find(function(element) {
    							if (element.nome === $scope.cliente.enderecoComercial.estado) {
    								return element;
    							}
    						});

    						$scope.getCidades($scope.cliente.estado.id);

    						$scope.cidades.$promise.then(function() {
	    						$scope.cliente.cidade = $scope.cidades.find(function(element) {
	    							if (element.nome === $scope.cliente.enderecoComercial.cidade) {
	    								return element;
	    							}
	    						});
	    					});
    					});
    				});

    				console.log(response);
    			});
    		};

			loadCliente();

    		$scope.editar = function(){	
				var clientes = {
					cnpj: $scope.cliente.cnpj,
					email: $scope.cliente.email,
					fone: $scope.cliente.fone,
					enderecoComercial: {
						logradouro: $scope.cliente.enderecoComercial.logradouro,
						cep: $scope.cliente.enderecoComercial.cep,
						cidade: $scope.cliente.cidade.nome,
						estado: $scope.cliente.estado.nome,
						pais: $scope.cliente.pais.nome
					},
					nome: $scope.cliente.nome
				};
				
				$http.put('/rest/recursos/cliente/' + idCliente, clientes).success(function (){
					$scope.sucesso = true;

					var alertPos = $('#editar-header').offset().top;
					$(window).scrollTop(alertPos);
				});
			};
    	}
    ]);
})(angular);