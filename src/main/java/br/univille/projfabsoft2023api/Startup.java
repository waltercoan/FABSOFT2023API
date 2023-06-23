package br.univille.projfabsoft2023api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projfabsoft2023api.entity.Usuario;
import br.univille.projfabsoft2023api.repository.UsuarioRepository;

@Component
public class Startup {
    @Autowired
    private UsuarioRepository repository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        if(!repository.findByUsuario("admin").isPresent()){
            var usuario = new Usuario();
            usuario.setUsuario("admin");
            usuario.setSenha("admin");
            repository.save(usuario);
        }
    }
    
}
