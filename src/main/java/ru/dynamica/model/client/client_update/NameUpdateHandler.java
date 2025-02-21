package ru.dynamica.model.client.client_update;

import ru.dynamica.model.client.Client;
import ru.dynamica.model.client.ClientDto;

public class NameUpdateHandler implements ClientUpdateHandler {
    private ClientUpdateHandler next;

    @Override
    public void setNext(ClientUpdateHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Client client, ClientDto updateRequest) {
        if (updateRequest.getName() != null) {
            client.setName(updateRequest.getName());
        }
        if (next != null) {
            next.handle(client, updateRequest);
        }
    }
}