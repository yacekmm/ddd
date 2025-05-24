using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;
using Ddd.Tests.Trainings.Proposal.Infra.Tests;
using Xunit;
using Ddd.Tests.Trainings.Tests;

namespace Ddd.Tests.Trainings.Proposal.Domain;

public class ByKeywordsReviewerPolicyTests: TrainingTests
{
    private readonly InMemoryReviewerRepo _reviewerRepo;
    private readonly IdeaNameVO _ideaName;
    private readonly ByKeywordsReviewerPolicy _policy;

    public ByKeywordsReviewerPolicyTests()
    {
        _reviewerRepo = new InMemoryReviewerRepo();
        _ideaName = IdeaNameVO.From("Test Idea long enough");
        _policy = new ByKeywordsReviewerPolicy(_reviewerRepo, _ideaName);
    }

    [Fact]
    public void SelectReviewer_WhenReviewerWithMatchingKeywords_ReturnsReviewerId()
    {
        // Arrange
        var reviewer = new Reviewer(new ReviewerId("reviewer1"), "John Doe", new[] { "long" });
        _reviewerRepo.Save(reviewer);

        // Act
        var result = _policy.SelectReviewer();

        // Assert
        Assert.Equal(reviewer.Id, result);
    }

    [Fact]
    public void SelectReviewer_WhenNoReviewersAvailable_ThrowsException()
    {
        // Act & Assert
        Assert.Throws<Exception>(() => _policy.SelectReviewer());
    }

    [Fact]
    public void SelectReviewer_WhenReviewerWithNoMatchingKeywords_ThrowsException()
    {
        // Arrange
        var reviewer = new Reviewer(new ReviewerId("reviewer1"), "John Doe", new[] { "unrelated" });
        _reviewerRepo.Save(reviewer);

        // Act & Assert
        Assert.Throws<Exception>(() => _policy.SelectReviewer());
    }

    [Fact]
    public void SelectReviewer_WhenMultipleReviewersAvailable_ReturnsReviewerWithLeastReviews()
    {
        // Arrange
        var reviewer1 = new Reviewer(new ReviewerId("reviewer1"), "John Doe", new[] { "idea" });
        var reviewer2 = new Reviewer(new ReviewerId("reviewer2"), "Jane Smith", new[] { "idea" });
        reviewer1.IncrementReviewsCount(); // reviewer1 has 1 review
        reviewer2.IncrementReviewsCount(); // reviewer2 has 1 review
        reviewer2.IncrementReviewsCount(); // reviewer2 has 2 reviews
        _reviewerRepo.Save(reviewer1);
        _reviewerRepo.Save(reviewer2);

        // Act
        var result = _policy.SelectReviewer();

        // Assert
        Assert.Equal(reviewer1.Id, result); // reviewer1 should be selected as they have fewer reviews
    }
} 