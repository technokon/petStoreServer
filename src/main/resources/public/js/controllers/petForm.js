/**
 * Created by iakoupov on 2016-11-24.
 */

angular.module('controllers').controller('PetForm', PetForm);

PetForm.$inject = ['petService','$location']

function PetForm(petService, $location) {
    var vm = this;

    vm.pet = {};

    vm.createPet = function (pet, photos) {
        // send photos as well
        petService.addPet(pet, photos).success(function (response) {
            console.log('saved pet', response);

            $location.path('/pets');
        })
    }

    vm.showPhotos = function () {
        return vm.photos && vm.photos.length;
    }

    vm.clearPhotoSelections = function () {
        delete vm.photos;
        document.getElementById('photos').value = null;
    }




    vm.cancel = function () {
        vm.pet = {};
        $location.path('/pets');
    }



}
