package org.allen.neo4j.controller;

import org.allen.neo4j.repositories.PersonRepository;
import org.allen.neo4j.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public Object init() {
        personService.init();
        Map<String, Object> ret = new HashMap<>();
        ret.put("retCode", 0);
        return ret;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Long id) {
        personRepository.delete(id);
        Map<String, Object> ret = new HashMap<>();
        ret.put("retCode", 0);
        return ret;
    }

    @RequestMapping(value = "/black", method = RequestMethod.GET)
    public Object black(@RequestParam String type) {
        return personRepository.findBlack(type);
    }

    @RequestMapping(value = "/first-black", method = RequestMethod.GET)
    public Object firstBlack() {
        return personRepository.findFirstBlack();
    }
}
