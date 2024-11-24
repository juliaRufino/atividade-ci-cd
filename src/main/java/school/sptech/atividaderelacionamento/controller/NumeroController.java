package school.sptech.atividaderelacionamento.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroController {
    @GetMapping("/soma")
    public Integer somar(@RequestParam Integer numero1, @RequestParam Integer numero2) {
        return numero1 + numero2;
    }

}


