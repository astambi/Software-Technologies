<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New Post in MySQL</title>
</head>
<body>

<form>
    <div>Title</div>
    <input type="text" name="title">
    <div>Content</div>
    <textarea name="content"></textarea>
    <div><input type="submit" value="Post"></div>
</form>

<?php
if (isset($_GET['title'])) {
    $mysqli = new mysqli('localhost', 'root', '', 'blog');
    $mysqli->set_charset("utf8");

    $stmt = $mysqli->prepare(
        "INSERT INTO posts(title, content) VALUES (?, ?)");
    $title = $_GET['title'];
    $content = $_GET['content'];
    $stmt->bind_param("ss", $title, $content);
    $stmt->execute();

    if ($stmt->affected_rows == 1) echo "Post created.";
    else die("Insert post failed.");
}
?>

</body>
</html>