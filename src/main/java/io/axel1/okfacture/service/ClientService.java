package io.axel1.okfacture.service;

import io.axel1.okfacture.entity.Client;
import io.axel1.okfacture.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }
}
