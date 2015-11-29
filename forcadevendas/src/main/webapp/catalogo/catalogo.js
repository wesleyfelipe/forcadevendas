(function(angular) {
   var catalogoModule = angular.module('forcaDeVendas.catalogo', []);

    catalogoModule.controller('CatalogoController', ['$scope', 'ProdutoService',
        function($scope, ProdutoService) {
            var updateList = function updateList() {
                $scope.produtos = ProdutoService.query();
            };

            updateList();

        }]);
})(angular);