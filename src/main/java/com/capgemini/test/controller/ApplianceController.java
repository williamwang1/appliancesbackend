package com.capgemini.test.controller;


import com.capgemini.test.domain.Appliances;
import com.capgemini.test.domain.Greeting;
import com.capgemini.test.repository.AppliancesRepo;
import com.sun.tools.javac.util.StringUtils;
import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/appliances")
public class ApplianceController {


    @Autowired
    AppliancesRepo repo;

    @GetMapping
    public ResponseEntity<List<Appliances>> findAll() {
        List<Appliances> result = repo.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appliances> findById(@PathVariable String id) {
        Long idLong = Long.parseLong(id);
        Optional<Appliances> a = repo.findById(idLong);
        return new ResponseEntity<>(a.get(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String query) {
//        List<Appliances> result = new ArrayList<>();
//        List<Appliances> list1 = repo.findBySerialNumberIgnoreCase(query);
//        result.addAll(list1);
//        List<Appliances> list2 = repo.findByBrandIgnoreCase(query);
//        result.addAll(list2);
//        List<Appliances> list3 = repo.findByModelIgnoreCase(query);
//        result.addAll(list3);
        if (query != null && query != "") {
            query = StringUtils.toLowerCase(query);
        }
        List<Appliances> result = repo.searchByKeywaord(query);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAppliance (@RequestBody @Valid Form form) {
        Appliances a = convertFormToAppliacnes(form);
        List<Appliances> existing = repo.findBySerialNumberAndBrandAndModel(form.getSerial_number(), form.getBrand(), form.getModel());
        if (existing != null && existing.size() > 0) {
            return new ResponseEntity<>("Appliance exist", HttpStatus.BAD_REQUEST);
        }
        a = repo.save(a);
        return new ResponseEntity<>(a.getId(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateAppliance(@RequestParam String id, @RequestBody @Valid Form form) {
       Long idint = Long.parseLong(id);
        Optional<Appliances> a = repo.findById(idint);
       if (!a.isPresent()) {
           return new ResponseEntity<>("Appliance not found", HttpStatus.BAD_REQUEST);
       }
        Appliances _a = a.get();
        //Appliances newa = convertFormToAppliacnes(form);
        if (form.getSerial_number() != null && form.getSerial_number() != "") {
            _a.setSerialNumber(form.getSerial_number());
        }

        if (form.getModel() != null && form.getModel() != "") {
            _a.setModel(form.getModel());
        }
        if (form.getBrand() != null && form.getBrand() != "") {
            _a.setBrand(form.getBrand());
        }
        if (form.getDate_bought() != null) {
            _a.setDateBought(form.getDate_bought());
        }
        if (form.getStatus() != null && form.getStatus() != "") {
            _a.setStatus(form.getStatus());
        }
        repo.save(_a);

       return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAppliance (@RequestParam String id) {
        Long idLong = Long.parseLong(id);
        Optional<Appliances> a = repo.findById(idLong);
        if (!a.isPresent()) {
            return new ResponseEntity<>("Appliance not found", HttpStatus.BAD_REQUEST);
        }
        repo.deleteById(idLong);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    public Appliances convertFormToAppliacnes (Form form) {
        Appliances a = new Appliances();
        a.setSerialNumber(form.getSerial_number());
        a.setBrand(form.getBrand());
        a.setDateBought(form.getDate_bought());
        a.setModel(form.getModel());
        a.setStatus(form.getStatus());
        return a;
    }
}




