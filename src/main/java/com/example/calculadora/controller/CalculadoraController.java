package com.example.calculadora.controller;

import com.example.calculadora.dto.OperacaoRequest;
import com.example.calculadora.dto.OperacaoResponse;
import com.example.calculadora.service.CalculadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculadora")
@RequiredArgsConstructor
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    @PostMapping("/calcular")
    public OperacaoResponse calcular(@RequestBody OperacaoRequest request){
        double resultado = calculadoraService.calcular(request);
        return new OperacaoResponse(resultado);
    }
}
