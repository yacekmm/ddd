namespace Ddd.Trainings.Idea.Domain
{
    public class IdeaNameVO(string nameValue)
  {
    public string NameValue { get; } = nameValue;

    public static IdeaNameVO From(string name)
        {
            if (string.IsNullOrEmpty(name) || name.Length < 10 || name.Length > 160)
            {
                throw new ArgumentException("Name must be at least 10 characters long");
            }
            return new IdeaNameVO(name);
        }

        public string[] Keywords => NameValue.Split(' ');
    }
} 