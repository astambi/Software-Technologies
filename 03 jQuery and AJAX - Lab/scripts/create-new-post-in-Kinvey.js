function createPost() {
    let USERNAME = "guest", PASSWORD = "guest";
    let authBase64 = btoa(USERNAME + ":" + PASSWORD);
    let postData = {
        title: $('#newPostTitle').val(),
        body: $('#newPostBody').val()
    };
    $.ajax({
        method: "POST",
        url: "https://baas.kinvey.com/appdata/kid_BJxzmL3B/posts",
        headers: { "Authorization": "Basic " + authBase64},
        data: postData,
        success: showSuccess,
        error: showError
    });
}

function showSuccess(data, status) {
    let successMsg = $('<div>')
        .text("Created: " + JSON.stringify(data));
    $('body').append(successMsg);
    // optional
    $('#newPostTitle').val('');
    $('#newPostBody').val('');
}

function showError(data, status) {
    let errorMsg = $('<div>')
        .text("Error: " + JSON.stringify(data));
    $('body').append(errorMsg);
}