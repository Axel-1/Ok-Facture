package io.axel1.okfacture.controller;

import io.axel1.okfacture.entity.Parametre;
import io.axel1.okfacture.service.ParametreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/parametres")
public class ParametreController {
    private final ParametreService parametreService;

    public ParametreController(ParametreService parametreService) {
        this.parametreService = parametreService;
    }

    @GetMapping
    public Parametre getParametre() {
        return parametreService.getParametre().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
