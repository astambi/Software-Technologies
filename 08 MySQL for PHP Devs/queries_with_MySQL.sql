SELECT * FROM users;

SELECT username, full_name
FROM users;

SELECT * FROM users
WHERE username='nakov';

SELECT * FROM users
WHERE full_name LIKE 'M%'
      OR
      full_name LIKE 'P%';

SELECT * FROM users
ORDER BY username;

SELECT * FROM users
ORDER BY full_name DESC
LIMIT 3;

SELECT *
FROM posts JOIN users
ON posts.user_id = users.id;

SELECT
  title AS post,
  username AS author
FROM
  posts p JOIN users u
ON
  p.user_id = u.id;

INSERT INTO
  posts (title, content, user_id)
VALUES
  ('New Title', 'New Post Content', 3);

INSERT INTO
  users (username, full_name)
VALUES
  ('joeGreen','Joe Green'),
  ('jeff','Jeff Brown'),
  ('poly','Paolina Code');

UPDATE posts
SET title='Title Updated!'
WHERE id=2;

UPDATE posts
SET date=str_to_date('31-12-2016','%d-%m-%Y')
WHERE year(date)=2016;

DELETE FROM posts
WHERE id=6;

DELETE FROM posts
WHERE user_id = (SELECT id
                 FROM users
                 WHERE username='joe');

INSERT INTO
  users (username, password_hash, full_name)
VALUES
  ('pesho','$xyz','Petar Ivanov');

UPDATE users
SET username='pepi'
WHERE username='pesho';

SELECT * FROM users
WHERE username LIKE 'p%';

# 'pepi' -> user_id 24

INSERT INTO
  posts (title, content, user_id)
VALUES
  ('new title from user pepi', 'new post content from user pepi',24);

SELECT *
FROM posts
WHERE user_id = (SELECT id
                 FROM users
                 WHERE username='pepi');

DELETE FROM posts
WHERE user_id = (SELECT id
                 FROM users
                 WHERE username = 'pepi');