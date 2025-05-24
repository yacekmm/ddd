using System;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain;

public class ReviewerId(string value) : BaseId
{
    private readonly string _value = value;

    public static ReviewerId Create()
    {
        return new ReviewerId(Guid.NewGuid().ToString());
    }

  public override bool Equals(object? obj)
  {
    return obj is ReviewerId id &&
           _value == id._value;
  }

  public override int GetHashCode()
  {
    return HashCode.Combine(_value);
  }

  public override string GetValue()
    {
        return _value;
    }
} 