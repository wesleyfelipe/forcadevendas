var clientesModule = angular.module('forcaDeVendas.clientes');
clientesModule.controller('CadastroController', ['$http','$scope', 'GeoService',
	function ($http, $scope, GeoService){
		$scope.cliente = {
			pais: undefined,
			estado: undefined,
			cidade: undefined
		};

		$scope.paises = GeoService.pais.query(function() {
			$scope.cliente.pais = $scope.paises[0];
			$scope.getEstados($scope.cliente.pais.id);
		});

		$scope.getEstados = function getEstados(pais) {
			$scope.estados = GeoService.estado.query({
				pais: pais
			}, function() {
				$scope.cliente.estado = $scope.estados[0];
				$scope.getCidades($scope.cliente.estado.id);
			});
		};

		$scope.getCidades = function getCidades(estado) {
			$scope.cidades = GeoService.cidade.query({
				estado: estado
			}, function() {
				$scope.cliente.cidade = $scope.cidades[0];
			});
		};

		$scope.cadastrar = function(){	
			var clientes = {
				cnpj: $scope.cliente.cnpj,
				email: $scope.cliente.email,
				fone: $scope.cliente.telefone,
				enderecoComercial: {
					logradouro: $scope.cliente.endereco,
					numero: $scope.cliente.numero,
					cep: $scope.cliente.cep,
					cidade: $scope.cliente.cidade,
					estado: $scope.cliente.estado,
					pais: $scope.cliente.pais
				},
				nome: $scope.cliente.nome
			};
			
			$http.post('/rest/recursos/cliente', clientes).success(function (){
				console.log("Deu");
			});

			$location.path('/home');
		};
	}
]);