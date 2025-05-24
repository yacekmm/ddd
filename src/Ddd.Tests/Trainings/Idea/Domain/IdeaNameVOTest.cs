using Ddd.Tests.Trainings.Tests;
using Ddd.Trainings.Idea.Domain;
using Xunit;

namespace Ddd.Tests.Trainings.Idea.Domain.Tests;

public class IdeaNameVOTest : TrainingTests
{
  

  [Fact]
  public void From_CreatesIdeaName_OnValidName()
  {
    // given
    string validName = "This is a valid idea name that meets the length requirements";

    // when
    IdeaNameVO ideaName = IdeaNameVO.From(validName);

    // then
    Assert.NotNull(ideaName);
    Assert.Equal(validName, ideaName.NameValue);
  }

  [Fact]
  public void From_ThrowsException_OnInvalidLengthName()
  {
    // expect
    Assert.Throws<ArgumentException>(() => IdeaNameVO.From(null!));
    Assert.Throws<ArgumentException>(() => IdeaNameVO.From("Too short"));
    Assert.Throws<ArgumentException>(() => IdeaNameVO.From(new string('a', 9)));
    Assert.Throws<ArgumentException>(() => IdeaNameVO.From(new string('A', 161)));
  }

  [Fact]
  public void GetKeywords_ReturnsKeywords_OnValidName()
  {
    // given
    string name = "Java Spring Boot Microservices";
    string[] ExpectedKeywords = ["Java", "Spring", "Boot", "Microservices"];
    IdeaNameVO ideaName = IdeaNameVO.From(name);

    // when
    string[] keywords = ideaName.Keywords;

    // then
    Assert.NotNull(keywords);
    Assert.Equal(4, keywords.Length);
    Assert.Equal(ExpectedKeywords, keywords);
  }
}