/**
 * Created by iakoupov on 2016-11-29.
 */


describe('pet service test', function () {

    beforeEach(module('petStoreApp'));

    var petService;
    var confirmDialog;
    var httpBackend;
    var document;


    var timeout;

    beforeEach(inject(function($injector) {
        // Set up the mock http service responses
        httpBackend = $injector.get('$httpBackend');
        
        console.log(httpBackend);

        // Get hold of a scope (i.e. the root scope)
        $rootScope = $injector.get('$rootScope');
        // The $controller service is used to create instances of controllers
        var $controller = $injector.get('$controller');

        petService = $injector.get('petService')
        
        console.log('petservice?', petService);

        confirmDialog = $injector.get('confirmDialog');
        
        console.log('confirmDialog', confirmDialog);

        timeout = $injector.get('$timeout')
        
        document = $injector.get('$document');

        
    }));

    describe('pet services', function () {
        
        it('service should return data back', function () {
            
            httpBackend.whenGET('/pet-store/pets/').respond(
                [{
                    name: 'Kitten',
                    description: 'Siamese kitten'
                }, {
                    name: 'bulldog',
                    description: 'Very friendly pet'
                }]
            );

            httpBackend.whenGET('/pet-store/pets/kitten').respond(
                 {
                    name: 'Kitten',
                    description: 'Siamese kitten'
                }
            )

            httpBackend.whenPOST('/pet-store/pet').respond(200,200);

            httpBackend.whenPUT('/pet-store/pet').respond(200,200);

            httpBackend.whenDELETE('/pet-store/pet/123').respond(200,200);

            console.log('testing... pet services');

            petService.getPets().success(function (data) {
                
                expect(data.length).toBeGreaterThan(0)
                console.log('Pets:', data);
            });

            httpBackend.flush();

            petService.getPets('kitten').success(function (data) {

                expect(data.name).toEqual('Kitten')
                console.log('Pets:', data);
            });

            httpBackend.flush();

            petService.updatePet({name: 'newfoudland', description: 'Very big dog'}).success(function (data) {
                console.log('data: ', data);

                expect(data).toEqual(200);
            }).catch(function (error) {
                console.log('erro:',error)
            })

            httpBackend.flush();

            petService.removePet(123).success(function (data) {
                console.log('data: ', data);

                expect(data).toEqual(200);
            }).catch(function (error) {
                console.log('erro:',error)
            })

            httpBackend.flush();
            
        })
    }); // end pet services
    
    

})