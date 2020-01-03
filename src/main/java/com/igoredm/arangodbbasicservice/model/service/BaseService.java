package com.igoredm.arangodbbasicservice.model.service;

import com.igoredm.arangodbbasicservice.model.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService<T> {

    @Autowired
    private BaseRepository<T> repository;

    public Iterable<T> findAll() {
        return repository.findAll() ;
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteAll() { repository.deleteAll(); }
}
