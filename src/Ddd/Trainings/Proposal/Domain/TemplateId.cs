using System;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain
{
    public class TemplateId(string value) : BaseId
    {
    private readonly string _value = value;

    public static TemplateId Create()
        {
            return new TemplateId(Guid.NewGuid().ToString());
        }

    public override bool Equals(object? obj)
    {
      return obj is TemplateId id &&
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
} 