<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Multiply a Number by 2</title>
</head>
<body>
<form>
    N: <input type="text" name="num">
    <input type="submit" value="Multiply by 2">
</form>
<?php
if (isset($_GET['num'])) {
    $n = intval($_GET['num']);
    echo $n * 2;
}
?>
</body>
</html>