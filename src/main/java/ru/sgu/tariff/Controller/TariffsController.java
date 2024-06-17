package ru.sgu.tariff.Controller;

import ru.sgu.tariff.Model.Tariffs;
import ru.sgu.tariff.Service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Tariffs find(@PathVariable Long id) {
        return tariffService.find(id);
    }

    @PostMapping
    public Tariffs create(@RequestBody Tariffs tariff) {
        tariff.setLastModifiedDate(new Date());
        return tariffService.create(tariff);
    }

    @PutMapping("/{id}")
    public Tariffs update(@PathVariable Long id, @RequestBody Tariffs tariff) {
        tariff = tariffService.find(id);
        tariff.setLastModifiedDate(new Date());
        return tariffService.update(tariff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
            tariffService.delete(id);
    }
}