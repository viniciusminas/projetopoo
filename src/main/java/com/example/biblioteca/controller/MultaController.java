package com.example.biblioteca.controller;

import com.example.biblioteca.dto.MultaDTO;
import com.example.biblioteca.model.Multa;
import com.example.biblioteca.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/multas")
public class MultaController {

    @Autowired
    private MultaService multaService;

    @PostMapping
    public ResponseEntity<Multa> criarMulta(@RequestBody MultaDTO multaDTO) {
        Multa multa = multaService.criarMulta(multaDTO);
        return ResponseEntity.ok(multa);
    }

    @GetMapping
    public ResponseEntity<List<Multa>> listarMultas() {
        return ResponseEntity.ok(multaService.listarMultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Multa> buscarMulta(@PathVariable Long id) {
        return multaService.buscarMulta(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMulta(@PathVariable Long id) {
        multaService.removerMulta(id);
        return ResponseEntity.noContent().build();
    }
}
