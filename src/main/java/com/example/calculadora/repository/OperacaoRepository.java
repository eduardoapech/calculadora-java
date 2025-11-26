package com.example.calculadora.repository;

import com.example.calculadora.model.Operacao;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
