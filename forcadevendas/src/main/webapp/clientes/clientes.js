(function(angular) {
    var clientesModule = angular.module('forcaDeVendas.clientes', []);

    clientesModule.controller('ClientesController', ['$scope', 'ClienteService',
        function($scope, ClienteService) {
            var updateList = function updateList() {
                $scope.clientes = ClienteService.query();
            };

            updateList();

            $scope.ui = {
                filtroAberto: false
            };

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

                return 'Inativo';
            };

            $scope.formatCNPJ = function formatCNPJ(cnpj) {
                return cnpj.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/g,"\$1.\$2.\$3\/\$4\-\$5");
            };

            $scope.onFiltroClick = function onFiltroClick() {
                $scope.ui.filtroAberto = !$scope.ui.filtroAberto;
            };

            $scope.applyFilter = function applyFilter() {
                var searchId = $scope.searchId,
                    nome = $scope.searchNome,
                    cnpj = $scope.searchCnpj,
                    searchStatus = $scope.searchStatus;

                $scope.search = {
                    id: searchId,
                    nome: nome,
                    cnpj: cnpj
                };

                $scope.statusFilter = searchStatus;
            };

            $scope.cleanFilter = function cleanFilter() {
                $scope.search = {};
                $scope.statusFilter = '';

                $scope.searchId = '';
                $scope.searchNome = '';
                $scope.searchStatus = '';
                $scope.searchCnpj = '';
            };
        }]);

    clientesModule.filter('filterByStatus', function() {
        return function(clientes, param) {
            var results = [];

            clientes.forEach(function(cliente) {
                if (!param || cliente.situacao === param) {
                    results.push(cliente);
                }
            });

            return results;
        };
    });
})(angular);