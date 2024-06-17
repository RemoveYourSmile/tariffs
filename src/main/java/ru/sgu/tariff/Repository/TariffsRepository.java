package ru.sgu.tariff.Repository;

import ru.sgu.tariff.Model.Tariffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffsRepository extends JpaRepository<Tariffs, Long> {
}
