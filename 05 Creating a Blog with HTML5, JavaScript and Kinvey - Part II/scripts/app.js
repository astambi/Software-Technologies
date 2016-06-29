(function () {

    // Create your own kinvey application
    let baseUrl = "https://baas.kinvey.com";

    // Place your appKey from Kinvey here...
    let appKey = "kid_H17w3-g8";

    // Place your appSecret from Kinvey here...
    let appSecret = "82b60f29aac84680a913fed115646044";

    // Create a guest user using PostMan/RESTClient/Fiddler and place his authtoken here...
    // authtoken from RESTED upon user creation
    var _guestCredentials = "26fec3d7-e90b-4c5e-a8c2-6abc5a9f7fd7.IIKJy0qnnPzZQnoHC4CEjqoh0v2c2oR5WYgBJDFmJL4=";

    //Create AuthorizationService and Requester

    let authService = new AuthorizationService(
        baseUrl,
        appKey,
        appSecret,
        _guestCredentials);
    
    authService.initAuthorizationType("Kinvey");

    let requester = new Requester(authService);    

    let selector = ".wrapper";
    let mainContentSelector = ".main-content";

    // Create HomeView, HomeController, UserView, UserController, PostView and PostController

    // functionality added
    let homeView = new HomeView(selector, mainContentSelector);
    let homeController = new HomeController(homeView, requester, baseUrl, appKey);

    let userView = new UserView(selector, mainContentSelector);
    let userController = new UserController(userView, requester, baseUrl, appKey);

    let postView = new PostView(selector, mainContentSelector);
    let postController = new PostController(postView, requester, baseUrl, appKey);
    // functionality added
    
    
    initEventServices();

    onRoute("#/", function () {
        // Check if user is logged in and if its not show the guest page, otherwise show the user page...
        if (!authService.isLoggedIn()) {
            homeController.showGuestPage();
        }
        else {
            homeController.showUserPage();
        }
    });

    onRoute("#/post-:id", function () {
        // Create a redirect to one of the recent posts...
        let top = $("#post-" + this.param['id']).position().top();
        $(window).scrollTop(top);
    });

    onRoute("#/login", function () {
        // Show the login page...
        userController.showLoginPage(authService.isLoggedIn())
    });

    onRoute("#/register", function () {
        // Show the register page...
        userController.showRegisterPage(authService.isLoggedIn());
    });

    onRoute("#/logout", function () {
        // Logout the current user...
        userController.logout();
    });

    onRoute('#/posts/create', function () {
        // Show the new post page...
        let data = {
            fullname: sessionStorage['fullname']
        };
        postController.showCreatePostPage(data, authService.isLoggedIn());
    });

    bindEventHandler('login', function (ev, data) {
        // Login the user...
        userController.login(data);
    });

    bindEventHandler('register', function (ev, data) {
        // Register a new user...
        userController.register(data);
    });

    bindEventHandler('createPost', function (ev, data) {
        // Create a new post...
        postController.createPost(data);
    });

    run('#/');
})();
