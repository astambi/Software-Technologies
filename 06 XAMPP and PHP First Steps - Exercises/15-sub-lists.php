<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sub-Lists</title>
</head>
<body>
<form>
    <form>
        Number1: <input type="text" name="num1">
        Number2: <input type="text" name="num2">
        <input type="submit">
    </form>
</form>
<?php
if (isset($_GET['num1']) && isset($_GET['num2'])) {
    $num1 = intval($_GET['num1']);
    $num2 = intval($_GET['num2']);
    echo "<ul>";
    for ($list = 1; $list <= $num1; $list++) {
        echo "<li>List $list<ul>";
        for ($element = 1; $element <= $num2; $element++)
            echo "<li>Element $list" . "." . "$element</li>";
        echo "</ul></li>";
    }
    echo "</ul>";
}
?>
</body>
</html>