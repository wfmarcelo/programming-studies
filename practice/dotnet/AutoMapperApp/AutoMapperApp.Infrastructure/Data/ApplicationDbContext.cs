// filepath: /home/marcelo/Projetos/pessoal/programming-studies/practice/dotnet/AutoMapperApp/AutoMapperApp.Infrastructure/Data/ApplicationDbContext.cs
using AutoMapperApp.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using System; // Ensure System namespace is included for DateTime

namespace AutoMapperApp.Infrastructure.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {
        }

        public DbSet<Product> Products { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Product>().HasKey(p => p.Id);
            modelBuilder.Entity<Product>().Property(p => p.Id).ValueGeneratedOnAdd();

            // Use um valor DateTime estático e fixo para CreationDate
            modelBuilder.Entity<Product>().HasData(
                new Product { Id = 1, Name = "Monitor UltraWide", Price = 1450.50m, CreationDate = new DateTime(2025, 10, 18, 10, 0, 0) },
                new Product { Id = 2, Name = "Teclado Mecânico", Price = 250.50m, CreationDate = new DateTime(2025, 10, 18, 10, 5, 0) },
                new Product { Id = 3, Name = "Mouse Gamer", Price = 120.00m, CreationDate = new DateTime(2025, 10, 18, 10, 10, 0) },
                new Product { Id = 4, Name = "Headset Bluetooth", Price = 300.00m, CreationDate = new DateTime(2025, 10, 18, 10, 15, 0) },
                new Product { Id = 5, Name = "Webcam 4K", Price = 450.00m, CreationDate = new DateTime(2025, 10, 18, 10, 20, 0) },
                new Product { Id = 6, Name = "SSD NVMe 1TB", Price = 550.00m, CreationDate = new DateTime(2025, 10, 18, 10, 25, 0) },
                new Product { Id = 7, Name = "Placa de Vídeo RTX 4070", Price = 4500.00m, CreationDate = new DateTime(2025, 10, 18, 10, 30, 0) },
                new Product { Id = 8, Name = "Processador Intel i7", Price = 2200.00m, CreationDate = new DateTime(2025, 10, 18, 10, 35, 0) },
                new Product { Id = 9, Name = "Memória RAM 16GB", Price = 350.00m, CreationDate = new DateTime(2025, 10, 18, 10, 40, 0) },
                new Product { Id = 10, Name = "Gabinete Gamer", Price = 600.00m, CreationDate = new DateTime(2025, 10, 18, 10, 45, 0) },
                new Product { Id = 11, Name = "Fonte ATX 750W", Price = 400.00m, CreationDate = new DateTime(2025, 10, 18, 10, 50, 0) },
                new Product { Id = 12, Name = "Cadeira Gamer", Price = 900.00m, CreationDate = new DateTime(2025, 10, 18, 10, 55, 0) },
                new Product { Id = 13, Name = "Mesa para PC", Price = 700.00m, CreationDate = new DateTime(2025, 10, 18, 11, 0, 0) },
                new Product { Id = 14, Name = "Microfone Condensador", Price = 280.00m, CreationDate = new DateTime(2025, 10, 18, 11, 5, 0) },
                new Product { Id = 15, Name = "Ring Light", Price = 150.00m, CreationDate = new DateTime(2025, 10, 18, 11, 10, 0) },
                new Product { Id = 16, Name = "Controle Xbox", Price = 320.00m, CreationDate = new DateTime(2025, 10, 18, 11, 15, 0) },
                new Product { Id = 17, Name = "Volante Logitech", Price = 1200.00m, CreationDate = new DateTime(2025, 10, 18, 11, 20, 0) },
                new Product { Id = 18, Name = "Joystick Arcade", Price = 480.00m, CreationDate = new DateTime(2025, 10, 18, 11, 25, 0) },
                new Product { Id = 19, Name = "Óculos VR", Price = 2500.00m, CreationDate = new DateTime(2025, 10, 18, 11, 30, 0) },
                new Product { Id = 20, Name = "Drone DJI Mini", Price = 1800.00m, CreationDate = new DateTime(2025, 10, 18, 11, 35, 0) },
                new Product { Id = 21, Name = "Câmera Mirrorless", Price = 3200.00m, CreationDate = new DateTime(2025, 10, 18, 11, 40, 0) },
                new Product { Id = 22, Name = "Lente 50mm", Price = 800.00m, CreationDate = new DateTime(2025, 10, 18, 11, 45, 0) },
                new Product { Id = 23, Name = "Tripé Profissional", Price = 200.00m, CreationDate = new DateTime(2025, 10, 18, 11, 50, 0) },
                new Product { Id = 24, Name = "Mochila para Câmera", Price = 180.00m, CreationDate = new DateTime(2025, 10, 18, 11, 55, 0) },
                new Product { Id = 25, Name = "Cartão SD 128GB", Price = 90.00m, CreationDate = new DateTime(2025, 10, 18, 12, 0, 0) }
            );

            base.OnModelCreating(modelBuilder);
        }
    }
}