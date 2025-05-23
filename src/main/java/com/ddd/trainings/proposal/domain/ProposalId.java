package com.ddd.trainings.proposal.domain;

import com.ddd.utils.BaseId;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "value", callSuper = false)
public class ProposalId extends BaseId {

  @Getter
  private final String value;

  public ProposalId(String value) {
    this.value = value;
  }

  public static ProposalId create() {
    return new ProposalId(UUID.randomUUID().toString());
  }
}
