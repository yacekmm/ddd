using System;

namespace Ddd.Utils
{
    public abstract class BaseEntity<TId> where TId : BaseId
    {
        public abstract TId GetId();

        public override bool Equals(object? obj)
        {
            if (obj is not BaseEntity<TId> other)
                return false;
            return GetId().Equals(other.GetId());
        }

        public override int GetHashCode()
        {
            return GetId().GetHashCode();
        }

        public override string ToString()
        {
            return $"{GetType().Name} [Id={{GetId()}}]";
        }
    }
} 