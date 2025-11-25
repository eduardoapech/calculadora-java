package com.example.calculadora.service;

import com.example.calculadora.dto.OperacaoRequest;
import com.example.calculadora.exception.OperacaoInvalidaException;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public double calcular(OperacaoRequest request){
     return switch (request.getOperador()){
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
    }
}
