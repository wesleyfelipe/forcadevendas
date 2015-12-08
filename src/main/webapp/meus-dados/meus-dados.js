(function(angular) {
	var meusDadosModule = angular.module('forcaDeVendas.meusDados', []);
	meusDadosModule.controller('MeusDadosController', [
			'$http',
			'$scope',
			function($http, $scope) {

				$http.get('/rest/recursos/representante/meus-dados').success(
						function(representante) {
							$scope.representante = representante;
						});

				$scope.getStatusClass = function getStatusClass(status) {
					if (status === 'A') {
						return 'label-success';
					}

					if (status === 'I') {
						return 'label-danger';
					}

					return 'label-default';
				};

				$scope.getSituacaoText = function getSituacaoText(status) {
					if (status === 'A') {
						return 'Ativo';
					}
					
					if(status === 'I'){
						return 'Inativo';
					}

					return 'Indefinido';
				};
				
				$scope.getFoneFormatado = function getFoneFormatado(fone){
					return fone.substring(0,4) + "-" + fone.substring(4,8);
				}
				
			} ]);
})(angular);