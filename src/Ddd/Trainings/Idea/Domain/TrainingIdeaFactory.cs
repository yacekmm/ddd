namespace Ddd.Trainings.Idea.Domain
{
    public static class TrainingIdeaFactory
    {
        public static TrainingIdea Create(string trainerId, string name)
        {
            IdeaNameVO ideaName = IdeaNameVO.From(name);
            IdeaId ideaId = IdeaId.Create();
            TrainerId trainerIdVO = TrainerId.From(trainerId);
            return new TrainingIdea(ideaId, trainerIdVO, ideaName, TrainingDurationVO.Empty());
        }
    }
} 