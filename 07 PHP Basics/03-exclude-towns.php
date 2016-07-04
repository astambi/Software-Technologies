<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exclude Towns</title>
</head>
<body>
<?php
function excludeFromArray(array $arr, array $excludeArr) : array {
    $result = [];
    foreach ($arr as $item)
        if (!in_array($item, $excludeArr))
            $result[] = $item;
    return $result;
}
function printAsList(array $arr) {
    echo "<ul>\n";
    foreach ($arr as $item)
        echo "<li>$item</li>\n";
    echo "</ul>\n";
}
if (isset($_GET['towns']) && isset($_GET['townsToExclude'])) {
    $towns = array_map('trim', explode("\n", $_GET['towns']));
    $townsToExclude = array_map('trim', explode("\n", $_GET['townsToExclude']));
    $remainingTowns = excludeFromArray($towns, $townsToExclude);
    printAsList($remainingTowns);
}
else { ?>
    <form>
        <div style="display: inline-block">
            <div>Towns</div>
            <textarea name="towns" rows="10"></textarea>
        </div>
        <div style="display: inline-block">
            <div>Towns to exclude</div>
            <textarea name="townsToExclude" rows="10"></textarea>
        </div>
        <div>
            <input type="submit" value="Exclude">
        </div>
    </form>
<?php } ?>
</body>
</html>