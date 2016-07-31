using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(MVC_Blog.Startup))]
namespace MVC_Blog
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
