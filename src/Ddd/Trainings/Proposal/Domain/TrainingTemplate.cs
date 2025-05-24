using Ddd.Trainings.Idea.Domain;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain
{
    public class TrainingTemplate : BaseEntity<TemplateId>
    {
        public TemplateId Id { get; }
        public string Name { get; }
        public string Description { get; }
        public string[] Keywords { get; }

        public TrainingTemplate(TemplateId id, string name, string description, string[] keywords)
        {
            Id = id;
            Name = name;
            Description = description;
            Keywords = keywords;
        }

        public override TemplateId GetId()
        {
            return Id;
        }
    }
} 