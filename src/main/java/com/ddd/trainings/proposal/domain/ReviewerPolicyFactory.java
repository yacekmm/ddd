package com.ddd.trainings.proposal.domain;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import com.ddd.trainings.idea.domain.IdeaNameVO;
import com.ddd.trainings.proposal.infra.ReviewerRepo;
import java.util.List;
import org.jmolecules.ddd.annotation.Factory;

@Factory
public class ReviewerPolicyFactory {

  private final ReviewerRepo reviewerRepo;

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

        int randomIndex = nextInt(0, candidates.size());

        return candidates.get(randomIndex).getId();
      }
    };
  }

}