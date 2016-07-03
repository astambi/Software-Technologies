<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Multiply / Divide Numbers</title>
</head>
<body>
<form>
    Number 1: <input type="text" name="num1">
    Number 2: <input type="text" name="num2">
    <input type="submit" value="Multiply / Divide numbers">
</form>
<?php
if (isset($_GET['num1']) && isset($_GET['num2'])) {
    $num1 = intval($_GET['num1']);
    $num2 = intval($_GET['num2']);
    if ($num2 >= $num1)
        echo $num1 * $num2;
    else if($num2 != 0)
        echo $num1 / $num2;
}
?>
</body>
</html>