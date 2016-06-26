function loadPosts() {
    let USERNAME = "guest", PASSWORD = "guest";
    let authBase64 = btoa(USERNAME + ":" + PASSWORD);
    $.ajax({
        method: "GET",
        url: "https://baas.kinvey.com/appdata/kid_BJxzmL3B/posts",
        headers: { "Authorization": "Basic " + authBase64 },
        success: showPosts,
        error: showError
    })
}

function showPosts(posts, status) {
    let listPosts = $('<ul>');
    for (let post of posts) {
        let currentPost = $('<li>')
            .text(post.title + " -> " + post.body);
        listPosts.append(currentPost);
    }
    $('body').append(listPosts);
}

function showError(data, status) {
    let errorMsg = $('<div>')
        .text("Error: " + JSON.stringify(data));
    $('body').append(errorMsg);
}