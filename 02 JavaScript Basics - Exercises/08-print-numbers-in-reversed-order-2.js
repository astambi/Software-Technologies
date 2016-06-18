function printInReversedOrder(arr) {
    arr.reverse();
    for (let element of arr)
        console.log(element);
    // for (let index in arr)
    //     console.log(arr[index]);
}
// printInReversedOrder([10,15,20]);
// printInReversedOrder([5,5.5,24,-3]);