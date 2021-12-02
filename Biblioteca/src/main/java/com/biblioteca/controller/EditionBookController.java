package com.biblioteca.controller;

import com.biblioteca.entity.Book;
import com.biblioteca.entity.EditionBook;
import com.biblioteca.service.api.BookServiceAPI;
import com.biblioteca.service.api.EditionBookServiceAPI;
import com.biblioteca.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081/", "http://localhost:3000/"} ,maxAge = 3600, methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,})
@RestController
@RequestMapping("/edition")
public class EditionBookController {
    @Autowired
    private EditionBookServiceAPI editionBookServiceAPI;

    @GetMapping(value="/getAll")
    public List<EditionBook> getAll(){
        return editionBookServiceAPI.getAll();
    }

    @PostMapping(value="/saveEditionBook")
    public ResponseEntity<EditionBook> save(@RequestBody EditionBook editionBook){
        EditionBook obj = editionBookServiceAPI.save(editionBook);
        return new ResponseEntity<EditionBook>(obj, HttpStatus.OK); // 200
    }

    @PutMapping(value="update-record/{id}")
    public ResponseEntity<EditionBook> updateEditionBook(@RequestBody EditionBook editionBook, @PathVariable("id") int id) {
        editionBook.setId(id);
        EditionBook obj = editionBookServiceAPI.save(editionBook);
        return new ResponseEntity<EditionBook>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<EditionBook> getEditionBookById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        EditionBook editionBook = editionBookServiceAPI.get(id);
        if (editionBook == null){
            new ResourceNotFoundException("Record not found for <EditionBook>"+id);
        }
        return ResponseEntity.ok().body(editionBook);
    }

    @DeleteMapping(value="/deleteEditionBook/{id}")
    public ResponseEntity<EditionBook> delete(@PathVariable Integer id){
        EditionBook editionBook = editionBookServiceAPI.get(id);
        if (editionBook != null){
            editionBookServiceAPI.delete(id);
        }else{
            return new ResponseEntity<EditionBook>(editionBook, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<EditionBook>(editionBook, HttpStatus.OK);
    }
}
