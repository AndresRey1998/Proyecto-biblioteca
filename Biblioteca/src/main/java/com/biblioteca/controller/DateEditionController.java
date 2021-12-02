package com.biblioteca.controller;

import com.biblioteca.entity.Book;
import com.biblioteca.entity.DateEdition;
import com.biblioteca.service.api.BookServiceAPI;
import com.biblioteca.service.api.DateEditionServiceAPI;
import com.biblioteca.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081/", "http://localhost:3000/"} ,maxAge = 3600, methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,})
@RestController
@RequestMapping("/date")
public class DateEditionController {
    @Autowired
    private DateEditionServiceAPI dateEditionServiceAPI;

    @GetMapping(value="/getAll")
    public List<DateEdition> getAll(){
        return dateEditionServiceAPI.getAll();
    }

    @PostMapping(value="/saveDateEdition")
    public ResponseEntity<DateEdition> save(@RequestBody DateEdition dateEdition){
        DateEdition obj = dateEditionServiceAPI.save(dateEdition);
        return new ResponseEntity<DateEdition>(obj, HttpStatus.OK); // 200
    }

    @PutMapping(value="update-record/{id}")
    public ResponseEntity<DateEdition> updateDateEdition(@RequestBody DateEdition dateEdition, @PathVariable("id") int id) {
        dateEdition.setId(id);
        DateEdition obj = dateEditionServiceAPI.save(dateEdition);
        return new ResponseEntity<DateEdition>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<DateEdition> getDateEditionById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        DateEdition dateEdition = dateEditionServiceAPI.get(id);
        if (dateEdition == null){
            new ResourceNotFoundException("Record not found for <DateEdition>"+id);
        }
        return ResponseEntity.ok().body(dateEdition);
    }

    @DeleteMapping(value="/deleteDateEdition/{id}")
    public ResponseEntity<DateEdition> delete(@PathVariable Integer id){
        DateEdition dateEdition = dateEditionServiceAPI.get(id);
        if (dateEdition != null){
            dateEditionServiceAPI.delete(id);
        }else{
            return new ResponseEntity<DateEdition>(dateEdition, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<DateEdition>(dateEdition, HttpStatus.OK);
    }
}
