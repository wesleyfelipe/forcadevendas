(function(angular) {
    var clientesModule = angular.module('forcaDeVendas.clientes', []);

    clientesModule.controller('ClientesController', ['$scope', function($scope) {
        var mockClients = [
            {
                id: '<Código>',
                nome: '<Nome>',
                status: '<Status>',
                cnpj: '<CNPJ>'
            },
            {
                id: '001',
                nome: 'Cliente #001',
                status: 'Ativo',
                cnpj: '00.000.000/0001-00'
            },
            {
                id: '002',
                nome: 'Cliente #002',
                status: 'Ativo',
                cnpj: '00.000.000/0001-00'
            },
            {
                id: '003',
                nome: 'Cliente #003',
                status: 'Inativo',
                cnpj: '00.000.000/0001-00'
            },
            {
                id: '004',
                nome: 'Cliente #004',
                status: 'Ativo',
                cnpj: '00.000.000/0001-00'
            }
        ];

        $scope.clientes = mockClients;

        $scope.ui = {
            filtroAberto: false
        };

        $scope.getStatusClass = function getStatusClass(status) {
            if (status === 'Ativo') {
                return 'label-success';
            }

            if (status === 'Inativo') {
                return 'label-danger';
            }

            return 'label-default';
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
                if (!param || cliente.status === param) {
                    results.push(cliente);
                }
            });

            return results;
        };
    })
})(angular);