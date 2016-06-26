function addItem() {
    let newListItem = document.createElement('li');
    let newTextNode = document.createTextNode(document.getElementById('newItem').value);
    newListItem.appendChild(newTextNode);
    document.getElementById('items').appendChild(newListItem);
}