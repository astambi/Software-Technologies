function multipleValuesForKey(arr) {
        let kvPairs = [];
        for (let i = 0; i < arr.length - 1; i++)
        {
            let data = arr[i].split(' ');
            let key = data[0];
            let value = data[1];
            if(!(key in kvPairs))
                kvPairs[key] = [];
            kvPairs[key].push(value);
        }
        let key = arr[arr.length - 1];
        if(key in kvPairs)
            console.log(kvPairs[key].join("\n"));
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