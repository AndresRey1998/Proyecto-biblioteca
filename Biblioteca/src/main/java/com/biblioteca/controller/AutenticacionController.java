package com.biblioteca.controller;

import com.biblioteca.entity.UserSecurity;
import com.biblioteca.security.JWTTokenHelper;
import com.biblioteca.security.respuesta.LoginResponse;
import com.biblioteca.security.respuesta.UserInfo;
import com.biblioteca.security.solicitud.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/autenticacion")
@CrossOrigin(origins = {"http://localhost:8081/", "https://chibchaweb.vercel.app/", "https://chibchaweb-backend.herokuapp.com/" } ,maxAge = 3600, methods={RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,})
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JWTTokenHelper jWTTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserSecurity user=(UserSecurity) authentication.getPrincipal();
        String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
        LoginResponse response=new LoginResponse();
        response.setToken(jwtToken);
        response.setId(user.getUser().getId());
        response.setRol(user.getAuthorities().toString());
        response.setEnable(user.isEnabled());
        response.setNombre(user.getUsername());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/auth/userinfo")
    public ResponseEntity<?> getUserInfo(Principal user){
        UserSecurity userObj=(UserSecurity) userDetailsService.loadUserByUsername(user.getName());
        UserInfo userInfo=new UserInfo();
        userInfo.setFirstName(userObj.getUsername());
        userInfo.setRoles(userObj.getAuthorities().toArray());


        return ResponseEntity.ok(userInfo);



    }
}
