package com.br.senai.projetoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.senai.projetoFinal.model.EstoqueModel;

@Repository	
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long> {

}
