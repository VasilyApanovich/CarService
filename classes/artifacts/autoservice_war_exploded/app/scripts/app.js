var app = angular.module('autoserviceApp', ['ngRoute']);

app.config(['$routeProvider',function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/app/templates/mainPage.html'
        })
        .when('/addClient', {
            templateUrl: '/app/templates/addClient.tpl.html',
            controller: 'AddClientCtrl'
        })
        .when('/clientDetails/:id', {
            templateUrl: '/app/templates/editClientPage.html',
            controller: 'EditClientCtrl'
        })
        .when('/clientsList', {
            templateUrl: '/app/templates/clientsList.html'
        })
        .when('/addOrder/:id', {
            templateUrl: '/app/templates/addOrder.html',
            controller: 'AddOrderCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);

