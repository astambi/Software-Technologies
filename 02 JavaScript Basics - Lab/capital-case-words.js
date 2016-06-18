function extractUppercaseWords(arr) {
    let text = arr.join(",");
    let words = text.split(/\W+/);
    let uppercaseWords = words
        .filter(w => w.length > 0)
        .filter(x => x.toUpperCase() == x);
    console.log(uppercaseWords.join(", "));
}
// extractUppercaseWords([
//     'We start by HTML, CSS, JavaScript, JSON and REST.',
//     'Later we touch some PHP, MySQL and SQL.',
//     'Later we play with C#, EF, SQL Server and ASP.NET MVC.',
//     'Finally, we touch some Java, Hibernate and Spring.MVC.']);