package com.ddd.trainings.domain;

import com.ddd.trainings.api.app.Error;
import com.ddd.utils.Result;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class IdeaNameVO {

  private final String nameValue;

  public IdeaNameVO(String nameValue) {
    this.nameValue = nameValue;
  }

  public static Result<Error, IdeaNameVO> from(String name) {
    if(name == null || name.length() < 10 || name.length() > 160) {
      return Result.error("Name must be at least 10 characters long");
    } else {
      return Result.success(new IdeaNameVO(name));
    }
  }

  public String getValue() {
    return nameValue;
  }
}
