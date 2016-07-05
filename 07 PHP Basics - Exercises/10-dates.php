<html>
<head>
</head>
<body>
<form>
    Start Date:
    <br>
    <input type="text" name="date">
    <br>
    Output Format:
    <br>
    <input type="text" name="format">
    <br>
    Commands:
    <br>
    <textarea name="commands"></textarea>
    <br>
    <input type="submit">
</form>
</body>
</html>

<?php
date_default_timezone_set('Europe/Sofia');
if (isset($_GET['date']) && isset($_GET['format']) && isset($_GET['commands'])) {
    $dateFormat = $_GET['format'];
    $date = DateTime::createFromFormat('d/m/Y', $_GET['date']);
    $commands = explode(" ", $_GET['commands']);
    $command = $commands[0];
    $argument = intval($commands[1]);
    if ($command == "add")
        $date = $date->modify('+' . $argument . 'day');
    else $date = $date->modify('-' . $argument . 'day');
    echo $date->format($dateFormat);
//    echo date_format($date, $dateFormat);
}
?>