<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sums by Town</title>
</head>
<body>
<?php
function calcSumsByTown(array $incomeTowns) : array {
    $sums = []; // town, income
    foreach ($incomeTowns as $incomeTown) {
        $tokens = explode(":", $incomeTown);
        $town = $tokens[0];
        $income = $tokens[1];
        if (!isset($sums[$town]))
            $sums[$town] = 0;
        $sums[$town] += $income;
    }
    ksort($sums);
    return $sums;
}
if (isset($_GET['towns-incomes'])) {
    $incomeTowns = array_map("trim", explode("\n", $_GET['towns-incomes']));
    $sumsByTowns = calcSumsByTown($incomeTowns);
    foreach ($sumsByTowns as $town => $sum)
        echo "$town -> $sum <br>\n";
}
?>
<form>
    <textarea name="towns-incomes" rows="10"></textarea><br>
    <input type="submit" value="Calculate">
</form>
</body>
</html>