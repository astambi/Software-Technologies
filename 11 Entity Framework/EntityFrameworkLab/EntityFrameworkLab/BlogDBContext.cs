namespace EntityFrameworkLab
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class BlogDBContext : DbContext
    {
        public BlogDBContext()
            : base("name=BlogDBContext")
        {
        }

        public virtual DbSet<Comment> Comments { get; set; }
        public virtual DbSet<Post> Posts { get; set; }
        public virtual DbSet<Tag> Tags { get; set; }
        public virtual DbSet<User> Users { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Post>()
                .HasMany(e => e.Comments)
                .WithRequired(e => e.Post)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Post>()
                .HasMany(e => e.Tags)
                .WithMany(e => e.Posts)
                .Map(m => m.ToTable("Posts_Tags").MapLeftKey("PostID").MapRightKey("TagID"));

            modelBuilder.Entity<User>()
                .Property(e => e.Username)
                .IsUnicode(false);

            modelBuilder.Entity<User>()
                .HasMany(e => e.Comments)
                .WithOptional(e => e.User)
                .HasForeignKey(e => e.AuthorID);

            modelBuilder.Entity<User>()
                .HasMany(e => e.Posts)
                .WithOptional(e => e.User)
                .HasForeignKey(e => e.AuthorID);
        }
    }
}
