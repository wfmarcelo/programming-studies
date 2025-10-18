// AutoMapperApp.Application/ViewModels/PaginatedResponse.cs
namespace AutoMapperApp.Application.ViewModels
{
    public class PaginatedResponse<T> where T : class // Adicione esta restrição genérica
    {
        public int CurrentPage { get; set; }
        public int TotalPages { get; set; }
        public int PageSize { get; set; }
        public int TotalCount { get; set; }
        public bool HasPrevious { get; set; }
        public bool HasNext { get; set; }
        public List<T> Items { get; set; } = new List<T>();

        public PaginatedResponse(PagedList<T> pagedList)
        {
            CurrentPage = pagedList.CurrentPage;
            TotalPages = pagedList.TotalPages;
            PageSize = pagedList.PageSize;
            TotalCount = pagedList.TotalCount;
            HasPrevious = pagedList.HasPrevious;
            HasNext = pagedList.HasNext;
            Items = pagedList.ToList(); // PagedList herda de List<T>
        }
    }
}