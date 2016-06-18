function productWithoutMultiplication(arr) {
    let numbers = arr.map(Number);
    let negativeNums = numbers.filter(x => x < 0);
    if (negativeNums.length % 2 == 0)
        console.log("Positive");
    else console.log("Negative");
}
// productWithoutMultiplication([2,3,-1]);
// productWithoutMultiplication([-3,-4,5]);