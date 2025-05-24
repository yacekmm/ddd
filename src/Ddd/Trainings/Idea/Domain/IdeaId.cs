using System;
using Ddd.Utils;

namespace Ddd.Trainings.Idea.Domain;

public class IdeaId(string value) : BaseId
{
    private readonly string _value = value;

    public static IdeaId Create()
    {
        return new IdeaId(Guid.NewGuid().ToString());
    }

    public static IdeaId From(string ideaId)
    {
        return new IdeaId(ideaId);
    }

  public override bool Equals(object? obj)
  {
    return obj is IdeaId id &&
           _value == id._value;
  }

  public override string GetValue()
    {
        return _value;
    }

  public override int GetHashCode()
  {
    return HashCode.Combine(_value);
  }
} 