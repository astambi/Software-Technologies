<html>
<head>
</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Input: <textarea name="commands"></textarea>
    <input type="submit">
</form>
</body>
</html>

<?php
$arr = [];
if (isset($_GET['delimiter']) && isset($_GET['commands'])) {
    $delimiter = $_GET['delimiter'];
    $commandsInput = $_GET['commands'];
    $commands = explode("\n", $commandsInput);
    foreach ($commands as $command) {
        $commandDetails = explode($delimiter, $command);
        $addRemove = $commandDetails[0];
        $argument = intval($commandDetails[1]);
        if ($addRemove == "add")
            $arr[] = $argument;
        else if ($argument >= 0 && $argument < count($arr))
            array_splice($arr, $argument, 1);
    }
    foreach ($arr as $item)
        echo "$item<br>";
}