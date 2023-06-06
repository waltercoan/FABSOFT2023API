package br.univille.projfabsoft2023api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoft2023api.entity.Cliente;

@Repository
public interface ClienteRepository 
    extends JpaRepository<Cliente,Long>{
    List<Cliente> findByNomeContains(String nome);
}
