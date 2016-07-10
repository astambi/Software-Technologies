<?php
$hostname = 'localhost';
$username = 'root';
$password = '';
$dbname = 'blog';
$mysqli = new mysqli($hostname, $username, $password, $dbname);

if ($mysqli->connect_errno)
    die("Error! Failed to connect to MySQL");

$mysqli->set_charset("utf8");

$query = $mysqli->prepare(
    "INSERT INTO users(username, password, fullname) VALUES(?,?,?)");
$userUsername = "Greta";
$userPassword = md5("IchLiebeWurstchen");
$userFullname = "Greta Berghoffen";
$query->bind_param("sss", $userUsername, $userPassword, $userFullname);
$query->execute();

if ($query->affected_rows == 1)
    echo "User successfully created!";
else die("Creating user failed");