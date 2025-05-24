using Ddd.Trainings.Idea.Api.App;
using Microsoft.AspNetCore.Mvc;

namespace Ddd.Trainings.Idea.Api.Http
{
    [ApiController]
    [Route("training/ideas")]
    public class TrainingIdeaRestController : ControllerBase
    {
        private readonly TrainingIdeaService _service;

        public TrainingIdeaRestController(TrainingIdeaService service)
        {
            _service = service;
        }

        [HttpPost]
        public IActionResult CreateTrainingIdea(string trainerId, string name)
        {
            _service.CreateTrainingIdea(trainerId, name);
            return Ok();
        }

        [HttpPost("{ideaId}/propose")]
        public IActionResult ProposeTrainingIdea(string ideaId)
        {
            _service.ProposeIdea(ideaId);
            return Ok();
        }
    }
} 