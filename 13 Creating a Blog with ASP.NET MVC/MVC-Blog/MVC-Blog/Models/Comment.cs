using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MVC_Blog.Models
{
    public class Comment
    {
        public int Id { get; set; }

        [StringLength(500)]
        public string Text { get; set; }
        public Post Post { get; set; }
    }
}