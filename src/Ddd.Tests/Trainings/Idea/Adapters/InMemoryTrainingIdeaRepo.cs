using System.Collections.Generic;
using System.Linq;
using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Idea.Domain.Ports;
using Ddd.Utils;

namespace Ddd.Tests.Trainings.Idea.Infra.Tests;

public class InMemoryTrainingIdeaRepo : BaseRepo<TrainingIdea, IdeaId>, ITrainingIdeaRepo
{
  public override List<TrainingIdea> FindAll()
  {
    return base.FindAll().ToList();
  }
}