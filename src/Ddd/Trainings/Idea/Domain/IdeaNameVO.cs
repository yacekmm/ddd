namespace Ddd.Trainings.Idea.Domain
{
    public class IdeaNameVO(string nameValue)
  {
    public string NameValue { get; } = nameValue;

    public static IdeaNameVO From(string name)
        {
            //TODO: Implement validation of idea name
            return new IdeaNameVO(name);
        }

        public string[] Keywords => NameValue.Split(' ');
    }
} 