package org.allen.neo4j.service;

import org.allen.neo4j.domain.HomeCity;
import org.allen.neo4j.domain.Person;
import org.allen.neo4j.repositories.HomeCityRepository;
import org.allen.neo4j.repositories.PersonRepository;
import org.allen.neo4j.utils.IdCardUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    HomeCityRepository homeCityRepository;

    public void init() {
        try {
            File file = ResourceUtils.getFile("classpath:person.csv");
            List<String> lines = FileUtils.readLines(file, Charset.forName("UTF-8"));
            List<Person> persons = new ArrayList<>();
            for (String line : lines) {
                Person person = createPerson(line);
//                persons.add(person);
                personRepository.save(person);
            }

//            personRepository.save(persons);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Person createPerson(String line) {
        String[] val = line.split(",");
        Person person = new Person();
        person.setName(val[0]);
        person.setIdCard(val[1]);
        person.setMobile(val[2]);
        person.setAge(IdCardUtil.getAge(person.getIdCard()));
        person.setAddress(val[3]);
        person.setEducation(val[4]);
        person.setSex(IdCardUtil.getSex(person.getIdCard()));

        String cityCode = IdCardUtil.getCityCode(person.getIdCard());
        HomeCity homeCity = homeCityRepository.getHomeCity(cityCode);
        if (homeCity == null) {
            homeCity = new HomeCity();
            homeCity.setName(person.getAddress());
            homeCity.setCityCode(cityCode);
        }
        person.setHomeCity(homeCity);
        return person;
    }


}
