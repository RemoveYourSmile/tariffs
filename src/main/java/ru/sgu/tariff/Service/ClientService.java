package ru.sgu.tariff.Service;

import ru.sgu.tariff.Model.Clients;
import ru.sgu.tariff.Repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Clients getByClientId(Long id){
        return clientsRepository.findById(id).orElse(null);
    }

    public Clients create(Clients client){
        return clientsRepository.save(client);
    }

    public Clients update(Clients client){
        return clientsRepository.save(client);
    }

    public void delete(Long id){
        clientsRepository.deleteById(id);
    }
}