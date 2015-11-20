var clientesModule = angular.module('forcaDeVendas.clientes');
clientesModule.controller('CadastroController', ['$http','$scope', function ($http, $scope){
	$scope.cliente = {};
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
	};
}])

