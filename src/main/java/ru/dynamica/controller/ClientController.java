package ru.dynamica.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dynamica.model.client.ClientDto;
import ru.dynamica.service.ClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ClientDto addClient(@RequestBody ClientDto clientDto) {
        return clientService.create(clientDto);
    }

    @PatchMapping("/{id}")
    public ClientDto updateClient(@PathVariable("id") Integer id,@RequestBody ClientDto clientDto) {
        return clientService.update(id, clientDto);
    }

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }
}
