/**
 * Created by iakoupov on 2016-11-28.
 */

angular.module('services').factory('confirmDialog', ConfirmDialog);

ConfirmDialog.$inject = ['ngDialog'];

function ConfirmDialog(ngDialog) {
    
    function openConfirm(message) {

        return ngDialog.open({
            template: 'templates/confirm.html',
            controller: 'ConfirmController',
            controllerAs: 'vm',
            data: {
                message: message
            }
        }).closePromise.then(function (data) {
            if (data.value) {
                return Promise.resolve(data.value);
            }
            return Promise.reject('No data passed back');
        })
    }
    
    return {
        
        openConfirm: openConfirm
        
    }
}
