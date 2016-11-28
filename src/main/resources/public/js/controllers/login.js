/**
 * Created by iakoupov on 2016-11-22.
 */


angular.module('controllers').controller('LoginController', LoginController);

LoginController.$inject = ['$scope','Session', 'petService'];

function LoginController($scope, Session, petService) {
    var vm = this;
    
    vm.user = {};
    
    
    
    vm.login = function () {

        petService.login(vm.user).success(function (data) {
            // close the dialog
            $scope.closeThisDialog(1);
            
            Session.login();
        }).catch(function (rejection) {
            if (rejection && rejection.status && rejection.status == 401) {
                console.log('Invalid credentials!!!');
                vm.error = 'Invalid credentials!!!';
            }
        })

    }
    
    vm.logout = function () {
        petService.logout(vm.user).success(function (data) {
            // close the dialog
            $scope.closeThisDialog(1);
            
            Session.logout();
        })
    }
    
    vm.cancel = function () {
        // close the dialog
        $scope.closeThisDialog(0);
    }


    
    
    
}