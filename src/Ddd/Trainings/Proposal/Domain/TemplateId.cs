using System;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain
{
    public class TemplateId(string value) : BaseId
    {
    public string Value { get; } = value;

    public static TemplateId Create()
        {
            return new TemplateId(Guid.NewGuid().ToString());
        }

    }
} 