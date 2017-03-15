angular.module('autoserviceApp')
    .service('clientService', ['$http', function($http){

        this.getClientsList = function() {
            return $http({
                method: 'GET',
                url: '/listClients'
            });
        }

        this.deleteClient = function(userId) {
            return $http({
                method: 'POST',
                data: userId,
                url: '/deleteClient'
            })
        }

        this.getOrders = function(clientId) {
            return $http({
                method: 'POST',
                data: clientId,
                url: '/listOrders'
            })
        }

        this.resolveOrder = function(order) {
            return $http({
                method: 'POST',
                data: order,
                url: '/editOrder'
            })
        }
    }]);
