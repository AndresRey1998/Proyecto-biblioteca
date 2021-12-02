package com.biblioteca.controller;

import com.biblioteca.entity.Book;
import com.biblioteca.entity.Editorial;
import com.biblioteca.service.api.BookServiceAPI;
import com.biblioteca.service.api.EditorialServiceAPI;
import com.biblioteca.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081/", "http://localhost:3000/"} ,maxAge = 3600, methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,})
@RestController
@RequestMapping("/editorial")
public class EditorialController {
    @Autowired
    private EditorialServiceAPI editorialServiceAPI;

    @GetMapping(value="/getAll")
    public List<Editorial> getAll(){
        return editorialServiceAPI.getAll();
    }

    @PostMapping(value="/saveEditorial")
    public ResponseEntity<Editorial> save(@RequestBody Editorial editorial){
        Editorial obj = editorialServiceAPI.save(editorial);
        return new ResponseEntity<Editorial>(obj, HttpStatus.OK); // 200
    }

    @PutMapping(value="update-record/{id}")
    public ResponseEntity<Editorial> updateEditorial(@RequestBody Editorial editorial, @PathVariable("id") int id) {
        editorial.setId(id);
        Editorial obj = editorialServiceAPI.save(editorial);
        return new ResponseEntity<Editorial>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<Editorial> getEditorialById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Editorial editorial = editorialServiceAPI.get(id);
        if (editorial == null){
            new ResourceNotFoundException("Record not found for <editorial>"+id);
        }
        return ResponseEntity.ok().body(editorial);
    }

    @DeleteMapping(value="/deleteEditorial/{id}")
    public ResponseEntity<Editorial> delete(@PathVariable Integer id){
        Editorial editorial = editorialServiceAPI.get(id);
        if (editorial != null){
            editorialServiceAPI.delete(id);
        }else{
            return new ResponseEntity<Editorial>(editorial, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Editorial>(editorial, HttpStatus.OK);
    }
}
