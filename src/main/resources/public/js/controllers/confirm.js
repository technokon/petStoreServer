/**
 * Created by iakoupov on 2016-11-22.
 */


angular.module('controllers').controller('ConfirmController', ConfirmController);

ConfirmController.$inject = ['$scope'];

function ConfirmController($scope) {
    var vm = this;
    
    vm.message = 'Are you sure?';
    
    if ($scope.ngDialogData && $scope.ngDialogData.message) {
        vm.message = $scope.ngDialogData.message;
    }

    
    vm.yes = function () {
        // close the dialog with a promise
        $scope.closeThisDialog(Promise.resolve('yes'));

    }
    
    vm.no = function () {
        // close the dialog
        $scope.closeThisDialog(Promise.reject('no'));
    }
    
    vm.cancel = function () {
        // close the dialog
        $scope.closeThisDialog(0);
    }

}