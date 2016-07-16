SELECT * FROM users;

SELECT * FROM posts;

SELECT title, content
FROM posts;

SELECT username, fullname
FROM users
ORDER BY username ASC;

SELECT username, fullname
FROM users
ORDER BY
  fullname DESC,
  username DESC;

SELECT *
FROM users
WHERE id IN (SELECT author_id
             FROM posts);

SELECT username, title
FROM
  posts JOIN users
ON
  posts.author_id = users.id;

SELECT username, fullname
FROM users
WHERE id IN (SELECT author_id
             FROM posts
             WHERE posts.id = 4);

SELECT username, fullname
FROM users
WHERE id IN (SELECT author_id
             FROM posts)
ORDER BY id DESC;

INSERT INTO
  posts (author_id, title, content, date)
VALUES
  (2, 'Random Title','Random Content', str_to_date('2016-07-06','%Y-%m-%d'));

# new post id = 8
UPDATE posts
SET title = 'Too random to be true'
WHERE id = 8;

DELETE FROM posts
WHERE id = 8;

# DROP TABLE posts;

# DROP TABLE users;