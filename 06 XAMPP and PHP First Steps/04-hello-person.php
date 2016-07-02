<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello person</title>
</head>
<body>
<?php
    if (isset($_GET['person'])) {
        $person = htmlspecialchars($_GET['person']);
        echo "Hello, $person";
    }
    else { ?>
        <form>
            Name: <input type="text" name="person"><br>
            <input type="submit">
        </form>
    <?php } ?>
</body>
</html>