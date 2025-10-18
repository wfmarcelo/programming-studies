using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace AutoMapperApp.Infrastructure.Migrations
{
    /// <inheritdoc />
    public partial class InitialCreate : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Products",
                columns: table => new
                {
                    Id = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    Name = table.Column<string>(type: "TEXT", nullable: false),
                    Price = table.Column<decimal>(type: "TEXT", nullable: false),
                    CreationDate = table.Column<DateTime>(type: "TEXT", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Products", x => x.Id);
                });

            migrationBuilder.InsertData(
                table: "Products",
                columns: new[] { "Id", "CreationDate", "Name", "Price" },
                values: new object[,]
                {
                    { 1, new DateTime(2025, 10, 18, 10, 0, 0, 0, DateTimeKind.Unspecified), "Monitor UltraWide", 1450.50m },
                    { 2, new DateTime(2025, 10, 18, 10, 5, 0, 0, DateTimeKind.Unspecified), "Teclado Mecânico", 250.50m },
                    { 3, new DateTime(2025, 10, 18, 10, 10, 0, 0, DateTimeKind.Unspecified), "Mouse Gamer", 120.00m },
                    { 4, new DateTime(2025, 10, 18, 10, 15, 0, 0, DateTimeKind.Unspecified), "Headset Bluetooth", 300.00m },
                    { 5, new DateTime(2025, 10, 18, 10, 20, 0, 0, DateTimeKind.Unspecified), "Webcam 4K", 450.00m }
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Products");
        }
    }
}
