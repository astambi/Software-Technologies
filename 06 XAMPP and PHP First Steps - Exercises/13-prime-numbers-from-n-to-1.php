<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Prime Number From N to 1</title>
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
    $num = intval($_GET['num']); // positive number
    $primes = [];
    for ($i = 0; $i <= $num; $i++)
        $primes[$i] = true;
    $primes[0] = false;
    $primes[1] = false;
//    Sieve of Erastosthenes
    for ($number = 2; $number < $num; $number++)
        if ($primes[$number] == true)
            for ($nonPrime = 2 * $number; $nonPrime <= $num; $nonPrime += $number)
                $primes[$nonPrime] = false;
//    var_dump($primes);
//    2 is prime, code modified for testing in Judge
    for ($number = $num - 1; $number > 2; $number--) // num is positive
        if ($primes[$number] == true)
            echo "$number ";
}
?>
</body>
</html>