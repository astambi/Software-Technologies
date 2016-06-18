function printLines(arr) {
    for(let line of arr)
        if(line == "Stop") return;
        else console.log(line);
}
// printLines([
//     'Line 1',
//     'Line 2',
//     'Line 3',
//     'Stop']);