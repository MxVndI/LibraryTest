package ru.dynamica.model.client.clientUpdate;

import ru.dynamica.model.client.Client;
import ru.dynamica.model.client.ClientDto;

public interface ClientUpdateHandler {
    void setNext(ClientUpdateHandler next);
    void handle(Client client, ClientDto updateRequest);
}


