package com.ddd.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepo<E extends BaseEntity, ID extends BaseId>
    implements BaseRepo<E, ID> {

  protected Map<BaseId, E> database = new HashMap<>();

  @Override
  public <S extends E> S save(S entity) {
    BaseId id = entity.getId();
    database.put(id, entity);
    return entity;
  }

  @Override
  public Optional<E> findById(ID id) {
    return Optional.ofNullable(database.get(id));
  }


  @Override
  public List<E> findAll() {
    return database.values().stream().toList();
  }

  @Override
  public int count() {
    return database.size();
  }

}
