<?php
// Connect & Query

$mysqli = new mysqli('localhost','root','','blog');
$mysqli->set_charset("utf8");

if ($mysqli->connect_errno)
    die("Cannot connect to MySQL");

$result = $mysqli->query("SELECT * FROM posts");

if (!$result)
    die("Cannot read `posts` table");

// Fetch Records

while ($row = $result->fetch_assoc()) {
    $title = htmlspecialchars($row['title']);
    $content = htmlspecialchars($row['content']);
    echo "<div style='background-color: #DDD'>Title: $title</div>" .
         "<div>Content: $content</div>";
};

// Prepared Statement

function deletePost($mysqli, $id) {
    $statement = $mysqli->prepare(
        "DELETE FROM posts WHERE id = ?");
    $statement->bind_param("i", $id);
    $statement->execute();
    return $statement->affected_rows > 0;
}