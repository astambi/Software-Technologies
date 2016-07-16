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

$query = $mysqli->prepare(
    "INSERT INTO users(username, password, fullname) " .
    "VALUES(?,?,?)");
$newUsername = "Greta";
$newPassword = md5("IchLiebeWurstchen");
$newFullname = "Greta Berghoffen";

$query->bind_param(
    "sss",
    $newUsername, $newPassword, $newFullname);
$query->execute();

if ($query->affected_rows == 1)
    echo "User successfully created!";
else die("Creating user failed");