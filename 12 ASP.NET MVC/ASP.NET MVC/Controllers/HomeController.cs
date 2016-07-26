﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ASP.NET_MVC.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Numbers()
        {
            return View();
        }

        public ActionResult Files(string path = @"C:\")
        {
            path = Path.GetFullPath(path);

            List<string> files = Directory
                .GetDirectories(path)
                .ToList();
            files.AddRange(Directory.GetFiles(path));

            ViewBag.Path = path;
            ViewBag.ParentFolder = path + @"\..\";

            return View(files);
        }
    }
}