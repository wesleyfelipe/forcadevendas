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

        $scope.getStatusClass = function getStatusClass(status) {
            if (status === 'Ativo') {
                return 'label-success';
            }

            if (status === 'Inativo') {
                return 'label-danger';
            }

            return 'label-default';
        };
    }]);
})(angular);