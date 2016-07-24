using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityFrameworkExercises
{
    class EntityFrameworkExercises
    {
        static void Main(string[] args)
        {
            //Problem 1 Read Data
            ListsAllPosts();
            ListAllUsers();
            ListTitleAndBodyFromPosts();
            OrderData();
            OrderByTwoColumns();
            SelectAuthor();
            JoinAuthorsWithTitles();
            SelectAuthorOfSpecificPostSolution1();
            SelectAuthorOfSpecificPostSolution2();
            OrderPostAuthors();

            //Problem 2 Create Data
            CreateData();

            //Problem 3 Update Data
            UpdateData();

            //Problem 4 Delete Data
            DeleteComment();
            DeletePostWithCommentsAndTags();
        }

        private static void DeletePostWithCommentsAndTags()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            Post postInfo = blogDbContext.Posts
                .Single(post => post.Id == 31);

            blogDbContext.Comments.RemoveRange(postInfo.Comments);
            postInfo.Tags.Clear();
            blogDbContext.Posts.Remove(postInfo);
            blogDbContext.SaveChanges();

            Console.WriteLine($"Post #{postInfo.Id} deleted successfully");
        }

        private static void DeleteComment()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            Comment commentInfo = blogDbContext.Comments
                .Single(comment => comment.Id == 1);

            blogDbContext.Comments.Remove(commentInfo);
            blogDbContext.SaveChanges();

            Console.WriteLine($"Comment #{commentInfo.Id} deleted");
        }

        private static void UpdateData()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            User userInfo = blogDbContext.Users
                .Single(user => user.UserName == "GBotev");

            string oldName = userInfo.FullName;
            userInfo.FullName = "Georgi Botev";
            blogDbContext.SaveChanges();

            Console.WriteLine($"User '{oldName}' has been renamed to '{userInfo.FullName}'");
        }

        private static void CreateData()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            Post post = new Post()
            {
                AuthorId = 2,
                Title = "Random Title",
                Body = "Random Content",
                Date = DateTime.Now
            };

            blogDbContext.Posts.Add(post);
            blogDbContext.SaveChanges();

            Console.WriteLine($"Post #{post.Id} Created!");
        }

        private static void OrderPostAuthors()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            var authors = blogDbContext.Users
                .Where(user => user.Posts.Count() > 0)
                .Select(user => new { user.UserName, user.FullName, user.Id })
                .OrderByDescending(user => user.Id)
                .ToList();

            foreach (var author in authors)
            {
                Console.WriteLine($"Username: {author.UserName}");
                Console.WriteLine($"Full Name: {author.FullName}");
            }
        }

        private static void SelectAuthorOfSpecificPostSolution2()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            User author = blogDbContext.Posts
                .Find(4) // post.Id = 4
                .User;

            Console.WriteLine($"Username: {author.UserName}");
            Console.WriteLine($"Full Name: {author.FullName}");
            Console.WriteLine();
        }

        private static void SelectAuthorOfSpecificPostSolution1()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            var author = blogDbContext.Users
                .SelectMany(user => user.Posts,
                    (user, post) => new { user.UserName, user.FullName, post.Id })
                .Single(post => post.Id == 4);

            Console.WriteLine($"Username: {author.UserName}");
            Console.WriteLine($"Full Name: {author.FullName}");
            Console.WriteLine();
        }

        private static void JoinAuthorsWithTitles()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            var users = blogDbContext.Users
                .SelectMany(user => user.Posts,
                    (user, post) => new { user.UserName, post.Title });

            foreach (var user in users)
            {
                Console.WriteLine($"Username: {user.UserName}");
                Console.WriteLine($"Post Title: {user.Title}");
                Console.WriteLine();
            }
        }

        private static void SelectAuthor()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            List<User> users = blogDbContext.Users
                .Select(user => user)
                .Where(user => user.Posts.Count > 0)
                .ToList();

            foreach (User user in users)
            {
                Console.WriteLine($"Username: {user.UserName}");
                Console.WriteLine($"Full Name: {user.FullName}");
                Console.WriteLine($"Posts Count: {user.Posts.Count}");
                Console.WriteLine();
            }
        }

        private static void OrderByTwoColumns()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            var users = blogDbContext.Users
                .Select(user => new
                {
                    user.UserName,
                    user.FullName
                })
                .OrderByDescending(user => user.UserName)
                .ThenByDescending(user => user.FullName)
                .ToList();

            foreach (var user in users)
            {
                Console.WriteLine($"Username: {user.UserName}");
                Console.WriteLine($"Full Name: {user.FullName}");
                Console.WriteLine();
            }
        }

        private static void OrderData()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            var users = blogDbContext.Users
                .Select(user => new
                {
                    user.UserName,
                    user.FullName
                })
                .OrderBy(user => user.UserName)
                .ToList();

            foreach (var user in users)
            {
                Console.WriteLine($"Username: {user.UserName}");
                Console.WriteLine($"Full Name: {user.FullName}");
                Console.WriteLine();
            }
        }

        private static void ListTitleAndBodyFromPosts()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            var posts = blogDbContext.Posts.Select(post => new
            {
                post.Title,
                post.Body
            });

            foreach (var post in posts)
            {
                Console.WriteLine($"Title: {post.Title}");
                Console.WriteLine($"Content: {post.Body}");
                Console.WriteLine();
            }
        }

        private static void ListAllUsers()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            List<User> users = blogDbContext.Users.Select(user => user).ToList();

            foreach (User user in users)
            {
                Console.WriteLine($"ID: {user.Id}");
                Console.WriteLine($"Name: {user.FullName}");
                Console.WriteLine($"Comments Count: {user.Comments.Count}");
                Console.WriteLine($"Posts Count: {user.Posts.Count}");
                Console.WriteLine();
            }
        }

        private static void ListsAllPosts()
        {
            BlogDbContext blogDbContext = new BlogDbContext();

            List<Post> posts = blogDbContext.Posts.Select(post => post).ToList();

            foreach (Post post in posts)
            {
                Console.WriteLine($"Title: {post.Title}");
                Console.WriteLine($"AuthorId: {post.AuthorId}");
                Console.WriteLine($"Comments Count: {post.Comments.Count()}");
                Console.WriteLine($"Tags Count: {post.Tags.Count}");
                Console.WriteLine();
            }
        }
    }
}