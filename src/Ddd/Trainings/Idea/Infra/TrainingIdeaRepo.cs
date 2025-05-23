using System.Collections.Generic;
using Ddd.Trainings.Idea.Domain;

namespace Ddd.Trainings.Idea.Infra
{
    public interface ITrainingIdeaRepo
    {
        TrainingIdea Save(TrainingIdea idea);
        List<TrainingIdea> FindAll();
        TrainingIdea FindById(IdeaId ideaId);
    }
} 