function callKinvey() {
    $.ajax({
        method: "GET",
        url: "https://baas.kinvey.com/appdata/kid_BJxzmL3B/posts",
        headers: { "Authorization": "Basic " + btoa("guest:guest") },
        success: showPosts,
        error: showError
    })
}
function createPost() {
    $.ajax({
        method: "POST",
        url: "https://baas.kinvey.com/appdata/kid_BJxzmL3B/posts",
        headers: { "Authorization": "Basic " + btoa("guest:guest") },
        data: {
            title: $('#newPostTitle').val(),
            body: $('#newPostBody').val()
        },
        success: callKinvey,
        error: showError
    })
}
function showPosts(posts) {
    for (let p of posts) {
        $('body').append($('<div class="title">').text(p.title));
        $('body').append($('<div class="content">').text(p.body));
    }
}
function showError(data) {
    $('body').append($('<div>').text("Error: " + JSON.stringify(data)));
}