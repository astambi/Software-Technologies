<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Draw an S with Buttons</title>
</head>
<body>
<?php
//inline styling to meet testing requirements in Judge
for ($i = 0; $i < 5; $i++)
    echo "<button style='background-color: blue'>1</button>";
echo "<br>";
for ($i = 0; $i < 3; $i++) {
    echo "<button style='background-color: blue'>1</button>";
    for ($j = 0; $j < 4; $j++)
        echo "<button>0</button>";
    echo "<br>";
}
for ($i = 0; $i < 5; $i++)
    echo "<button style='background-color: blue'>1</button>";
echo "<br>";
for ($i = 0; $i < 3; $i++) {
    for ($j = 0; $j < 4; $j++)
        echo "<button>0</button>";
    echo "<button style='background-color: blue'>1</button>";
    echo "<br>";
}
for ($i = 0; $i < 5; $i++)
    echo "<button style='background-color: blue'>1</button>";
?>
</body>
</html>