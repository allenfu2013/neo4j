package org.allen.neo4j.common;

import org.allen.neo4j.domain.HomeCity;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CityLoader {

    public Map<String, HomeCity> cityMap = new HashMap<>();

    @PostConstruct
    private void init() {
        try {
            File file = ResourceUtils.getFile("classpath:city.txt");
            List<String> lines = FileUtils.readLines(file, Charset.forName("UTF-8"));
            for (String line : lines) {
                HomeCity homeCity = buildCity(line);
                cityMap.put(homeCity.getCityCode(), homeCity);
            }
            System.out.println("init city finished, size:" + cityMap.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HomeCity buildCity(String line) {
        line = line.replace((char) 12288, ' ').trim();
        String cityCode = line.substring(0, 6);
        String name = line.substring(6).trim();
        HomeCity homeCity = new HomeCity();
        homeCity.setCityCode(cityCode);
        homeCity.setName(name);
        return homeCity;
    }
}
