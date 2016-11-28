/**
 * Created by iakoupov on 2016-11-27.
 */

angular.module('services').factory('LoginDialogService', LoginDialogService);

LoginDialogService.$inject = ['ngDialog'];

function LoginDialogService(ngDialog) {
    
    function openLogin() {
        
            return ngDialog.open({
                template: 'templates/login.html',
                controller: 'LoginController',
                controllerAs: 'vm'
            }).closePromise
    }
    
    function openLogout() {
        return ngDialog.open({
            template: 'templates/logout.html',
            controller: 'LoginController',
            controllerAs: 'vm'
        }).closePromise
    }

    function isAuthenticationOpen (){
        return ngDialog.getOpenDialogs() && ngDialog.getOpenDialogs().length;
    }
    
    return {
        
        openLogin: openLogin,
        openLogout: openLogout,
        isAuthenticationOpen: isAuthenticationOpen
        
    }
    
}
