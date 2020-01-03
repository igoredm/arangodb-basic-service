package com.igoredm.arangodbbasicservice.model.repository;

import com.igoredm.arangodbbasicservice.model.entity.LogEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends BaseRepository<LogEntity> {
}
