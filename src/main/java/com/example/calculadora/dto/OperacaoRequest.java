package com.example.calculadora.dto;

import lombok.Data;

@Data
public class OperacaoRequest {
    private double numero1;
    private double numero2;
    private String operador;
}
