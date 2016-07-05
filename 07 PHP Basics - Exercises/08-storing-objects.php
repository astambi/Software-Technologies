<html>
<head>
</head>
<body>
<form>
    Input:
    <br>
    <textarea name="input"></textarea>
    <br>
    Delimiter:
    <br>
    <input type="text" name="delimiter">
    <br>
    <input type="submit">
</form>
</body>
</html>

<?php
class Student
{
    protected $name;
    protected $age;
    protected $grade;
    function __construct($name, $age, $grade)
    {
        $this->name = $name;
        $this->age = $age;
        $this->grade = $grade;
    }
    function getName()
    { return $this->name; }
    function getAge()
    { return $this->age; }
    function getGrade()
    { return $this->grade; }
}
if (isset($_GET['delimiter']) && isset($_GET['input'])) {
    $delimiter = $_GET['delimiter'];
    $input = $_GET['input'];
    $kvpLines = array_map('trim', explode("\n", $input));
    $students = [];
    foreach ($kvpLines as $kvpLine) {
        $tokens = explode($delimiter, $kvpLine);
        $name = htmlspecialchars($tokens[0]);
        $age = intval($tokens[1]);
        $grade = floatval($tokens[2]);
        $student = new Student($name, $age, $grade);
        $students[] = $student;
    }
    if (count($students) > 0)
        foreach ($students as $student) {
            echo "<ul>";
            echo "<li>Name: " . $student->getName() . "</li>";
            echo "<li>Age: " . $student->getAge() . "</li>";
            echo "<li>Grade: " . $student->getGrade() . "</li>";
            echo "</ul>";
        }
    else echo "None";
}
