function objectsJSON(arr) {
    let objects = arr.map(JSON.parse);
    for(let object of objects)
    {
        console.log(`Name: ${object.name}`);
        console.log(`Age: ${object.age}`);
        console.log(`Date: ${object.date}`);
    }
}
// objectsJSON([
//     '{"name":"Gosho","age":10,"date":"19/06/2005"}',
//     '{"name":"Tosho","age":11,"date":"04/04/2005"}']);