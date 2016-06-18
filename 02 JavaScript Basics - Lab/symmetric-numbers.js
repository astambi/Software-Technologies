function symmetricNumbers(arr) {
    let n = Number(arr[0]), result = '';
    let resultNums = [];
    for (let i = 1; i <= n; i++)
        if (isSymmetric("" + i))
            resultNums.push(i);
    console.log(resultNums.join(" "));
    function isSymmetric(str) {
        for (let i = 0; i < str.length / 2; i++)
            if (str[i] != str[str.length - i - 1])
                return false;
        return true;
    }
}
// symmetricNumbers([750]);