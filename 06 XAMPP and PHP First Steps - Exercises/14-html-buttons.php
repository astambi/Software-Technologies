<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HTML Buttons</title>
</head>
<body>
<form>
    <form>
        Number: <input type="text" name="num">
        <input type="submit">
    </form>
</form>
<?php
if (isset($_GET['num'])) {
    $num = intval($_GET['num']);
    for ($i = 1; $i <= $num; $i++)
        echo "<button>$i</button>";
}
?>
</body>
</html>