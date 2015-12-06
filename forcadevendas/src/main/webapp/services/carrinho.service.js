(function(angular) {
    var app = angular.module('forcaDeVendas');

    app.factory('CarrinhoService',['$window', function($window) {
        var itens = [];
        var localStorage = 'carrinho';
        return {
        	
            list: function() {
            	itens = JSON.parse($window.localStorage[localStorage] || '[]');
                return itens;
            },
            
            
        	add : function(item){
        		var existingItemIndex = -1;
        		itens.some(function(it, index){
        			if(it.id === item.id && it.tamanho === item.tamanho){
        				existingItemIndex = index;
        				return true;
        			}
        			return false;
        		});
        		
        		if(existingItemIndex !== -1){
        			itens[existingItemIndex].quantidade += item.quantidade;
        		} else {
        			itens.push(item);
        		}
        		
        		$window.localStorage[localStorage] = JSON.stringify(itens);
        		itens = JSON.parse($window.localStorage[localStorage] || '[]');
        	},
        	
        	
        	remove : function(item){
        		var index = itens.indexOf(item);
        		if (index > -1) {
        		    itens.splice(index, 1);
        		    $window.localStorage[localStorage] = JSON.stringify(itens);
            		itens = JSON.parse($window.localStorage[localStorage] || '[]');
        		}
        	},
        	
        	clean : function(){
        		$window.localStorage.removeItem(localStorage);
        		itens = [];
        	},
        	
        	totalItens : function(){
        		itens = JSON.parse($window.localStorage[localStorage] || '[]');
        		var total = 0;
				itens.forEach(function(item) {
					total += parseInt(item.quantidade);
				});
				return total;
        	},
        	
        	precoTotal : function(){
        		itens = JSON.parse($window.localStorage[localStorage] || '[]');
        		var total = 0;
				itens.forEach(function(item) {
					var subtotal = (item.precoPromocional * item.quantidade).toFixed(2);
					total += parseFloat(subtotal);
				});
				return total.toFixed(2);
        	}
        }
    }]);

    
})(angular);

