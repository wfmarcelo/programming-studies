using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace AutoMapperApp.Infrastructure.Migrations
{
    /// <inheritdoc />
    public partial class AddMoreSeedData : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.InsertData(
                table: "Products",
                columns: new[] { "Id", "CreationDate", "Name", "Price" },
                values: new object[,]
                {
                    { 6, new DateTime(2025, 10, 18, 10, 25, 0, 0, DateTimeKind.Unspecified), "SSD NVMe 1TB", 550.00m },
                    { 7, new DateTime(2025, 10, 18, 10, 30, 0, 0, DateTimeKind.Unspecified), "Placa de Vídeo RTX 4070", 4500.00m },
                    { 8, new DateTime(2025, 10, 18, 10, 35, 0, 0, DateTimeKind.Unspecified), "Processador Intel i7", 2200.00m },
                    { 9, new DateTime(2025, 10, 18, 10, 40, 0, 0, DateTimeKind.Unspecified), "Memória RAM 16GB", 350.00m },
                    { 10, new DateTime(2025, 10, 18, 10, 45, 0, 0, DateTimeKind.Unspecified), "Gabinete Gamer", 600.00m },
                    { 11, new DateTime(2025, 10, 18, 10, 50, 0, 0, DateTimeKind.Unspecified), "Fonte ATX 750W", 400.00m },
                    { 12, new DateTime(2025, 10, 18, 10, 55, 0, 0, DateTimeKind.Unspecified), "Cadeira Gamer", 900.00m },
                    { 13, new DateTime(2025, 10, 18, 11, 0, 0, 0, DateTimeKind.Unspecified), "Mesa para PC", 700.00m },
                    { 14, new DateTime(2025, 10, 18, 11, 5, 0, 0, DateTimeKind.Unspecified), "Microfone Condensador", 280.00m },
                    { 15, new DateTime(2025, 10, 18, 11, 10, 0, 0, DateTimeKind.Unspecified), "Ring Light", 150.00m },
                    { 16, new DateTime(2025, 10, 18, 11, 15, 0, 0, DateTimeKind.Unspecified), "Controle Xbox", 320.00m },
                    { 17, new DateTime(2025, 10, 18, 11, 20, 0, 0, DateTimeKind.Unspecified), "Volante Logitech", 1200.00m },
                    { 18, new DateTime(2025, 10, 18, 11, 25, 0, 0, DateTimeKind.Unspecified), "Joystick Arcade", 480.00m },
                    { 19, new DateTime(2025, 10, 18, 11, 30, 0, 0, DateTimeKind.Unspecified), "Óculos VR", 2500.00m },
                    { 20, new DateTime(2025, 10, 18, 11, 35, 0, 0, DateTimeKind.Unspecified), "Drone DJI Mini", 1800.00m },
                    { 21, new DateTime(2025, 10, 18, 11, 40, 0, 0, DateTimeKind.Unspecified), "Câmera Mirrorless", 3200.00m },
                    { 22, new DateTime(2025, 10, 18, 11, 45, 0, 0, DateTimeKind.Unspecified), "Lente 50mm", 800.00m },
                    { 23, new DateTime(2025, 10, 18, 11, 50, 0, 0, DateTimeKind.Unspecified), "Tripé Profissional", 200.00m },
                    { 24, new DateTime(2025, 10, 18, 11, 55, 0, 0, DateTimeKind.Unspecified), "Mochila para Câmera", 180.00m },
                    { 25, new DateTime(2025, 10, 18, 12, 0, 0, 0, DateTimeKind.Unspecified), "Cartão SD 128GB", 90.00m }
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 6);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 7);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 8);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 9);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 10);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 11);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 12);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 13);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 14);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 15);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 16);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 17);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 18);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 19);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 20);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 21);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 22);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 23);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 24);

            migrationBuilder.DeleteData(
                table: "Products",
                keyColumn: "Id",
                keyValue: 25);
        }
    }
}
