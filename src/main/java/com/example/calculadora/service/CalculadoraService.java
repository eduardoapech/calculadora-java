package com.example.calculadora.service;

import com.example.calculadora.dto.OperacaoRequest;
import com.example.calculadora.exception.OperacaoInvalidaException;
import com.example.calculadora.model.Operacao;
import com.example.calculadora.repository.OperacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculadoraService {

    private final OperacaoRepository repository;



    public double calcular(OperacaoRequest request){

        double resultado = switch (request.getOperador()){
       case "+" -> request.getNumero1() + request.getNumero2();
       case "-" -> request.getNumero1() - request.getNumero2();
       case "*" -> request.getNumero1() * request.getNumero2();
       case "/" -> {
           if (request.getNumero2() == 0)
               throw new OperacaoInvalidaException("Divisão por zero não permitida");
           yield request.getNumero1() / request.getNumero2();
       }
         default -> throw  new OperacaoInvalidaException("Operador inválido: " + request.getOperador());
     };

        Operacao operacao = new Operacao(
                request.getNumero1(),
                request.getNumero2(),
                request.getOperador(),
                resultado
        );

        repository.save(operacao);

        return resultado;
    }

    public List<Operacao> listarOperacoes(){
        return repository.findAll();
    }
}
