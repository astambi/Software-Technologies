function largest3Numbers(arr) {
    let nums = arr.map(Number);
    let numsSorted = nums.sort((a, b) => b - a);
    for (let i = 0; i < Math.min(3, arr.length); i++)
        console.log(numsSorted[i]);
}
// largest3Numbers(['10', '30', '15', '20', '50', '5'])