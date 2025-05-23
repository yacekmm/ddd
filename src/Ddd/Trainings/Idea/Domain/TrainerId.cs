namespace Ddd.Trainings.Idea.Domain;

public class TrainerId(string value)
{
    public string Value { get; } = value;

    public static TrainerId From(string value) => new(value);

    public override bool Equals(object? obj)
    {
        if (obj is not TrainerId other)
            return false;
        return Value == other.Value;
    }

    public override int GetHashCode() => Value.GetHashCode();
} 