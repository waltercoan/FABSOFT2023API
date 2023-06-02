package br.univille.projfabsoft2023api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft2023api.entity.Carro;
import br.univille.projfabsoft2023api.repository.CarroRepository;
import br.univille.projfabsoft2023api.service.CarroService;

@Service
public class CarroServiceImpl implements CarroService{

    @Autowired
    private CarroRepository repository;

    @Override
    public List<Carro> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Carro carro) {
        repository.save(carro);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
    
}
