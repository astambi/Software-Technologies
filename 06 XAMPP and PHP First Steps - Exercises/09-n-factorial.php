<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>N factorial</title>
</head>
<body>
<form>
    Number: <input type="text" name="num">
    <input type="submit">
</form>
<?php
if (isset($_GET['num'])) {
    $num = intval($_GET['num']);
    $nFactorial = 1;
    for ($i = 2; $i <= $num; $i++)
        $nFactorial *= $i;
    echo "$nFactorial";
}
?>
</body>
</html>