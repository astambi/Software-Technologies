<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Not Divisor Numbers</title>
</head>
<body>
<form>
    Number : <input type="text" name="num">
    <input type="submit">
</form>
<?php
if (isset($_GET['num'])) {
    $num = intval($_GET['num']); // positive number
    for ($divisor = $num - 1; $divisor > 1; $divisor--) {
        if ($num % $divisor != 0)
            echo "$divisor ";
    }
}
?>
</body>
</html>