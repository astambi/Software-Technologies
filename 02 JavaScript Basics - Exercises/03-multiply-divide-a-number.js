function multiplyDivideNumbers(arr) {
    let numbers = arr.map(Number);
    if(numbers[0] <= numbers[1])    
        console.log(numbers[0] * numbers[1]);
    else console.log(numbers[0] / numbers[1]);
}
// multiplyDivideNumbers([2,3]);
// multiplyDivideNumbers([13,13]);
// multiplyDivideNumbers([144,12]);