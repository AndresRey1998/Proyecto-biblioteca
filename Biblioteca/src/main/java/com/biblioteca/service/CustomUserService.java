package com.biblioteca.service;

import com.chibcha.entidad.Usuario;
import com.chibcha.entidad.UsuarioSeguridad;
import com.chibcha.repositorio.UsuarioSRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("myUserDetailService")
@Transactional
public class CustomUserService implements UserDetailsService {

    @Autowired
    UsuarioSRepositorio userDetailsRepository;

    public CustomUserService(UsuarioSRepositorio userDetailsRepository){
        this.userDetailsRepository = userDetailsRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {

        Usuario user=this.userDetailsRepository.findByUserName(nombreUsuario);
        UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad(user);
        return usuarioSeguridad;

    }
}
