package com.ecom.plantopia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.plantopia.model.Plantmodel;
import com.ecom.plantopia.repository.Plantrepository;

import java.util.*;

@RequestMapping("/api")
@RestController
public class Plantcontroller {

    @Autowired
    Plantrepository myrepository;
  
  
   @PostMapping("/plants")
    public ResponseEntity<Plantmodel> createTutorial(@RequestBody Plantmodel model) {
      try {
        Plantmodel _tutorial = myrepository.save(new Plantmodel(model.getPlantname(), model.getDescription(), model.getPrice()));
        return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    @GetMapping("/plants")
    public List<Plantmodel> getTutorial()
    {
      return myrepository.findAll();
    }
    @PutMapping("/plants/{id}")
    public ResponseEntity<Plantmodel> updateExpenses(@PathVariable("id") long id, @RequestBody Plantmodel model) {
    Optional<Plantmodel> expData = myrepository.findById(id);

    if (expData.isPresent()) {
      Plantmodel exp = expData.get();
      exp.setPlantname(model.getPlantname());
      exp.setDescription(model.getDescription());
      exp.setPrice(model.getPrice());
      return new ResponseEntity<>(myrepository.save(exp), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

    @DeleteMapping("/plants/{id}")
    public ResponseEntity<HttpStatus> deleteExpenses(@PathVariable("id") long id) {
      try {
        myrepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


}
