function keyValuePairs(arr) {
    let kvPairs = [];
    for (let i = 0; i < arr.length - 1; i++)
    {
        let data = arr[i].split(' ');
        let key = data[0];
        let value = data[1];
        kvPairs[key] = value;
    }
    let key = arr[arr.length - 1];
    console.log(kvPairs[key] || "None");
}
// keyValuePairs([
//     'key value',
//     'key eulav',
//     'test tset',
//     'key']);