/**
 * Created by iakoupov on 2016-11-22.
 */

var app = angular.module('petStoreApp', [
    'ngRoute',
    'petAnimations',
    'services',
    'controllers',
    'directives',
    'ngDialog']);


app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
        when('/options', {
            templateUrl: 'templates/options.html',
            controller: 'MainController',
            controllerAs: 'vm'
        }).
        when('/search/:item?', {
            templateUrl: 'templates/pet-list.html',
            controller: 'PetListController',
            controllerAs: 'vm'
        }).
        when('/pets/:petId', {
            templateUrl: 'templates/pet-detail.html',
            controller: 'PetDetailController',
            controllerAs: 'vm'
        }).
        when('/petForm', {
            templateUrl: 'templates/pet-form.html',
            controller: 'PetForm',
            controllerAs: 'vm'
        }).
        when('/petEdit/:petId', {
            templateUrl: 'templates/pet-edit.html',
            controller: 'PetEdit',
            controllerAs: 'vm'
        }).
        when('/login', {
            templateUrl: 'templates/login.html',
            controller: 'LoginController',
            controllerAs: 'vm'
        }).
        otherwise({
            redirectTo: '/options'
        });
    }]);


