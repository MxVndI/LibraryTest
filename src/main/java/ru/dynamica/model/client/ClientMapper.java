package ru.dynamica.model.client;


public class ClientMapper {
    private ClientMapper() {

    }

    public static ClientDto toClientDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getName(),
                client.getLastName(),
                client.getBirthDate()
        );
    }
}
