package com.ddd.utils;

import java.util.List;
import java.util.Optional;

public interface BaseRepo<E, ID> {

  <S extends E> S save(S entity);

  Optional<E> findById(ID id);

  List<E> findAll();

  int count();
}
