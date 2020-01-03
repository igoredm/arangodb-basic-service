package com.igoredm.arangodbbasicservice.model.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface BaseRepository<T> extends ArangoRepository<T, String> {
}
