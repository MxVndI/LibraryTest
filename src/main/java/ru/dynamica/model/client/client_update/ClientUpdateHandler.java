package ru.dynamica.model.client.client_update;

import ru.dynamica.model.client.Client;
import ru.dynamica.model.client.ClientDto;

public interface ClientUpdateHandler {
    void setNext(ClientUpdateHandler next);
    void handle(Client client, ClientDto updateRequest);
}


