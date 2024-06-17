package ru.sgu.tariff.Service;

import ru.sgu.tariff.Model.Clients;
import ru.sgu.tariff.Repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientService(ClientsRepository clientsRepository){
        this.clientsRepository = clientsRepository;
    }

    public List<Clients> findAll(){
        return clientsRepository.findAll();
    }

    public Clients getByClientId(Long id) throws ThereIsNoSuchClientException {
        return clientsRepository.findById(id).orElseThrow(ThereIsNoSuchClientException::new);
    }

    public Clients create(Clients client){
        client.setLastModifiedDate(new Date());
        return clientsRepository.save(client);
    }

    public Clients update(Long id, Clients client) throws ThereIsNoSuchClientException{
            Clients oldClient = getByClientId(id);
            if (oldClient == null){
                throw new ThereIsNoSuchClientException();
            }
            if (client.getIdTariff() != null) {
                oldClient.setIdTariff(client.getIdTariff());
                oldClient.setLastModifiedDate(new Date());
            }
            return clientsRepository.save(oldClient);
    }

    public void delete(Long id) throws ThereIsNoSuchClientException{
        int f = clientsRepository.findById(id).isEmpty() ? 1 : 0;
        if (f == 0) {
            clientsRepository.deleteById(id);
        } else throw new ThereIsNoSuchClientException();
    }

    public static class ThereIsNoSuchClientException extends Exception {}
}