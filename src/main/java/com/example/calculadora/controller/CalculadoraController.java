    package com.example.calculadora.controller;

    import com.example.calculadora.dto.OperacaoRequest;
    import com.example.calculadora.dto.OperacaoResponse;
    import com.example.calculadora.model.Operacao;
    import com.example.calculadora.service.CalculadoraService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/calculadora")
    @RequiredArgsConstructor
    public class CalculadoraController {

        private final CalculadoraService service; // <-- apenas isso

        @PostMapping("/calcular")
        public OperacaoResponse calcular(@RequestBody OperacaoRequest request){
            double resultado = service.calcular(request);
            return new OperacaoResponse(resultado);
        }

        @GetMapping("/nome")
        public String nomeDoSistema(){
            return "Aplicação: Calculadora API";
        }

        @GetMapping("/historico")
        public List<Operacao> historico(){
            return service.listarOperacoes();
        }

        @GetMapping("/test-db")
        public String testDb() {
            return "OK";
        }
    }

