angular.module('autoserviceApp')
    .controller('EditClientCtrl', ['$scope', '$http', '$location', "$routeParams", "$window", function($scope, $http, $location, $routeParams, $window){

        $scope.currentUserId = $routeParams.id;

        $http({
            url: '/getClient',
            method: "GET",
            params: {id: $scope.currentUserId}
        }).then(function(response) {
            $scope.client = response.data;
        });

        $scope.editClient = function(clientId) {
            $http({
                method: 'POST',
                data: $scope.client,
                url: '/editClient'
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