package com.biblioteca.controller;

import com.biblioteca.entity.Book;
import com.biblioteca.service.api.BookServiceAPI;
import com.biblioteca.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081/", "http://localhost:3000/"} ,maxAge = 3600, methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,})
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceAPI bookServicioAPI;


    @GetMapping(value="/getAll")
    public List<Book> getAll(){
        return bookServicioAPI.getAll();
    }

    @PostMapping(value="/saveBook")
    public ResponseEntity<Book> save(@RequestBody Book book){
            Book obj = bookServicioAPI.save(book);
            return new ResponseEntity<Book>(obj, HttpStatus.OK); // 200


    }

    @PutMapping(value="update-record/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        book.setId(id);
        Book obj = bookServicioAPI.save(book);
        return new ResponseEntity<Book>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Book book = bookServicioAPI.get(id);
        if (book == null){
            new ResourceNotFoundException("Record not found for <Book>"+id);
        }
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping(value="/deleteBook/{id}")
    public ResponseEntity<Book> delete(@PathVariable Integer id){
        Book book = bookServicioAPI.get(id);
        if (book != null){
            bookServicioAPI.delete(id);
        }else{
            return new ResponseEntity<Book>(book, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
