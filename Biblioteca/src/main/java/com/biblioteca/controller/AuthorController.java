package com.biblioteca.controller;

import com.biblioteca.entity.Author;
import com.biblioteca.service.api.AuthorServiceAPI;
import com.biblioteca.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081/", "http://localhost:3000/"} ,maxAge = 3600, methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,})
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorServiceAPI authorServicioAPI;

    @GetMapping(value="/getAll")
    public List<Author> getAll(){
        return authorServicioAPI.getAll();
    }

    @PostMapping(value="/saveAuthor")
    public ResponseEntity<Author> save(@RequestBody Author author){
        Author obj = authorServicioAPI.save(author);
        return new ResponseEntity<Author>(obj, HttpStatus.OK); // 200
    }

    @PutMapping(value="update-record/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable("id") int id) {
        author.setId(id);
        Author obj = authorServicioAPI.save(author);
        return new ResponseEntity<Author>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Author author = authorServicioAPI.get(id);
        if (author == null){
            new ResourceNotFoundException("Record not found for <Author>"+id);
        }
        return ResponseEntity.ok().body(author);
    }

    @DeleteMapping(value="/deleteAuthor/{id}")
    public ResponseEntity<Author> delete(@PathVariable Integer id){
        Author author = authorServicioAPI.get(id);
        if (author != null){
            authorServicioAPI.delete(id);
        }else{
            return new ResponseEntity<Author>(author, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }
}
