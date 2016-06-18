function turnObjectIntoJSONString(arr) {
    let object = {};
    for(let i = 0; i < arr.length; i++)
    {
        let data = arr[i].split(" -> ");
        let key = data[0];
        let value = data[1];
        if(!isNaN(value))
            value = Number(value);
        object[key] = value;
    }
    console.log(JSON.stringify(object));
}
// turnObjectIntoJSONString([
//     'name -> Angel',
//     'surname -> Georgiev',
//     'age -> 20',
//     'grade -> 6.00',
//     'date -> 23/05/1995',
//     'town -> Sofia']);