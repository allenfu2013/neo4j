package org.allen.neo4j.controller;

import org.allen.neo4j.domain.BlackType;
import org.allen.neo4j.repositories.BlackTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/black-type")
public class BlackTypeController {

    @Autowired
    BlackTypeRepository blackTypeRepository;

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public Object init() {
        blackTypeRepository.save(initData());
        Map<String, Object> ret = new HashMap<>();
        ret.put("retCode", 0);
        return ret;
    }

    private List<BlackType> initData() {
        BlackType blackType1 = new BlackType();
        blackType1.setName("法院失信");
        blackType1.setType("Court_Dishonesty");

        BlackType blackType2 = new BlackType();
        blackType2.setName("老赖");
        blackType2.setType("Dead_Beat");

        BlackType blackType3 = new BlackType();
        blackType3.setName("多头借贷");
        blackType3.setType("Multiple_Lending");

        List<BlackType> blackTypes = new ArrayList<>();
        blackTypes.add(blackType1);
        blackTypes.add(blackType2);
        blackTypes.add(blackType3);

        return blackTypes;
    }
}
