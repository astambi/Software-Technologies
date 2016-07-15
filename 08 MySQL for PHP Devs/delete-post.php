<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Post from MySQL</title>
</head>
<body>

<?php
$mysqli = new mysqli('localhost', 'root', '', 'blog');
$mysqli->set_charset("utf8");

if (isset($_GET['id'])) {
    $st = $mysqli->prepare("DELETE FROM posts WHERE id = ?");
    $id = htmlspecialchars($_GET['id']);
    $st->bind_param("i", $id);
    $st->execute();
    
    if ($st->affected_rows == 1) echo "Post deleted.";
}
$result = $mysqli->query("SELECT id, title FROM posts");
while ($row = $result->fetch_assoc()) {
    $title = htmlspecialchars($row['title']);
    $delLink = 'delete-post.php?id=' . $row['id'];
    echo "<p><a href='$delLink'>Delete post '$title'.</a></p>";
}
?>

</body>
</html>