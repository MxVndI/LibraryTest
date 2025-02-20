package ru.dynamica.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamica.model.book.Book;
import ru.dynamica.model.book.BookDto;
import ru.dynamica.model.book.BookMapper;
import ru.dynamica.model.client.Client;
import ru.dynamica.model.client.ClientDto;
import ru.dynamica.model.client.ClientMapper;
import ru.dynamica.model.client.clientUpdate.BirthDateUpdateHandler;
import ru.dynamica.model.client.clientUpdate.ClientUpdateHandler;
import ru.dynamica.model.client.clientUpdate.LastNameUpdateHandler;
import ru.dynamica.model.client.clientUpdate.NameUpdateHandler;
import ru.dynamica.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientDto create(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setBirthDate(clientDto.getBirthDate());
        clientRepository.save(client);
        return clientDto;
    }

    public List<ClientDto> getAllClients() {
        List<ClientDto> clientDtos = new ArrayList<>();
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            clientDtos.add(ClientMapper.toClientDto(client));
        }
        return clientDtos;
    }

    public ClientDto update(Integer id, ClientDto clientDto) {
        ClientUpdateHandler nameHandler = new NameUpdateHandler();
        ClientUpdateHandler lastNameHandler = new LastNameUpdateHandler();
        ClientUpdateHandler birthDateHandler = new BirthDateUpdateHandler();

        nameHandler.setNext(lastNameHandler);
        lastNameHandler.setNext(birthDateHandler);
        Optional<Client> client = clientRepository.findById(id);
        checkClientExist(client);
        nameHandler.handle(client.get(), clientDto);
        clientRepository.save(client.get());
        return ClientMapper.toClientDto(client.get());
    }

    private void checkClientExist(Optional<Client> client) {
        if (!client.isPresent()) {
            throw new RuntimeException("temp");
        }
    }
}
