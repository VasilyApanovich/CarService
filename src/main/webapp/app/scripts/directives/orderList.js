angular.module('autoserviceApp')
    .directive('orderList', function() {
        return {
            templateUrl: '/app/templates/userOrder.tpl.html',
            restrict: 'A',
            controller: ['$scope', '$attrs', 'clientService', function($scope, $attrs, clientService) {
                $scope.$watch('currentUserId', function() {
                    clientService.getOrders($scope.currentUserId)
                        .then(function(response){
                            $scope.orders = response.data;
                        });
                });

                $scope.resolveOrder = function (order) {
                    order.status = "Completed"
                    clientService.resolveOrder(order)
                        .then(function (response) {

                        })
                }
            }]
        };
    });