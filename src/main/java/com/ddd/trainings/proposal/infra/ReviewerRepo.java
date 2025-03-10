package com.ddd.trainings.proposal.infra;

import com.ddd.trainings.proposal.domain.Reviewer;
import com.ddd.trainings.proposal.domain.ReviewerId;
import com.ddd.utils.BaseRepo;
import java.util.List;

public interface ReviewerRepo extends BaseRepo<Reviewer, ReviewerId> {

  List<Reviewer> findByKeywordsOrderByCurrentReviewsCount(String[] value);
}
