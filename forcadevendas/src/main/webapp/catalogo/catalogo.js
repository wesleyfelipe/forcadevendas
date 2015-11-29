(function(angular) {
   var clientesModule = angular.module('forcaDeVendas.catalogo', []);

    clientesModule.controller('CatalogoController', ['$scope', 'ProdutoService',
        function($scope, ProdutoService) {
            var updateList = function updateList() {
                $scope.produtos = ProdutoService.query();
            };

            updateList();

        }]);
})(angular);