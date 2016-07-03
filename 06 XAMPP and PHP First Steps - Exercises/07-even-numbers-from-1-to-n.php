<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Even Numbers from 1 to N</title>
</head>
<body>
<form>
    Number: <input type="text" name="num">
    <input type="submit" value="Get numbers">
</form>
<?php
if (isset($_GET['num'])) {
    $num = intval($_GET['num']);
    for ($i = 2; $i <= $num; $i+=2)
        echo "$i ";
}
?>
</body>
</html>