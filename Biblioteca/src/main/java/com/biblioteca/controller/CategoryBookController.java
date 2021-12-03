package com.biblioteca.controller;

import com.biblioteca.entity.Book;
import com.biblioteca.entity.CategoryBook;
import com.biblioteca.service.api.BookServiceAPI;
import com.biblioteca.service.api.CategoryBookServiceAPI;
import com.biblioteca.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081/", "http://localhost:3000/"} ,maxAge = 3600, methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,})
@RestController
@RequestMapping("/category")
public class CategoryBookController {
    @Autowired
    private CategoryBookServiceAPI categoryBookServiceAPI;

    @GetMapping(value="/getAll")
    public List<CategoryBook> getAll(){
        return categoryBookServiceAPI.getAll();
    }

    @PostMapping(value="/saveCategoryBook")
    public ResponseEntity<CategoryBook> save(@RequestBody CategoryBook categoryBook){
        CategoryBook obj = categoryBookServiceAPI.save(categoryBook);
        return new ResponseEntity<CategoryBook>(obj, HttpStatus.OK); // 200
    }

    @PutMapping(value="update-record/{id}")
    public ResponseEntity<CategoryBook> updateCategoryBook(@RequestBody CategoryBook categoryBook, @PathVariable("id") int id) {
        categoryBook.setId(id);
        CategoryBook obj = categoryBookServiceAPI.save(categoryBook);
        return new ResponseEntity<CategoryBook>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<CategoryBook> getCategoryBookById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        CategoryBook categoryBook = categoryBookServiceAPI.get(id);
        if (categoryBook == null){
            new ResourceNotFoundException("Record not found for <categoryBook>"+id);
        }
        return ResponseEntity.ok().body(categoryBook);
    }
    @GetMapping(value = "/bookCategory/{id}")
    public List<Book> getBooks(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        CategoryBook categoryBook = categoryBookServiceAPI.get(id);
        if (categoryBook == null) {
            new ResourceNotFoundException("Record not found for <usuario>" + id);
        }
        List<Book> books = categoryBook.getBooks();
        return books;
    }

    @DeleteMapping(value="/deleteCategoryBook/{id}")
    public ResponseEntity<CategoryBook> delete(@PathVariable Integer id){
        CategoryBook categoryBook = categoryBookServiceAPI.get(id);
        if (categoryBook != null){
            categoryBookServiceAPI.delete(id);
        }else{
            return new ResponseEntity<CategoryBook>(categoryBook, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryBook>(categoryBook, HttpStatus.OK);
    }
}
