package com.ddd.utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public abstract class BaseEntity {

  public abstract BaseId getId();
}
