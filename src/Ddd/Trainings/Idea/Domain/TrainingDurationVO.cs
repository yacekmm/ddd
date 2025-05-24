namespace Ddd.Trainings.Idea.Domain
{
    public class TrainingDurationVO(int days)
  {
    public int Days { get; } = days;

    public static TrainingDurationVO From(int days)
        {
            if (days < 1 || days > 5)
            {
                throw new ArgumentException("Training duration must be between 1 and 5 days");
            }
            return new TrainingDurationVO(days);
        }

        public static TrainingDurationVO Empty()
        {
            return new TrainingDurationVO(0);
        }

        public bool IsEmpty()
        {
            return Days == 0;
        }
    }
} 