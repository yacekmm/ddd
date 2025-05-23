using System;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain
{
    public class ProposalId(string value) : BaseId
    {
    public string Value { get; } = value;

    public static ProposalId Create()
        {
            return new ProposalId(Guid.NewGuid().ToString());
        }
    }
} 