<?php
// Connect to MySQL

$hostname = 'localhost';
$username = 'root';
$password = '';
$dbname = 'blog';

$mysqli = new mysqli($hostname, $username, $password, $dbname);

if ($mysqli->connect_errno)
    die("Error! Failed to connect to MySQL");

$mysqli->set_charset("utf8");

// Execute SQL Query

$query = "SELECT * FROM posts";
$result = $mysqli->query($query);

if (!$result)
    die("Error! Failed to process query");

if ($result->num_rows > 0)
    while ($row = $result->fetch_assoc()) {
        echo "Id: " . htmlspecialchars($row['id']) . "<br>\n"
            . "Title: " . htmlspecialchars($row['title']) . "<br>\n"
            . "Content: " . htmlspecialchars($row['content']) . "<br>\n"
            . "Date: " . htmlspecialchars($row['date']) . "<br>\n";
//        echo "Id: " . $row['id'] . "<br>\n"
//            . "Title: " . $row['title'] . "<br>\n"
//            . "Content: " . $row['content'] . "<br>\n"
//            . "Date: " . $row['date'] . "<br>\n";
    }
else echo "0 results";