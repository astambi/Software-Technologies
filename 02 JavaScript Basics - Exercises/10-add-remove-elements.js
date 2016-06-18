function addRemoveElements(arr) {
    let array = [];
    for(let i = 0; i < arr.length; i++)
    {
        let data = arr[i].split(' ');
        let command = data[0];
        let element = Number(data[1]);
        if(command == "add")
            array.push(element);
        else if(command == "remove" && element in array) // index
            array.splice(element, 1);
    }
    console.log(array.join("\n"));
}
// addRemoveElements([
//     'add 3',
//     'add 5',
//     'remove 2',
//     'remove 0',
//     'add 7']);