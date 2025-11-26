package com.example.calculadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Operacao {

    private double numero1;
    private double numero2;
    private String operador;
    private double resultado;
}
