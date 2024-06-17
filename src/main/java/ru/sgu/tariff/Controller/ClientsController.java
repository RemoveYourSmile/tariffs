package ru.sgu.tariff.Controller;

import ru.sgu.tariff.Model.Clients;
import ru.sgu.tariff.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    private final ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Clients> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Clients getByClientId(@PathVariable Long id) {
        return clientService.getByClientId(id);
    }

    @PostMapping
    public Clients create(@RequestBody Clients client) {
        client.setLastModifiedDate(new Date());
        return clientService.create(client);
    }

    @PutMapping("/{id}")
    public Clients update(@PathVariable Long id, @RequestBody Clients client) {
        client = clientService.getByClientId(id);
        client.setLastModifiedDate(new Date());
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
}