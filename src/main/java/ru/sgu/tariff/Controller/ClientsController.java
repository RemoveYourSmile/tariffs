package ru.sgu.tariff.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.sgu.tariff.Model.Clients;
import ru.sgu.tariff.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Clients getByClientId(@PathVariable Long id)
            throws ClientService.ThereIsNoSuchClientException {
        return clientService.getByClientId(id);
    }

    @PostMapping
    public Clients create(@RequestBody Clients client) {
        return clientService.create(client);
    }

    @PutMapping("/{id}")
    public Clients update(@PathVariable Long id, @RequestBody Clients client)
            throws ClientService.ThereIsNoSuchClientException {
         return clientService.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
            throws ClientService.ThereIsNoSuchClientException {
        clientService.delete(id);
    }

    @RestControllerAdvice
    public static class ExceptionApiHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(ClientService.ThereIsNoSuchClientException.class)
        public ResponseEntity<ErrorMessage> handlerThereIsNoSuchClientException() {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessage("There is no such client"));
        }

        @Data
        @NoArgsConstructor
        public static class ErrorMessage {
            private String message;

            public ErrorMessage(String message) {
                this.message = message;
            }
        }
    }
}