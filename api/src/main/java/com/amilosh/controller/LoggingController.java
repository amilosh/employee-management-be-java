package com.amilosh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/logging")
public class LoggingController {

    @GetMapping()
    public void createEmployee() {
        log.debug("debug level");
        log.info("info level");
        log.warn("warn level");
        log.error("error level");
    }
}
