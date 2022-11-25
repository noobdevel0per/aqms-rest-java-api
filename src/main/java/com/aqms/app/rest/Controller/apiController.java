package com.aqms.app.rest.Controller;
import com.aqms.app.rest.Models.data;
import com.aqms.app.rest.Repo.dataRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;


@RestController
public class apiController {
    @Autowired
    private dataRepo dataRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome to the AQMS API";
    }

    //get list of data stored
    @GetMapping(value = "/data")
    public List<data> getData(){
        return dataRepo.findAll();
    }

    //get data with specific id
    @GetMapping(value = "/data/{id}")
    public Optional<data> getFilteredData(@PathVariable("id")Long id){
       return  dataRepo.findById(id);
    }

    //to post the data in API
    @PostMapping(value = "/save")
    public String saveData(@RequestBody data data){
        dataRepo.save(data);
        return "Data Saved✔";
    }


}

