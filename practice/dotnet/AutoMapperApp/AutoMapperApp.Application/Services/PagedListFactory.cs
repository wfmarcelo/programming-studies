using AutoMapperApp.Application.Interfaces;
using AutoMapperApp.Application.ViewModels;
using Microsoft.EntityFrameworkCore; // Necessário para ToListAsync e CountAsync
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AutoMapperApp.Application.Services
{
    public class PagedListFactory : IPagedListFactory
    {
        public async Task<PagedList<T>> CreateAsync<T>(IQueryable<T> source, int pageNumber, int pageSize) where T : class
        {
            var count = await source.CountAsync();
            var items = await source.Skip((pageNumber - 1) * pageSize).Take(pageSize).ToListAsync();
            return new PagedList<T>(items, count, pageNumber, pageSize);
        }

        public PagedList<T> Create<T>(IEnumerable<T> source, int pageNumber, int pageSize) where T : class
        {
            var count = source.Count();
            var items = source.Skip((pageNumber - 1) * pageSize).Take(pageSize).ToList();
            return new PagedList<T>(items, count, pageNumber, pageSize);
        }
    }
}