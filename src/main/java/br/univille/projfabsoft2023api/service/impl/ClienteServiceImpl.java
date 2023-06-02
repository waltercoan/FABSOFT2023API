package br.univille.projfabsoft2023api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft2023api.entity.Cliente;
import br.univille.projfabsoft2023api.repository.ClienteRepository;
import br.univille.projfabsoft2023api.service.ClienteService;

@Service
public class ClienteServiceImpl 
        implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }
    /*
     * git add .
     * git commit -m "muita coisa"
     * git push
     */

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    
    
}
