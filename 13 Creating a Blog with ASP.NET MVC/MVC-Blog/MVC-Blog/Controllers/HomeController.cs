using MVC_Blog.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;

namespace MVC_Blog.Controllers
{
    public class HomeController : Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        public ActionResult Index()
        {
            var last5Posts = db.Posts
                            .Include(p => p.Author)
                            .OrderByDescending(p => p.Date)
                            .Take(5);

            var posts = last5Posts
                        .Take(3)
                        .ToList();

            ViewBag.SidebarPosts = last5Posts.ToList();

            return View(posts);
        }


    }
}