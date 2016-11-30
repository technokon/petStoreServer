/**
 * Created by iakoupov on 2016-11-29.
 */


module.exports = function(config) {
    config.set({

        basePath: '.',


        files: [
            'src/main/resources/public/js/lib/angular.js',
            'src/main/resources/public/js/lib/jquery.js',
            'src/main/resources/public/js/lib/angular-route.js',
            'src/main/resources/public/js/lib/angular-resource.js',
            'src/main/resources/public/js/lib/angular-mocks.js',
            'src/main/resources/public/js/lib/angular-animate.js',
            'src/main/resources/public/js/lib/ngDialog.js',
            'src/main/resources/public/js/app.js',
            'src/main/resources/public/js/animations/animations.js',
            'src/main/resources/public/js/services/services.js',
            'src/main/resources/public/js/controllers/controllers.js',
            'src/main/resources/public/js/directives/directives.js',
            'src/main/resources/public/js/services/loginDialogService.js',
            'src/main/resources/public/js/services/confirm.js',
            'src/main/resources/public/js/services/petService.js',
            'src/main/resources/public/js/services/session.js',
            'src/main/resources/public/js/controllers/main.js',
            'src/main/resources/public/js/controllers/login.js',
            'src/main/resources/public/js/controllers/confirm.js',
            'src/main/resources/public/js/controllers/petList.js',
            'src/main/resources/public/js/controllers/petDetail.js',
            'src/main/resources/public/js/controllers/petForm.js',
            'src/main/resources/public/js/directives/fileInput.js',
            'tests/**/*.js'
        ],

        autoWatch: true,

        frameworks: ['jasmine'],

        browsers: ['Chrome']

    });
};