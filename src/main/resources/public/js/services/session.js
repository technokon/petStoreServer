/**
 * Created by iakoupov on 2016-11-23.
 */


angular.module('services').factory('Session', Session);

Session.$inject = [];

function Session() {
    
    var loggedIn = false;
    
    function isLoggedIn() {
        return loggedIn;
    }

    function login() {
       loggedIn = true;
    }

    function logout() {
        loggedIn = false;
    }

    return {
        login: login,
        logout: logout,
        isLoggedIn: isLoggedIn
    };
}


