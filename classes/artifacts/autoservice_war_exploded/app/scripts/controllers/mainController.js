angular.module('autoserviceApp')
    .controller('mainCtrl', ['$scope', '$location', 'clientService', function($scope, $location, clientService) {
        getClients();

        $scope.currentUserId = null;

        $scope.createNewUser = function () {
            $location.path('/addClient');
        };

        $scope.editUser = function (userId) {
            $location.path('/clientDetails/' + userId);
        };

        $scope.deleteUser = function (clientId) {
            clientService.deleteClient(clientId)
                .then(function success(data){
                    alert("Client successfully deleted");
                    getClients();
                })
        };

        $scope.setCurrentUserId = function(event) {
            $scope.currentUserId = +event.target.parentElement.getAttribute('id');
        };

        function getClients() {
            clientService.getClientsList()
                .then(function successCallback(response) {
                    $scope.clients = response.data;
                }, function errorCallback(response) {
                    alert("ERROR WHEN GETTING CLIENTS LIST")
                });
        }



















        $scope.showLoginForm = false;
        $scope.showLoginButton = true;
        $scope.showLogoutButton = false;
        $scope.errorMsg = "";
        $scope.login = '';
        $scope.password = '';
        $scope.clickNearForm = function() {
            $scope.showLoginForm = false;
        };
        $scope.loginBtnClick = function() {
            $scope.showLoginForm = true;
        };

        $scope.logoutBtnClick = function() {
            $scope.showLogoutButton = false;
            $scope.showLoginButton = true;
            $rootScope.user = {
                patient: null,
                worker: null,
                admin: null
            };
            $location.url('/');
        };

        $scope.formOnClick = function($event) {
            $event.stopPropagation();
        };

        $scope.$watch('login', function() {
            if (!$scope.login) {
                $scope.login = '';
            }
           $scope.login = $scope.login.replace(/[^a-zA-Z0-9-_]/g, '');
        });

        $scope.$watch('password', function() {
            if (!$scope.password) {
                $scope.password = '';
            }
            $scope.password = $scope.password.replace(/[^a-zA-Z0-9]/g, '');
        });

        $scope.submitFunct = function() {
            $http({
                method: 'POST',
                data: JSON.stringify({'login': $scope.login, 'password': $scope.password}),
                url: '/authorization'
            }).then(function successCallback(response) {
                var data = response.data;
                if (!data.status) {
                    $scope.errorMsg = data.message;
                    return;
                }
                $scope.showLoginForm = false;
                $scope.showLogoutButton = true;
                $scope.showLoginButton = false;
                switch (data.user) {
                    case 'admin':
                        $rootScope.user.admin = data.id;
                        $location.url('/admin');
                        break;
                    case 'patient':
                        $rootScope.user.patient = data.id;
                        $location.url('/patient');
                        break;
                    case 'worker':
                        $rootScope.user.worker = data.id;
                        $location.url('/worker');
                        break;
                }
            }, function errorCallback(response) {
                console.log(response);
            });
        };

    }]);