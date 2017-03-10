package org.allen.neo4j.controller;

import org.allen.neo4j.repositories.HomeCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home-city")
public class HomeCityController {

    @Autowired
    HomeCityRepository homeCityRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Object findAll() {
        return homeCityRepository.findAll();
    }

    @RequestMapping(value = "/{cityCode}", method = RequestMethod.GET)
    public Object findByCode(@PathVariable String cityCode) {
        return homeCityRepository.getHomeCity(cityCode);
    }
}
