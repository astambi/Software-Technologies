function multipleValuesForKey(arr) {
    let key = arr[arr.length - 1];
    let keyValues = [];
    for (let i = 0; i < arr.length - 1; i++)
    {
        let data = arr[i].split(' ');
        if(key == data[0])
            keyValues.push(data[1]);
    }
    if(keyValues.length > 0)
        console.log(keyValues.join("\n"));
    else console.log("None");
}
// multipleValuesForKey([
//     'key value',
//     'key eulav',
//     'test tset',
//     'key']);
// multipleValuesForKey([
//     '3 bla',
//     '3 alb',
//     '2']);