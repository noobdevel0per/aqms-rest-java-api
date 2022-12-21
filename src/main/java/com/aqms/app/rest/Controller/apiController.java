package com.aqms.app.rest.Controller;
import com.aqms.app.rest.Exception.ResourceNotFoundException;
import com.aqms.app.rest.Models.data;
import com.aqms.app.rest.Repo.dataRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    // get data by id
    @GetMapping("/data/{id}")
    public ResponseEntity<data> getFilteredData(@PathVariable Long id) {
        data dataSet = dataRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no data with id " + id));
        return ResponseEntity.ok(dataSet);
    }

    //to post the data in API
    @PostMapping(value = "/save")
    public String saveData(@RequestBody data data){
        dataRepo.save(data);
        return "Data Saved✔";
    }


}

