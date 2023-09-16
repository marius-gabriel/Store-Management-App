package org.mystore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppAliveController {
    private static final String PATH = "/ping";

    @GetMapping(value = PATH)
    public String getAppHealthStatus(){
        return "Pong";
    }
}
