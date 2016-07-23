SELECT * FROM Users;

SELECT Username, FullName
FROM Users;

SELECT * FROM Users
WHERE ID = 2;

SELECT * FROM Users
WHERE FullName >= 'M';

SELECT * FROM Users
ORDER BY Username;

SELECT TOP 3 * 
FROM Users
ORDER BY FullName DESC;

SELECT 
	p.ID as PostID, 
	p.Title,
	c.ID as CommentID,
	c.Text,
	c.Date 
FROM 
	Posts p JOIN Comments c 
	ON p.ID = c.PostID;

SELECT 
	c.ID AS CommentID,
	c.Text AS CommentText,
	ISNULL(u.FullName, c.AuthorName) AS Author
FROM 
	Comments c LEFT JOIN Users u 
	ON c.AuthorID = u.ID
WHERE PostID = 1;

SELECT 
	p.ID AS PostID, 
	p.Title, 
	t.ID AS TagID, 
	t.Name
FROM 
	Posts p 
	JOIN Posts_Tags pt ON p.ID = pt.PostID
	JOIN Tags t ON TagID = t.ID;

SELECT MIN(Date) FROM Comments;

SELECT COUNT(*) AS [Comments Count]
FROM Comments
WHERE PostID = 1;

SELECT 
	PostID, 
	COUNT(ID) AS CommentsCount
FROM Comments
GROUP BY PostID;

SELECT 
	DISTINCT p.ID AS PostID,
	p.Title
FROM 
	Posts p JOIN Posts_Tags pt 
	ON P.ID = pt.PostID
WHERE 
	pt.TagID IN (SELECT ID FROM Tags
				 WHERE Name IN ('programming', 'Web'))
ORDER BY p.Title;

INSERT INTO Posts(Title, Body, AuthorID)
VALUES ('New Title', 'New post comment', 3);

INSERT INTO 
	Users(Username, PasswordHash)
VALUES
	('joe', HASHBYTES('SHA2_256', 'P@$$@123')),
	('jeff', HASHBYTES('SHA2_256', 'SofiA!')),
	('poly', HASHBYTES('SHA2_256', 'p@ss123'));
	
UPDATE Posts
SET Title = 'Title Updated!'
WHERE ID = 2;

UPDATE Posts
SET Date = '2016-05-29T23:51:00'
WHERE YEAR(Date) = 2016;

DELETE FROM Posts
WHERE ID = 9;

DELETE FROM Comments
WHERE AuthorID = (SELECT ID FROM Users
				  WHERE Username = 'maria');

--T-SQL
USE master
GO
IF DB_ID('BlogDB') IS NOT NULL
BEGIN
	ALTER DATABASE BlogDB
	SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
	DROP DATABASE BlogDB
END
GO

--CREATE DATABASE BlogDB
--GO

--USE BlogDB
--GO

CREATE TABLE Tags(
	ID int IDENTITY NOT NULL, 
	Name nvarchar(50) NOT NULL,
	CONSTRAINT PK_Tags PRIMARY KEY (ID));

--CREATE TABLE Comments(
--	ID int IDENTITY NOT NULL,
--	Text nvarchar(max) NOT NULL,
--	PostID int NOT NULL,
--	AuthorID int NULL,
--	AuthorName nvarchar(100) NULL,
--	Date datetime NOT NULL,
--  CONSTRAINT PK_Comments PRIMARY KEY (ID))
--GO

ALTER TABLE Comments ADD CONSTRAINT
	DB_Comments_Date DEFAULT GETDATE() FOR Date;

DROP TABLE Tags;