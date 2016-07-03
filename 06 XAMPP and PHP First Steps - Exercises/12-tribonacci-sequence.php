<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form>
    Number: <input type="text" name="num">
    <input type="submit">
</form>
<?php
if (isset($_GET['num'])) {
    $num = intval($_GET['num']);
    $tribonacci = [1, 1, 2];
    for ($i = 3; $i < $num; $i++)
        $tribonacci[$i] = $tribonacci[$i - 1] + $tribonacci[$i - 2] + $tribonacci[$i - 3];
    for ($i = 0; $i < $num; $i++)
        echo "$tribonacci[$i] ";
}
?>
</body>
</html>