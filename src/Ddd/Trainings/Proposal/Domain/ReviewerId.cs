using System;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain;

public class ReviewerId(string value) : BaseId
{
    public string Value { get; } = value;

    public static ReviewerId Create()
    {
        return new ReviewerId(Guid.NewGuid().ToString());
    }
} 