/**
 * Created by iakoupov on 2016-11-22.
 */

angular.module('controllers').controller('MainController', MainController);

MainController.$inject = ['petService','$location','LoginDialogService', 'Session'];

function MainController(petService, $location, LoginDialogService, Session) {
    var vm = this;


    vm.showLogin = function () {
        LoginDialogService.openLogin().then(function (data) {
           console.log('dialog closed id:', data.id);
            
           
       })
    }
    
    vm.showLogout = function () {
        LoginDialogService.openLogout().then(function (data) {
            console.log('dialog closed id:', data.id);

            
        })
    }
    
    vm.loggedIn = function () {
        return Session.isLoggedIn();
    }

    
    vm.searchItem = function (item) {
        $location.path('/search/' + item);
    }
}

