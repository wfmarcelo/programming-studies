using AutoMapperApp.Infrastructure.Data;
using AutoMapperApp.Infrastructure.Interfaces;
using AutoMapperApp.Infrastructure.QueryParameters;
using Microsoft.EntityFrameworkCore;
using System;
using System.Linq;
using System.Linq.Dynamic.Core;
using System.Threading.Tasks;

namespace AutoMapperApp.Infrastructure.Repositories
{
    public abstract class GenericRepository<TEntity, TQueryParameters> : IGenericRepository<TEntity, TQueryParameters>
        where TEntity : class
        where TQueryParameters : BaseQueryParameters
    {
        protected readonly ApplicationDbContext _context;
        protected readonly DbSet<TEntity> _dbSet;

        public GenericRepository(ApplicationDbContext context)
        {
            _context = context;
            _dbSet = _context.Set<TEntity>();
        }

        public virtual async Task<IQueryable<TEntity>> GetAllAsync(TQueryParameters queryParameters)
        {
            IQueryable<TEntity> query = _dbSet;

            // Aplica filtros específicos da entidade (implementado nas classes derivadas)
            query = ApplyFilters(query, queryParameters);

            // Aplica ordenação
            if (!string.IsNullOrWhiteSpace(queryParameters.OrderBy))
            {
                string orderByClause = queryParameters.OrderBy;
                string[] parts = orderByClause.Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string propertyName = parts[0];
                string direction = parts.Length > 1 ? parts[1] : "asc";

                // Lógica especial para tipos decimal (como Price) no SQLite
                if (typeof(TEntity).GetProperty(propertyName, System.Reflection.BindingFlags.IgnoreCase | System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.Instance)?.PropertyType == typeof(decimal))
                {
                    if (direction.Equals("desc", StringComparison.OrdinalIgnoreCase))
                    {
                        query = query.OrderByDescending(e => EF.Property<double>(e, propertyName));
                    }
                    else
                    {
                        query = query.OrderBy(e => EF.Property<double>(e, propertyName));
                    }
                }
                else
                {
                    query = query.OrderBy(orderByClause);
                }
            }
            else
            {
                // Ordenação padrão por Id se a entidade tiver uma propriedade Id
                var idProperty = typeof(TEntity).GetProperty("Id", System.Reflection.BindingFlags.IgnoreCase | System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.Instance);
                if (idProperty != null)
                {
                    query = query.OrderBy("Id");
                }
                // Se não houver Id e OrderBy não for especificado, não ordena
            }

            // A paginação será aplicada na camada de serviço
            return await Task.FromResult(query);
        }

        public virtual async Task<TEntity?> GetByIdAsync(int id)
        {
            return await _dbSet.FindAsync(id);
        }

        public virtual async Task AddAsync(TEntity entity)
        {
            await _dbSet.AddAsync(entity);
            await _context.SaveChangesAsync();
        }

        public virtual async Task UpdateAsync(TEntity entity)
        {
            _dbSet.Attach(entity);
            _context.Entry(entity).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }

        public virtual async Task DeleteAsync(int id)
        {
            var entity = await _dbSet.FindAsync(id);
            if (entity != null)
            {
                _dbSet.Remove(entity);
                await _context.SaveChangesAsync();
            }
        }

        // Método virtual para aplicar filtros específicos da entidade
        protected virtual IQueryable<TEntity> ApplyFilters(IQueryable<TEntity> query, TQueryParameters queryParameters)
        {
            // Implementação padrão não faz nada.
            // As classes derivadas irão sobrescrever para adicionar seus filtros.
            return query;
        }
    }
}