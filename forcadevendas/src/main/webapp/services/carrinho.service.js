(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('CarrinhoService',['$window', function($window) {
        var itens = [];
        return {
            list: function() {
            	itens = JSON.parse($window.localStorage['carrinho'] || '{}');
                return itens;
            },
        	add : function(item){
        		itens.push(item);
        		$window.localStorage['carrinho'] = JSON.stringify(itens);
        	}
        }
    }]);

    
})(angular);

