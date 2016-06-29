const kinveyBaseUrl = "https://baas.kinvey.com/";
const kinveyAppKey = "kid_rJ1skPRB";
const kinveyAppSecret = "18eeb94276d74b95bb51f0896ceef932";

function showView(viewName) {
    // Hide all views and show the selected view
    $('main > section').hide();
    $('#' + viewName).show();
}
function showHideMenuLinks() {
    $('#linkHome').show();
    if (sessionStorage.getItem('authToken') == null) {
        // User not logged in
        $('#linkLogin').show();
        $('#linkRegister').show();
        $('#linkListBooks').hide();
        $('#linkCreateBook').hide();
        $('#linkLogout').hide();
    }
    else {
        // User logged in
        $('#linkLogin').hide();
        $('#linkRegister').hide();
        $('#linkListBooks').show();
        $('#linkCreateBook').show();
        $('#linkLogout').show();
    }
}

function showHomeView() {
    showView('viewHome');
}

function showLoginView() {
    showView('viewLogin');
}
function login() {
    const kinveyLoginUrl = kinveyBaseUrl + "user/" + kinveyAppKey + "/login";
    const kinveyAuthHeaders = {
        "Authorization": "Basic " + btoa(kinveyAppKey + ":" + kinveyAppSecret)
    };
    let userData = {
        username: $('#loginUser').val(),
        password: $('#loginPass').val()
    };
    $.ajax({
        method: "POST",
        url: kinveyLoginUrl,
        headers: kinveyAuthHeaders,
        data: userData,
        success: loginSuccess,
        error: handleAjaxError
    });
    function loginSuccess(response) {
        let userAuth = response._kmd.authtoken;
        sessionStorage.setItem('authToken', userAuth);
        showHideMenuLinks();
        listBooks();
        showInfo("Login successful")
    }
}

function showRegisterView() {
    showView('viewRegister');
}
function register() {
    const kinveyRegisterUrl = kinveyBaseUrl + "user/" + kinveyAppKey + "/";
    const kinveyAuthHeaders = {
        "Authorization": "Basic " + btoa(kinveyAppKey + ":" + kinveyAppSecret)
    };
    let userData = {
        username: $('#registerUser').val(),
        password: $('#registerPass').val()
    };
    $.ajax({
        method: "POST",
        url: kinveyRegisterUrl,
        headers: kinveyAuthHeaders,
        data: userData,
        success: registerSuccess,
        error: handleAjaxError
    });
    function registerSuccess(response) {
        let userAuth = response._kmd.authtoken;
        sessionStorage.setItem('authToken', userAuth);
        showHideMenuLinks();
        listBooks();
        showInfo("User registration successful")
    }
}

function listBooks() {
    $('#books').empty();
    showView('viewBooks');

    const kinveyBooksUrl = kinveyBaseUrl + "appdata/" + kinveyAppKey + "/books";
    const kinveyAuthHeaders = {
        "Authorization": "Kinvey " + sessionStorage.getItem('authToken')
    };
    $.ajax({
        method: "GET",
        url: kinveyBooksUrl,
        headers: kinveyAuthHeaders,
        success: loadBooksSuccess,
        error: handleAjaxError
    });
    function loadBooksSuccess(books) {
        showInfo("Books loaded");
        if(books.length == 0) {
            $('#books').text("No books in the library")
        }
        else {
            let booksTable = $('<table>')
                .append($('<tr>').append(
                    '<th>Title</th>',
                    '<th>Author</th>',
                    '<th>Description</th>'));
            for (let book of books) {
                // add book details
                booksTable.append(
                    $('<tr>').append(
                        $('<td>').text(book.title),
                        $('<td>').text(book.author),
                        $('<td>').text(book.description)));

                // add book comments
                let bookComments = [];
                if (typeof(book.comments) != 'undefined' && book.comments.length > 0) {
                    for(let comment of book.comments) {
                        bookComments.push(comment);
                    }
                }
                let comments = $('<div class="divComments">');
                for (let bookComment of bookComments) {
                    let commentAuthor = $('<div class="divCommentAuthor">')
                        .append(' ~~ ')
                        .append(bookComment.author);
                    comments
                        .append(bookComment.text)
                        .append(commentAuthor);
                }

                // add Create Comment link
                comments.append($('<div style="display: inline">')
                        .append($('<a href="#" id="linkCreateComment" onclick="showFormCreateComment()" >Add comment</a>')));

                // add [hidden] Create Comment Form
                comments.append(
                    $('<div>')
                        .append($('<form id="formCreateComment" style="display: none">' +
                            'Comment: <input type="text" id="commentText" required="true">' + ' ' +
                            'Author: <input type="text" id="commentAuthor" required="true">' + ' ' +
                            '<input type="submit" value="Add comment">' + ' ' +
                            '<input type="button" value="Cancel" onclick="hideFormCreateComment()">' +
                            '</form>'))
                );

                // append comments to table
                booksTable.append(
                    $('<tr>').append(
                        $('<td colspan="3"></td>')
                            .append(comments)));
            }

            // append table to ListBooks View
            $('#books').append(booksTable);
        }
    }
}

