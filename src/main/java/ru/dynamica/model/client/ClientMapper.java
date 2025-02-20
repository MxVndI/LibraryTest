package ru.dynamica.model.client;


public class ClientMapper {
        public static ClientDto toClientDto(Client client) {
            return new ClientDto(
                    client.getName(),
                    client.getLastName(),
                    client.getBirthDate()
            );
        }
}
