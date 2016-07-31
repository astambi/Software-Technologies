using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using MVC_Blog.Models;
using System.Web.Security;
using MVC_Blog.Extensions;

namespace MVC_Blog.Controllers
{
    [ValidateInput(false)]
    public class PostsController : Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        public bool isAdmin()
        {
            var currentUserId = this.User.Identity.Name;
            bool isAdmin = currentUserId != null && this.User.IsInRole("Administrators");
            return isAdmin;
        }

        public bool isPostAuthor(Post post)
        {
            var currentUser = db.Users
                            .FirstOrDefault(u => u.UserName == User.Identity.Name);
            bool isPostAuthor = currentUser.Id == post.Author_Id;
            return isPostAuthor;
        }

        // GET: Posts
        public ActionResult Index()
        {
            var postsWithAuthors = db.Posts
                                .Include(p => p.Author)
                                .OrderByDescending(p => p.Date);

            if (!User.Identity.IsAuthenticated)
            {
                this.AddNotification("To read older posts you have to be a registered user. Please register or login to continue reading.", NotificationType.INFO); // Notifications
                return View("InfoMsg");                
            }

            return View(postsWithAuthors);
        }

        // GET: Posts/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);

            if (post == null)
            {
                return HttpNotFound();
            }
            var recentPosts = db.Posts
                            .Include(p => p.Author)
                            .OrderByDescending(p => p.Date)
                            .Take(5)
                            .Select(p => p.Id)
                            .ToList();

            if (!User.Identity.IsAuthenticated && !recentPosts.Contains(post.Id))
            {
                this.AddNotification("To read older posts you have to be a registered user. Please register or login to continue reading.", NotificationType.INFO); // Notifications
                return View("InfoMsg");
            }

            return View(post);
        }

        // GET: Posts/Create
        [Authorize]
        //[ValidateInput(false)]
        public ActionResult Create()
        {
            return View();
        }

        // POST: Posts/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [Authorize]
        //[ValidateInput(false)]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Title,Body")] Post post)
        {
            if (ModelState.IsValid)
            {
                post.Author = db.Users
                            .FirstOrDefault(u => u.UserName == User.Identity.Name);

                db.Posts.Add(post);
                db.SaveChanges();

                this.AddNotification("Post was created", NotificationType.SUCCESS); // Notifications

                return RedirectToAction("Index");
            }

            return View(post);
        }

        // GET: Posts/Edit/5
        [Authorize]
        //[Authorize(Roles = "Administrators")]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);
            if (post == null)
            {
                return HttpNotFound();
            }

            if (!isAdmin() && !isPostAuthor(post))
            {
                this.AddNotification("You cannot modify a post that was created by another user", NotificationType.ERROR); // Notifications
                return View("InfoMsg");
            }

            var authors = db.Users
                         .OrderBy(u => u.FullName)
                         .ToList();
            ViewBag.Authors = authors;

            return View(post);
        }

        // POST: Posts/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [Authorize]
        //[Authorize(Roles = "Administrators")]
        //[ValidateInput(false)]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Title,Body,Date,Author_Id")] Post post)
        {


            if (ModelState.IsValid)
            {
                db.Entry(post).State = EntityState.Modified;
                db.SaveChanges();

                this.AddNotification("Post was modified", NotificationType.SUCCESS); // Notifications

                return RedirectToAction("Index");
            }
            return View(post);
        }

        // GET: Posts/Delete/5
        //[Authorize(Roles = "Administrators")]
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);
            if (post == null)
            {
                return HttpNotFound();
            }

            if (!isAdmin())
            {
                this.AddNotification("You do not have Administrator privileges to delete posts", NotificationType.ERROR); // Notifications
                return View("InfoMsg");                
            }
            return View(post);
        }

        // POST: Posts/Delete/5
        [HttpPost, ActionName("Delete")]
        [Authorize(Roles = "Administrators")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Post post = db.Posts.Find(id);
            db.Posts.Remove(post);
            db.SaveChanges();

            this.AddNotification("Post was deleted", NotificationType.SUCCESS); // Notifications

            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
