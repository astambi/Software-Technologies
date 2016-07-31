using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC_Blog.Classes
{
    public class Utils
    {
        public static string CutText(string text, int maxLength = 100)
        {
            if (text == null)
                return null;
            if (text.Length <= maxLength)
                return text;
            string shortText = text.Substring(0, maxLength) + "...";
            return shortText;
        }
    }
}