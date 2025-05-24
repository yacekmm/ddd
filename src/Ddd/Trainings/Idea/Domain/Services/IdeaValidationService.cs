using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ddd.Trainings.Idea.Domain.Services
{
    public class IdeaValidationService
    {
        public static void ValidateEdit(TrainingIdea idea)
        {
            if (idea.IsProposed)
            {
                throw new InvalidOperationException("Cannot edit duration of proposed idea");
            }
        }
    }
}