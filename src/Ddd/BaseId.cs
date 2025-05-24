using System;

namespace Ddd.Utils
{
    public abstract class BaseId
    {
        // protected string Value;

        // protected BaseId(string value)
        // {
        //     Value = value;
        // }

        public abstract override bool Equals(object? obj);
    //     {
    //         if (obj is not BaseId other)
    //             return false;
    //         return Value.Equals(other.Value);
    //     }

        public abstract override int GetHashCode();
    //     {
    //         return Value.GetHashCode();
    //     }

        public abstract string GetValue();
    }
} 