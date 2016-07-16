# insert a new post
INSERT INTO blog.posts (author_id, title, content, date) VALUES
  (2, "Random Title", "Random Content", str_to_date("2016-07-06", "%Y-%m-%d"));

SELECT *
FROM blog.posts;
# id = 8

# update post
UPDATE blog.posts
SET title = "Too random to be true"
WHERE id=8;

SELECT title
FROM blog.posts
WHERE id=8;

# delete post
DELETE FROM posts
WHERE id=8;

SELECT *
FROM blog.posts
WHERE id=8;