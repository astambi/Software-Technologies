using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ASP.NET_MVC.Classes
{
    public class Utils
    {
        public static string CutText(string text, int maxLen = 100)
        {
            if (text == null)
                return null;
            if (text.Length <= 100)
                return text;
            return text.Substring(0, maxLen) + "...";
        }
    }
}