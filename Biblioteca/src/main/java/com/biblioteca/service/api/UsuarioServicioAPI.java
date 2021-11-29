package com.biblioteca.service.api;

import com.chibcha.entidad.Usuario;
import com.chibcha.utilidades.GenericServiceAPI;

public interface UsuarioServicioAPI extends GenericServiceAPI<Usuario,Integer> {
    public Usuario getByEmail(String email);
}
