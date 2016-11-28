/**
 * Created by iakoupov on 2016-11-22.
 */

angular.module('controllers').controller('PetListController', PetListController);

PetListController.$inject = ['petService', '$location', '$routeParams'];

function PetListController(petService, $location, $routeParams) {
    var vm = this;
    
    // if there are any parameters then search the server by it
    petService.getPets($routeParams.item).then(function (response) {
        vm.pets = response.data;
    }).catch(function (error){
        console.log('error in petService.getPets()', error);
    });
    
    vm.addPet = function () {
        $location.path('/petForm');
    }
}
