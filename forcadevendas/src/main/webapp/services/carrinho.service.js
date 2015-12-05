(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('CarrinhoService',function() {
        var items = [];
        return {
            list: function() {
                return items;
            },
        	add : function(item){
        		items.push(item);
        	}
        }
    });

    
})(angular);

