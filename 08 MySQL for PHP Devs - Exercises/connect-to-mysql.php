<?php
// Connect to MySQL

$hostname = 'localhost'; // .../xampp/htdocs
$username = 'root';
$password = '';
$dbname = 'blog';

$mysqli = new mysqli($hostname, $username, $password, $dbname);

// Check the Connection Status

if ($mysqli->connect_errno)
    die("Error! Failed to connect to MySQL");

// Set the default MySQL Charset to utf8 !

$mysqli->set_charset("utf8");