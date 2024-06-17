package ru.sgu.tariff.Service;

import ru.sgu.tariff.Model.Tariffs;
import ru.sgu.tariff.Repository.TariffsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

@Service
public class TariffService {

    private final TariffsRepository tariffsRepository;

    @Autowired
    public TariffService(TariffsRepository tariffsRepository){
        this.tariffsRepository = tariffsRepository;
    }

    public Tariffs create(Tariffs tariff) {
        tariff.setLastModifiedDate(new Date());
        return tariffsRepository.save(tariff);
    }

    public List<Tariffs> findAll() {
        return tariffsRepository.findAll();
    }

    public Tariffs find(Long id) throws ThereIsNoSuchTariffException {
        return tariffsRepository.findById(id).orElseThrow(ThereIsNoSuchTariffException::new);
    }

    public Tariffs update(Long id, Tariffs tariff) throws ThereIsNoSuchTariffException {
        Tariffs oldTariff = find(id);
        if (oldTariff == null) {
            throw new ThereIsNoSuchTariffException();
        }
        if (tariff.getBid() != 0) {
            oldTariff.setBid(tariff.getBid());
            oldTariff.setLastModifiedDate(new Date());
        }
        return tariffsRepository.save(oldTariff);
    }

    public void delete(Long id) throws ThereIsNoSuchTariffException {
        int f = tariffsRepository.findById(id).isEmpty() ? 1 : 0;
        if (f == 0) {
            tariffsRepository.deleteById(id);
        } else throw new ThereIsNoSuchTariffException();
    }

    public static class ThereIsNoSuchTariffException extends Exception {}
}
