function addItem() {
    $('#items')
        .append($('<li>')
            .text($('#newItem').val()));
    // optional
    $('#newItem').val('');
}
function addByKeypress(e) {
    if (e.keyCode == 13)
        $('#newItem + button').click();
}
$(function () {
    $('#newItem').keypress(addByKeypress)
});

// function addItem() {
//     let newListItem = document.createElement('li');
//     let newTextNode = document.createTextNode(document.getElementById('newItem').value);
//     newListItem.appendChild(newTextNode);
//     document.getElementById('items').appendChild(newListItem);
// }