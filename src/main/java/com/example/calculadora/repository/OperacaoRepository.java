package com.example.calculadora.repository;

import com.example.calculadora.model.Operacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OperacaoRepository {

    private final List<Operacao> operacoes = new ArrayList<>();

    public void  salvar(Operacao operacao) {
        operacoes.add(operacao);
    }

    public List<Operacao> listarTodas(){
        return operacoes;
    }
}
