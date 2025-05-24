using System.Collections.Generic;

namespace Ddd.Utils;

public interface IBaseRepo<T, TId> where T : BaseEntity<TId> where TId : BaseId
{
    T Save(T entity);
    T? FindById(TId id);
    void Delete(TId id);
    IEnumerable<T> FindAll();
} 