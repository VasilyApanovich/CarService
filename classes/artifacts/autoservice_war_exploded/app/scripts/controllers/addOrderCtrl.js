angular.module('autoserviceApp')
    .controller('AddOrderCtrl', ['$scope', '$http', '$location', "$routeParams", "$window", function($scope, $http, $location, $routeParams, $window){

        $scope.currentUserId = $routeParams.id;

        $scope.addOrder = function(clientId) {
            $http({
                method: 'POST',
                data: {order: $scope.order, clientId: $scope.currentUserId},
                url: '/addOrder'
            }).then(function success(data){
                alert("Client info successfully updated");
                $location.path('/clientsList');
                $window.location.reload();
            });
        };

        $scope.cancel = function () {
            $location.path('/clientsList');
        };
    }]);