using System.Collections.Generic;

namespace Ddd.Utils;

public abstract class BaseRepo<T, TId> : IBaseRepo<T, TId> where T : BaseEntity<TId> where TId : BaseId
{
    protected readonly Dictionary<TId, T> _entities = [];

    public virtual T Save(T entity)
    {
        _entities[entity.GetId()] = entity;
        return entity;
    }

    public virtual T? FindById(TId id)
    {
        return _entities.TryGetValue(id, out var entity) ? entity : null;
    }

    public virtual void Delete(TId id)
    {
        _entities.Remove(id);
    }

    public virtual IEnumerable<T> FindAll()
    {
        return _entities.Values;
    }

    public virtual int Count()
    {
        return _entities.Count;
    }
} 