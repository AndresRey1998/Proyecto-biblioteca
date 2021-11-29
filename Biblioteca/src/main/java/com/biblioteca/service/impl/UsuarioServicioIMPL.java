package com.biblioteca.service.impl;

import com.chibcha.entidad.Usuario;
import com.chibcha.repositorio.UsuarioRepositorio;
import com.chibcha.servicios.api.UsuarioServicioAPI;
import com.chibcha.utilidades.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioIMPL extends GenericServiceImpl<Usuario, Integer> implements UsuarioServicioAPI {
    @Autowired
    private UsuarioRepositorio UsuarioDaoAPI;

    @Override
    public CrudRepository<Usuario, Integer> getDao(){
        return UsuarioDaoAPI;
    }

    @Override
    public Usuario getByEmail(String email) {
        return UsuarioDaoAPI.findByEmail(email);
    }
}
