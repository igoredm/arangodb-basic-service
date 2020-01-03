package com.igoredm.arangodbbasicservice.controller;

import com.igoredm.arangodbbasicservice.model.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Primary
public class BaseController<T> {
    @Autowired
    private BaseService<T> service;

    @GetMapping()
    public Iterable<T> findAll() {
        return service.findAll();
    }
}
