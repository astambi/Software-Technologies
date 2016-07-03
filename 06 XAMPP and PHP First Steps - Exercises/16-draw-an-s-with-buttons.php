<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Draw an S with Buttons</title>
    <style>
        .buttonBlue {
            background-color: blue;
        }
    </style>
</head>
<body>
<?php
for ($i = 0; $i < 5; $i++)
    echo "<button class='buttonBlue'>1</button>";
echo "<br>";
for ($i = 0; $i < 3; $i++) {
    echo "<button class='buttonBlue'>1</button>";
    for ($j = 0; $j < 4; $j++)
        echo "<button>0</button>";
    echo "<br>";
}
for ($i = 0; $i < 5; $i++)
    echo "<button class='buttonBlue'>1</button>";
echo "<br>";
for ($i = 0; $i < 3; $i++) {
    for ($j = 0; $j < 4; $j++)
        echo "<button>0</button>";
    echo "<button class='buttonBlue'>1</button>";
    echo "<br>";
}
for ($i = 0; $i < 5; $i++)
    echo "<button class='buttonBlue'>1</button>";
?>
</body>
</html>