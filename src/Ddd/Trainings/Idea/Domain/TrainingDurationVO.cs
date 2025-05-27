namespace Ddd.Trainings.Idea.Domain
{
    public class TrainingDurationVO(int days)
  {
    public int Days { get; } = days;

    public static TrainingDurationVO From(int days)
        {
            //TODO: Implement validation of number of days (Value Object?)
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