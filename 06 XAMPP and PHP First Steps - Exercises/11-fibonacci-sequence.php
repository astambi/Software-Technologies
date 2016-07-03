<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fibonacci Sequence</title>
</head>
<body>
<form>
    Number: <input type="text" name="num">
    <input type="submit">
</form>
<?php
    if (isset($_GET['num'])) {
        $num = intval($_GET['num']);
        $fibonacci = [1, 1];
        for ($i = 2; $i < $num; $i++) 
            $fibonacci[$i] = $fibonacci[$i - 1] + $fibonacci[$i - 2];
        for ($i = 0; $i < $num; $i++)
            echo "$fibonacci[$i] ";
    }
?>
</body>
</html>