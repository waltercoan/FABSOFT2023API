package br.univille.projfabsoft2023api.service;

import java.util.List;

import br.univille.projfabsoft2023api.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();

    void save(Cliente cliente);

    void delete(long id);


}
