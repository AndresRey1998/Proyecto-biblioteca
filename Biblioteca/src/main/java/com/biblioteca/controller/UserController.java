package com.biblioteca.controller;

import com.biblioteca.entity.User;
import com.biblioteca.service.api.UserServiceAPI;
import com.biblioteca.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081/", "http://localhost:3000/"} ,maxAge = 3600, methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceAPI userServiceAPI;

    @GetMapping(value="/getAll")
    public List<User> getAll(){ return userServiceAPI.getAll();
    }

    @PostMapping(value="/saveUser")
    public ResponseEntity<User> save(@RequestBody User user){
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        User obj = userServiceAPI.save(user);
        return new ResponseEntity<User>(obj, HttpStatus.OK); // 200
    }

    @PatchMapping(value="update-record/{id}")
    public ResponseEntity<User> updateUsuario(@RequestBody User user, @PathVariable("id") int id)
            throws ResourceNotFoundException {
        User obj = userServiceAPI.get(id);
        if (obj == null) {
            throw new ResourceNotFoundException("Usuario not found with id " + id);
        }
        if(user.getUserName() != null){
            obj.setUserName(user.getUserName());
        }
        if(user.getEmail() != null){
            obj.setEmail(user.getEmail());
            obj.setUserName(user.getEmail());
        }
        if(user.getRoles() != null && !user.getRoles().isEmpty()){
            System.out.println("Roles: " + user.getRoles());
            obj.setRoles(user.getRoles());
        }
        if(user.getPassword() != null){
            String password = passwordEncoder.encode(user.getPassword());
            obj.setPassword(password);
        }
        User updated = userServiceAPI.save(obj);
        return new ResponseEntity<User>(updated, HttpStatus.OK);
    }

    @GetMapping(value="/findRecord/{id}")
    public ResponseEntity<User> getUsuarioById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        User user = userServiceAPI.get(id);
        if (user == null){
            new ResourceNotFoundException("Record not found for <usuario>"+id);
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value="/findRecordByEmail/{email}")
    public ResponseEntity<User> getUsuarioByEmail(@PathVariable(value = "email") String email)
            throws ResourceNotFoundException {
        User user = userServiceAPI.getByEmail(email);
        if (user == null){
            new ResourceNotFoundException("Record not found for <usuario>"+email);
        }
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value="/deleteUsuario/{id}")
    public ResponseEntity<User> deleteUsuario(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        User user = userServiceAPI.get(id);
        if (user == null){
            throw new ResourceNotFoundException("Record not found for <usuario>"+id);
        }
        userServiceAPI.delete(id);
        return ResponseEntity.ok().build();
    }


}
