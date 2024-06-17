package ru.sgu.tariff.Service;

import ru.sgu.tariff.Model.Tariffs;
import ru.sgu.tariff.Repository.TariffsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffService {

    private final TariffsRepository tariffsRepository;

    @Autowired
    public TariffService(TariffsRepository tariffsRepository){
        this.tariffsRepository = tariffsRepository;
    }

    public Tariffs create(Tariffs tariff){
        return tariffsRepository.save(tariff);
    }

    public List<Tariffs> findAll(){
        return tariffsRepository.findAll();
    }

    public Tariffs find(Long id){
        return tariffsRepository.findById(id).orElse(null);
    }

    public Tariffs update(Tariffs tariff){
        return tariffsRepository.save(tariff);
    }

    public void delete(Long id){
        tariffsRepository.deleteById(id);
    }
}
