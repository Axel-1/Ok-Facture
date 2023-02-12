package io.axel1.okfacture.controller;

import io.axel1.okfacture.dto.FactureDto;
import io.axel1.okfacture.dto.FactureMapper;
import io.axel1.okfacture.dto.PostFactureDto;
import io.axel1.okfacture.entity.Client;
import io.axel1.okfacture.entity.Facture;
import io.axel1.okfacture.service.ClientService;
import io.axel1.okfacture.service.FactureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    private final FactureService factureService;
    private final FactureMapper factureMapper;

    public ClientController(ClientService clientService, FactureService factureService,
                            FactureMapper factureMapper) {
        this.clientService = clientService;
        this.factureService = factureService;
        this.factureMapper = factureMapper;
    }

    @PostMapping("/{id}/factures")
    public FactureDto createFactureForClient(@PathVariable Integer id, @RequestBody PostFactureDto postFacture) {
        Client client = clientService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Facture facture = factureMapper.toEntity(postFacture);

        return factureMapper.toDto(factureService.save(facture, client));
    }
}
