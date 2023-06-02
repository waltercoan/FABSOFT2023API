package br.univille.projfabsoft2023api.service;

import java.util.List;

import br.univille.projfabsoft2023api.entity.Carro;

public interface CarroService {
    List<Carro> getAll();

    void save(Carro carro);

    void delete(long id);
}
