(function(angular, ForcaDeVendas) {
     angular.module('forcaDeVendas')
     .directive('header', function() {
        return {
            restrict: 'A',
            replace: true,
            templateUrl: '/header/header.html',
            controller: ['$rootScope', '$scope', '$route',
                function($rootScope, $scope, $route) {
                    var currentPage,
                        currentRouteData = $route.current.$$route.data;

                    if (currentRouteData) {
                        currentPage = currentRouteData.headerPage;
                    }

                    $rootScope.$on('$locationChangeSuccess', function() {
                        currentRouteData = $route.current.$$route.data;

                        if (currentRouteData) {
                            currentPage = currentRouteData.headerPage;
                        } else {
                            currentPage = undefined;
                        }
                    });

                    $scope.isActive = function(pageNumber) {
                        return pageNumber === currentPage;
                    };
            }]
        };
    });
})(angular, ForcaDeVendas);