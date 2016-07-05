<html>
<head>
</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Input: <textarea name="key-value-pairs"></textarea>
    Target Key: <input type="text" name="target-key">
    <input type="submit">
</form>
</body>
</html>

<?php
if (isset($_GET['delimiter']) && isset($_GET['key-value-pairs']) && isset($_GET['target-key'])) {
    $delimiter = $_GET['delimiter'];
    $kvpInput = $_GET['key-value-pairs'];
    $targetKey = $_GET['target-key'];
    $kvpLines = array_map('trim', explode("\n", $kvpInput));
    $kvPairs = [];
    foreach ($kvpLines as $kvpLine) {
        $tokens = explode($delimiter, $kvpLine);
        $key = $tokens[0];
        $value = $tokens[1];
        $kvPairs[$key] = $value;
    }
    if (isset($kvPairs[$targetKey]))
        echo $kvPairs[$targetKey];
    else echo "None";
}