<html>
<head>
</head>
<body>
<form>
    Input:
    <br>
    <textarea name="input"></textarea>
    <br>
    Delimiter:
    <br>
    <input type="text" name="delimiter">
    <br>
    <input type="submit">
</form>
</body>
</html>

<?php
if (isset($_GET['delimiter']) && isset($_GET['input'])) {
    $input = $_GET['input'];
    $delimiter = $_GET['delimiter'];

    $lines = array_map('trim', explode("\n", $input));
    $data = [];
    foreach ($lines as $line) {
        $tokens = explode($delimiter, $line);
        $data[] = $tokens[0];
        $data[] = $tokens[1];
    }
    $student = array($data[0] => $data[1],
                    $data[2] => $data[3],
                    $data[4] => intval($data[5]),
                    $data[6] => floatval($data[7]),
                    $data[8] => $data[9],
                    $data[10] => $data[11]);
//    var_dump($student);
    echo json_encode($student, JSON_UNESCAPED_SLASHES);
}