package io.axel1.okfacture.service;

import io.axel1.okfacture.entity.Parametre;
import io.axel1.okfacture.repository.ParametreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParametreService {
    private final ParametreRepository parametreRepository;

    public ParametreService(ParametreRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }

    //On pourrait charger les paramètres au démarrage de l'application
    public Optional<Parametre> getParametre() {
        return parametreRepository.findById(1);
    }
}
