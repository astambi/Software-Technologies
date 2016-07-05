<html>
<head>
</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Array-size: <input type="text" name="array-size">
    Input: <textarea name="key-value-pairs"></textarea>
    <input type="submit">
</form>
</body>
</html>
<?php
if (isset($_GET['delimiter']) && isset($_GET['array-size']) && isset($_GET['key-value-pairs'])) {
    $delimiter = $_GET['delimiter'];
    $arraySize = intval($_GET['array-size']);
    $kvpInput = $_GET['key-value-pairs'];
    $kvpLines = array_map('trim', explode("\n", $kvpInput));
    $kvPairs = [$arraySize];
    for ($i = 0; $i < $arraySize; $i++ )
        $kvPairs[$i] = 0;
    foreach ($kvpLines as $kvpLine) {
        $tokens = explode($delimiter, $kvpLine);
        $key = intval($tokens[0]);
        $value = $tokens[1];
        $kvPairs[$key] = $value;
    }
    for ($i = 0; $i < $arraySize; $i++)
        echo "$kvPairs[$i]<br>";
}