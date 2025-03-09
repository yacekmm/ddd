package com.ddd.utils;

import com.ddd.trainings.api.app.Error;

public class Result<E, S> {
  private final E error;
  private final S success;

  private Result(E error, S success) {
    this.error = error;
    this.success = success;
  }

  public static <E, S> Result<Error, S> error(String errMsg) {
    return new Result<>(new Error(errMsg), null);
  }

  public static <E, S> Result<Error, S> error(Error error) {
    return Result.error(error.getMessage());
  }

  public static <E, S> Result<E, S> success(S success) {
    return new Result<>(null, success);
  }

  public E getError() {
    return error;
  }

  public S getSuccess() {
    return success;
  }

  public boolean isSuccess() {
    return success != null;
  }

  public boolean isError() {
    return error != null;
  }
}