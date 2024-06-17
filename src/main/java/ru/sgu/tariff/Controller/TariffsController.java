package ru.sgu.tariff.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.sgu.tariff.Model.Tariffs;
import ru.sgu.tariff.Service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tariffs")
public class TariffsController {

    private final TariffService tariffService;

    @Autowired
    public TariffsController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping
    public List<Tariffs> findAll() {
        return tariffService.findAll();
    }

    @GetMapping("/{id}")
    public Tariffs find(@PathVariable Long id) throws TariffService.ThereIsNoSuchTariffException {
        return tariffService.find(id);
    }

    @PostMapping
    public Tariffs create(@RequestBody Tariffs tariff) {
        return tariffService.create(tariff);
    }

    @PutMapping("/{id}")
    public Tariffs update(@PathVariable Long id, @RequestBody Tariffs tariff)
            throws TariffService.ThereIsNoSuchTariffException {
        return tariffService.update(id, tariff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
            throws TariffService.ThereIsNoSuchTariffException {
        tariffService.delete(id);
    }

    @RestControllerAdvice
    public static class ExceptionApiHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(TariffService.ThereIsNoSuchTariffException.class)
        public ResponseEntity<ErrorMessage> handlerThereIsNoSuchTariffException() {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessage("There is no such tariff"));
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