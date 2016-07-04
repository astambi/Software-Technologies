<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Celsius - Fahrenheit</title>
</head>
<body>
<?php
function celsiusToFahrenheit(float $celsius) : float
{
    return $celsius * 1.8 + 32;
}
function fahrenheitToCelsius(float $fahrenheit) : float
{
    return ($fahrenheit - 32) / 1.8;
}
$msgConvertCtoF = "";
if(isset($_GET['cel'])) {
    $cel = floatval($_GET['cel']);
    $fah = celsiusToFahrenheit($cel);
    $msgConvertCtoF = "$cel &deg;C = $fah &deg;F";
}
$msgConvertFtoC = "";
if(isset($_GET['fah'])) {
    $fah = floatval($_GET['fah']);
    $cel = fahrenheitToCelsius($fah);
    $msgConvertFtoC = "$fah &deg;F = $cel &deg;C";
}
?>
<form>
    Celsius: <input type="text" name="cel" />
    <input type="submit" value="Convert"/>
    <?= $msgConvertCtoF ?>
</form>
<form>
    Fahrenheit: <input type="text" name="fah" />
    <input type="submit" value="Convert"/>
    <?= $msgConvertFtoC ?>
</form>
</body>
</html>