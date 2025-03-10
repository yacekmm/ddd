package com.ddd.trainings.infra;

import com.ddd.trainings.proposal.domain.Reviewer;
import com.ddd.trainings.proposal.domain.ReviewerId;
import com.ddd.trainings.proposal.infra.ReviewerRepo;
import com.ddd.utils.InMemoryRepo;
import java.util.List;

public class InMemoryReviewerRepo
    extends InMemoryRepo<Reviewer, ReviewerId>
    implements ReviewerRepo {

  @Override
  public List<Reviewer> findByKeywordsOrderByCurrentReviewsCount(String[] value) {
    //not really accurate, but let's leave it for later
    return database.values().stream().toList();
  }
}
