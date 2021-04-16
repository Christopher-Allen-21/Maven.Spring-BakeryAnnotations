package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.repositories.MuffinRepository;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MuffinController {

    private MuffinService service;
    private MuffinRepository muffinRepository;

    public MuffinController(MuffinService service) {
        this.service = service;
    }

    // COMMAND: http://localhost:8090/muffin        //gets all muffins
    @GetMapping("/muffin")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    // COMMAND: http://localhost:8090/muffin/3          //gets muffin with id=3
    //@RequestMapping(value = "/muffin/{id}",method = RequestMethod.GET)
    @GetMapping("/muffin/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    // COMMAND: http://localhost:8090/muffin?flavor=chocolate       //creates muffin with flavor=chocolate
    //@RequestMapping(value = "/muffin",method = RequestMethod.POST)
    @PostMapping("/muffin")
    public ResponseEntity<Muffin> create(Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    // COMMAND: http://localhost:8090/muffin/2?flavor=vanilla       //changes flavor of muffin with id=2 to vanilla
    @PutMapping("/muffin/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id, Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);

    }

    // COMMAND: http://localhost:8090/muffin/3          //deletes muffin with id=3
    @DeleteMapping("/muffin/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
