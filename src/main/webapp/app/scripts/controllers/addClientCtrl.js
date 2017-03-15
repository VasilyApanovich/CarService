angular.module('autoserviceApp')
    .controller('AddClientCtrl', ['$scope', '$http', '$location', '$window',
        function($scope, $http, $location, $window){
            $scope.client = {};

            $scope.createNewClient = function() {
                $http({
                    method: 'POST',
                    data: $scope.client,
                    url: '/addClient'
                }).then(function success(data){
                    alert("User successfully created");
                    $location.path('/clientsList');
                    $window.location.reload();
                })
            };
    }]);