using System;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain
{
    public class ProposalId(string value) : BaseId
    {
    private readonly string _value = value;

    public static ProposalId Create()
        {
            return new ProposalId(Guid.NewGuid().ToString());
        }

    public override bool Equals(object? obj)
    {
      return obj is ProposalId id &&
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