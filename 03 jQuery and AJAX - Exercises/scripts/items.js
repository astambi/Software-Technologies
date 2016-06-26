function addItemToList(text) {
    let li = $('<li>')
        .append($("<span>").text(text))
        .append(" ")
        .append($('<a href="#" onclick="deleteItem(this)">[Delete]</a>'));
    $('#items').append(li);
}
function addInitialItems() {
    addItemToList("First");
    addItemToList("Second");
}
function addItem() {
    let text = $('#newItemText').val();
    addItemToList(text);
    $('#newItemText').val('');
}
function deleteItem(link) {
    $(link).parent().remove();
}
function addByKeypress(e) {
    if (e.keyCode == 13)
        $('#newItemText + input[type="button"]').click();
}