<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Numbers from N to 1</title>
</head>
<body>
<form>
    Number: <input type="text" name="num">
    <input type="submit" value="Get numbers">
</form>
<?php
if (isset($_GET['num'])) {
    $num = intval($_GET['num']);
    for ($i = $num; $i >= 1; $i--)
        echo "$i ";
}
?>
</body>
</html>