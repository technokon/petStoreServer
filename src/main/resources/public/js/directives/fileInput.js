/**
 * Created by iakoupov on 2016-11-25.
 */


angular.module('directives').directive('fileInput', FileInput);

FileInput.$inject = ['$parse'];

function FileInput($parse) {
    
    function Link(scope, elm, attrs) {
        elm.bind('change', function () {

            var files = elm[0].files;
            // add URL to each of the files map or foreach
            angular.forEach(files, function (value, key) {
                value.url = getUrl(value);
            })

            $parse(attrs.fileInput)
                .assign(scope, files);
            
            console.log(attrs.fileInput);
            console.log(scope);
            
            scope.$apply();
        });

       
    }

    function getUrl(file) {
        return URL.createObjectURL(file);
    }
    
    return {
        restrict: 'A',
        link: Link
    }
}