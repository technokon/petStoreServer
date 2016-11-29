/**
 * Created by iakoupov on 2016-11-22.
 */


angular.module('controllers').controller('PetDetailController', PetDetailController);

PetDetailController.$inject = ['$routeParams', 'petService', '$location', 'confirmDialog'];

function PetDetailController($routeParams, petService, $location, confirmDialog) {
    
    var vm = this;
    
    petService.getPetById($routeParams.petId).then(function (data) {
        vm.pet = data;
        //vm.mainImage = data.images[0];
    }).catch(function (error) {
        console.log('error in  petService.getPetById()', error);
    })

    vm.setImage = function(image) {
        vm.mainImage = image;
    };

    vm.listPage = function () {
        $location.path('/search');
    }

    vm.editPet = function (id) {
        $location.path('/petEdit/' + id);
    }
    
    vm.removePet = function (pet) {
        
        // pop a dialog before removing the pet
        confirmDialog.openConfirm('Are you sure you want to remove this pet?').then(function (data) {
            
            console.log('inside PetDetailController remove pet', data);

            petService.removePet(pet.id).success(function (data) {
                $location.path('/pets');
            });

        }).catch(function (rejection) {
            console.log('not removing the pet', rejection);
        })

    }
    
}