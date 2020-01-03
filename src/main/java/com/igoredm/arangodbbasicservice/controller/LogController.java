package com.igoredm.arangodbbasicservice.controller;

import com.igoredm.arangodbbasicservice.model.entity.LogEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController extends BaseController<LogEntity> {
}
