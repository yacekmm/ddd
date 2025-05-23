using System;
using Ddd.Utils;

namespace Ddd.Trainings.Idea.Domain;

public class IdeaId(string value) : BaseId
{
    public string Value { get; } = value;

    public static IdeaId Create()
    {
        return new IdeaId(Guid.NewGuid().ToString());
    }

    public static IdeaId From(string ideaId)
    {
        return new IdeaId(ideaId);
    }
} 