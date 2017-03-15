package org.allen.neo4j.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PingController {

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public Object ping() {
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "neo4j-demo is running...");
        return response;
    }
}
