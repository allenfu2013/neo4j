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
                String[] val = line.split(",");
                Person person = createPerson(val[0], val[1], val[2], val[3], val[4]);
//                persons.add(person);
                personRepository.save(person);
            }

//            personRepository.save(persons);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Person createPerson(String name, String idCard, String mobile, String address, String education) {
        Person person = new Person();
        person.setName(name);
        person.setIdCard(idCard);
        person.setMobile(mobile);
        person.setAge(IdCardUtil.getAge(person.getIdCard()));
        person.setAddress(address);
        person.setEducation(education);
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
