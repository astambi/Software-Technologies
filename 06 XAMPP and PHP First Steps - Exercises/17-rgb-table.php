<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>RGB Table</title>
    <style>
        table * {
            border: 1px solid black;
            width: 50px;
            height: 50px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>
            Red
        </td>
        <td>
            Green
        </td>
        <td>
            Blue
        </td>
    </tr>
    <?php
    for ($i = 1; $i <= 5; $i++) {
        $colorIndex = $i * 51;
        $red = "rgb($colorIndex, 0, 0)";
        $green = "rgb(0, $colorIndex, 0)";
        $blue = "rgb(0, 0, $colorIndex";
        echo "<tr>";
        echo "<td style='background-color: $red'></td>";
        echo "<td style='background-color: $green'></td>";
        echo "<td style='background-color: $blue'></td>";
        echo "</tr>";
    }
    ?>
</table>
</body>
</html>