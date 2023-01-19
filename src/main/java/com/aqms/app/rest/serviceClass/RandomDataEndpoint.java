package com.aqms.app.rest.serviceClass;
import com.aqms.app.rest.Models.data;

import org.json.simple.JSONObject;

import java.util.Random;

import javax.transaction.Transactional;

import com.aqms.app.rest.Repo.dataRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RandomDataEndpoint {
    @Autowired
    private  dataRepo dRepo;

    public void randomDataGeneration() {
        Random random = new Random();
        int minFloor =1;
        int maxFloor =3;
        //generating random inputs for floor and air concentration
        String randomFloor = String.valueOf(random.nextInt((maxFloor-minFloor)+1)+minFloor);

        JSONObject body = new JSONObject();
        body.put("floor",randomFloor);
        body.put("co2",String.valueOf(random.nextInt(100)));
        body.put("c",String.valueOf(random.nextInt(100)));
        body.put("co",String.valueOf(random.nextInt(100)));
        body.put("so2",String.valueOf(random.nextInt(100)));
        body.put("o2",String.valueOf(random.nextInt(100)));
        postDataServiceImpl(body);

    }

    public data postDataServiceImpl(JSONObject aqmsData) {
        String o2 = String.valueOf(aqmsData.get("o2"));
    
        Long O2_val = Long.parseLong(o2);

        String co2 = String.valueOf(aqmsData.get("co2"));
        Long co2_val = Long.parseLong(co2);

        String so2 = String.valueOf(aqmsData.get("so2"));
        Long so2_val = Long.parseLong(so2);

        String c = String.valueOf(aqmsData.get("c"));
        Long c_val = Long.parseLong(c);

        String co = String.valueOf(aqmsData.get("co"));
        Long co_val = Long.parseLong(co);

        String floor = String.valueOf(aqmsData.get("floor"));
        Integer floor_val = Integer.parseInt(floor);

        long airQuality = ((co2_val+so2_val+so2_val+co_val+c_val)-O2_val)/2;
        data newData = new data(O2_val,co2_val,so2_val,co_val,c_val,floor_val,airQuality);

        return dRepo.save(newData);
    }

}