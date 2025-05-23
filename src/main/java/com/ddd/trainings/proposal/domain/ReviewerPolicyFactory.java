package com.ddd.trainings.proposal.domain;

import com.ddd.trainings.idea.domain.IdeaNameVO;
import com.ddd.trainings.proposal.infra.ReviewerRepo;
import java.util.List;
import java.util.Random;
import org.jmolecules.ddd.annotation.Factory;

@Factory
public class ReviewerPolicyFactory {

  private final ReviewerRepo reviewerRepo;
  private final Random random = new Random();

  public ReviewerPolicyFactory(ReviewerRepo reviewerRepo) {
    this.reviewerRepo = reviewerRepo;
  }

  public ReviewerPolicy byKeywords(IdeaNameVO name) {
    return new ReviewerPolicy() {
      @Override
      public ReviewerId selectReviewer() {
        List<Reviewer> candidates = reviewerRepo.findByKeywordsOrderByCurrentReviewsCount(name.getKeywords());
        return candidates.stream()
            .map(Reviewer::getId)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No available reviewers"));
      }
    };
  }

  public ReviewerPolicy random() {
    return new ReviewerPolicy() {
      @Override
      public ReviewerId selectReviewer() {
        List<Reviewer> candidates = reviewerRepo.findAll();
        if (candidates.isEmpty()) {
          throw new RuntimeException("No available reviewers");
        }

        int randomIndex = random.nextInt(candidates.size());

        return candidates.get(randomIndex).getId();
      }
    };
  }

}