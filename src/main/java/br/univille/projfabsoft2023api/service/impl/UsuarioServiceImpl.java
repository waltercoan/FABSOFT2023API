package br.univille.projfabsoft2023api.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft2023api.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl 
    implements UserDetailsService{

    @Autowired
    private UsuarioRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = repository.findByUsuario(username);
        if(usuario.isPresent()){
            var usuarioEncontrado = usuario.get();
            return new User(usuarioEncontrado.getUsuario(),
                            usuarioEncontrado.getSenha(),
                            new ArrayList<>());
        }
        return null;
    }
    
}
