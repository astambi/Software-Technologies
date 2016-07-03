<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fifty Shades of Grey</title>
    <style>
        div {
            display: inline-block;
            margin: 5px;
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
<?php
for ($row = 0; $row < 5; $row++) {
    for ($col = 0; $col < 10; $col++) {
        $colorIndex = $row * 51 + $col * 5;
        $color = "rgb($colorIndex, $colorIndex, $colorIndex)";
        echo '<div style="background-color: ' . $color . ';"></div>';
//        modified to meet testing requirements in Judge
    }
    echo "<br>";
}
?>
</body>
</html>