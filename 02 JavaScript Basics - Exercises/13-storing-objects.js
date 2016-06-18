function storingObjects(arr) {
    for (let i = 0; i < arr.length; i++)
    {
        let data = arr[i].split(" -> ");
        let object = {name: data[0], age: data[1], grade: data[2]};
        console.log(`Name: ${object.name}`);
        console.log(`Age: ${object.age}`);
        console.log(`Grade: ${object.grade}`);
    }
}
// storingObjects([
//     'Pesho -> 13 -> 6.00',
//     'Ivan -> 12 -> 5.57',
//     'Toni -> 13 -> 4.90']);