function showCreateBookView() {
    showView('viewCreateBook');
}
function createBook() {
    const kinveyBooksUrl = kinveyBaseUrl + "appdata/" + kinveyAppKey + "/books";
    const kinveyAuthHeaders = {
        "Authorization": "Kinvey " + sessionStorage.getItem('authToken')
    };
    let bookData = {
        title: $('#bookTitle').val(),
        author: $('#bookAuthor').val(),
        description: $('#bookDescription').val()
    };
    $.ajax({
        method: "POST",
        url: kinveyBooksUrl,
        headers: kinveyAuthHeaders,
        data: bookData,
        success: createBookSuccess,
        error: handleAjaxError
    });
    function createBookSuccess(response) {
        listBooks();
        showInfo("Book created");
        $('#formCreateBook')[0].reset();
    }
}

function showFormCreateComment() {
    // hiding and revealing forms and links does not work correctly !
    $('#formCreateComment').show();
    $('#linkCreateComment').hide();
}
function hideFormCreateComment() {
    // hiding and revealing forms and links does not work correctly !
    $('#formCreateComment').hide();
    $('#linkCreateComment').show();
}

function addBookComment(bookData, commentText, commentAuthor) {
    // adding comments not working!
    const kinveyBooksUrl = kinveyBaseUrl + "appdata/" + kinveyAppKey + "/books" + "/" + bookData._id;
    const kinveyAuthHeaders = {
        "Authorization": "Kinvey " + sessionStorage.getItem('authToken'),
        'Content-type': 'application/json'
    };
    if (!bookData.comments) {
        bookData.comments = [];
    }
    bookData.comments.push({
        text: commentText,
        author: commentAuthor
    });
    $.ajax({
        method: "PUT",
        url: kinveyBooksUrl,
        headers: kinveyAuthHeaders,
        data: JSON.stringify(bookData),
        success: addBookCommentSuccess,
        error: handleAjaxError
    });
    function addBookCommentSuccess() {
        listBooks();
        showInfo("Book comment added");
    }
}

function logout() {
    sessionStorage.clear();
    showHideMenuLinks();
    showView('viewHome');
}

function showInfo(message) {
    $('#infoBox').text(message).show();
    setTimeout(function () {
        $('#infoBox').fadeOut()
    }, 3000);
}
function showError(errorMsg) {
    $('#errorBox').text("Error: " + errorMsg).show();
}
function handleAjaxError(response) {
    let errorMsg = JSON.stringify(response);
    if(response.readyState === 0)
        errorMsg = "Cannot connect due to network error";
    if (response.responseJSON && response.responseJSON.description)
        errorMsg = response.responseJSON.description;
    showError(errorMsg);
}

$(function () {
    showHideMenuLinks();
    showView('viewHome');

    $('#linkHome').click(showHomeView);
    $('#linkLogin').click(showLoginView);
    $('#linkRegister').click(showRegisterView);
    $('#linkListBooks').click(listBooks);
    $('#linkCreateBook').click(showCreateBookView);
    $('#linkLogout').click(logout);

    $('#formLogin').submit(function (e) {
        e.preventDefault(); login();
    });
    $('#formRegister').submit(function (e) {
        e.preventDefault(); register();
    });
    $('#formCreateBook').submit(function (e) {
        e.preventDefault(); createBook();
    });
    $('#formCreateComment')[i].submit(function (e, bookData, commentText, commentAuthor) {
        e.preventDefault(); addBookComment(bookData, commentText, commentAuthor);
    });


    $(document).on({
        ajaxStart: function () {
            $('#loadingBox').show()
        },
        ajaxStop: function () {
            $('#loadingBox').hide()
        }
    })
});