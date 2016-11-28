/**
 * Created by iakoupov on 2016-11-24.
 */

angular.module('controllers').controller('PetEdit', PetEdit);

PetEdit.$inject = ['$routeParams','petService','$location']

function PetEdit($routeParams, petService, $location) {
    var vm = this;

    petService.getPetById($routeParams.petId).then(function (data) {
        vm.pet = data;
    }).catch(function (error) {
        console.log('error in  petService.getPetById()', error);
    })

    vm.updatePet = function (pet) {
        // send photos as well
        petService.updatePet(pet).success(function (response) {
            console.log('updated pet', response);

            $location.path('/pets');
        }).catch(function (error) {
            
        })
    }

    vm.showPhotos = function () {
        return vm.pet && vm.pet.images && vm.pet.images.length > 0;
    }

    vm.clearPhotoSelections = function () {
        delete vm.photos;
        document.getElementById('photos').value = null;
    }

    vm.removeImage = function (img) {
        var index = vm.pet.images.indexOf(img);
        vm.pet.images.splice(index, 1);
    }




    vm.cancel = function () {
        vm.pet = {};
        $location.path('/pets');
    }



}
