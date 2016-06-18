function setValuesToIndices(arr) {
    let len = Number(arr[0]);
    let array = [];
    for(let i = 0; i < len; i++)
       array.push(0);
    for(let i = 1; i < arr.length; i++)
    {
        let data = arr[i].split(' ');
        let index = Number(data[0]);
        if(index in array)
            array[index] = Number(data[2]);
    }
    console.log(array.join("\n"));
}
// setValuesToIndices([
//     '3',
//     '0 - 5',
//     '1 – 6',
//     '2 – 7']);
// setValuesToIndices([
//     '5',
//     '0 – 3',
//     '3 - -1',
//     '4 – 2']);