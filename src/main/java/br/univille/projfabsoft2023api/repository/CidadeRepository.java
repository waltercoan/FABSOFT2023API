package br.univille.projfabsoft2023api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoft2023api.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
    
}
