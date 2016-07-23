--Problem 7. SELECT Commands
SELECT * FROM [Blog].[dbo].[Posts];

SELECT * FROM [Blog].[dbo].[Users];

SELECT 
	Title, Body
FROM 
	[Blog].[dbo].[Posts];

SELECT
	UserName, FullName
FROM 
	[Blog].[dbo].[Users]
ORDER BY UserName ASC;

SELECT
	UserName, FullName
FROM 
	[Blog].[dbo].[Users]
ORDER BY 
	FullName DESC,
	UserName DESC;

SELECT *
FROM
	[Blog].[dbo].[Users]
WHERE 
	Id IN  (SELECT AuthorId
			FROM [Blog].[dbo].[Posts]);

SELECT
	[Blog].[dbo].[Users].UserName,
	[Blog].[dbo].[Posts].Title
FROM 
	[Blog].[dbo].[Users] JOIN
	[Blog].[dbo].[Posts] ON
	[Blog].[dbo].[Users].Id = [Blog].[dbo].[Posts].AuthorId;

SELECT 
	UserName, FullName
FROM 
	[Blog].[dbo].[Users]
WHERE 
	Id IN  (SELECT AuthorId
			FROM [Blog].[dbo].[Posts]
			WHERE Id = 4);

SELECT
	UserName, FullName
FROM
	[Blog].[dbo].[Users]
WHERE 
	Id IN	(SELECT AuthorId
			FROM [Blog].[dbo].[Posts])
ORDER BY Id DESC;

--Problem 8. INSERT Command
INSERT INTO 
	[Blog].[dbo].[Posts] ([AuthorId],[Title],[Body],[Date])
VALUES
	(2, 'Random Title', 'Random Content', CAST('2016-07-13T11:30:00' AS datetime));

--Problem 9. UPDATE Command

--SELECT * FROM [Blog].[dbo].[Posts];
--New post ID = 33

UPDATE [Blog].[dbo].[Posts]
SET Title = 'New Title'
WHERE Id = 33;

--Problem 10. DELETE Command
DELETE FROM [Blog].[dbo].[Posts]
WHERE Id = 33;

--Problem 11. COUNT Command
SELECT COUNT(*) AS Posts_Count
FROM [Blog].[dbo].[Posts];

SELECT COUNT(*) AS Posts_Count
FROM [Blog].[dbo].[Posts]
WHERE AuthorId = 2;

--Problem 12. MIN Command
SELECT MIN(AuthorId) AS Min_Value
FROM [Blog].[dbo].[Posts];

SELECT MIN(Date) AS Min_Value
FROM [Blog].[dbo].[Posts];

--Problem 13. MAX Command
SELECT MAX(AuthorId) AS Max_Value
FROM [Blog].[dbo].[Posts];

SELECT MAX(Id) AS Max_Value
FROM [Blog].[dbo].[Tags];

--Problem 14. SUM Command
SELECT 
	Sum(Id) AS Sum_Ids
FROM 
	[Blog].[dbo].[Tags];

SELECT 
	Sum(Id) AS Sum_Users_With_Posts_Ids
FROM 
	[Blog].[dbo].[Users]
WHERE 
	Id IN  (SELECT AuthorId
			FROM [Blog].[dbo].[Posts]);

--Problem 15. Count of Users Having a Post in a Specified Date
SELECT 
	COUNT(AuthorId) AS Users_Count
FROM 
	[Blog].[dbo].[Posts]
WHERE 
	Id IN	(SELECT AuthorID
			FROM [Blog].[dbo].[Posts]
			WHERE
				Date >= '2016-06-14T00:00:00' AND
				Date < '2016-06-15T00:00:00');
				
--Problem 16. Extract and Order All the Posts in a Specified Date		
SELECT *
FROM 
	[Blog].[dbo].[Posts]
WHERE 
	Date >= '2016-06-14T00:00:00' AND
	Date < '2016-06-15T00:00:00'
ORDER BY AuthorId ASC;

--Problem 17. Find the Earliest Post from a Specified User
SELECT TOP 1 * 
FROM 
	[Blog].[dbo].[Posts]
WHERE 
	AuthorId = 2
ORDER BY Date ASC;

--Problem 18. Play with Comments
SELECT * 
FROM 
	[Blog].[dbo].[Comments]
ORDER BY 
	AuthorName ASC,
	Id DESC;