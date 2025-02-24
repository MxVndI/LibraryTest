package ru.dynamica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dynamica.model.client.ClientDto;
import ru.dynamica.service.ClientService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/new")
    public String addClient(@ModelAttribute ClientDto clientDto, BindingResult bindingResult) {
        clientService.create(clientDto);
        return "redirect:/clients";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("client", new ClientDto());
        return "client/client-form";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        ClientDto clientDto = clientService.findById(id);
        model.addAttribute("client", clientDto);
        return "client/client-edit";
    }

    @PatchMapping("/{id}")
    public String updateClient(@PathVariable("id") Integer id, @ModelAttribute ClientDto clientDto) {
        clientService.update(id, clientDto);
        return "redirect:/clients";
    }

    @GetMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("clientDto", new ClientDto());
        return "client/client-list";
    }
}
