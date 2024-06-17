package ru.sgu.tariff;

import ru.sgu.tariff.Model.Clients;
import ru.sgu.tariff.Model.Tariffs;
import ru.sgu.tariff.Service.ClientService;
import ru.sgu.tariff.Service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TariffApplication{

	private final ClientService clientService;

	private final TariffService tariffService;

	@Autowired
	public TariffApplication(ClientService clientService, TariffService tariffService) {
		this.clientService = clientService;
		this.tariffService = tariffService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TariffApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return args -> {
			Tariffs tariff = new Tariffs();
			tariff.setId(1L);
			tariff.setNameTariff("Pro");
			tariff.setBid(500);
			tariff.setLastModifiedDate(new Date());
			Clients client = new Clients();
			client.setId(1L);
			client.setLogin("Danil");
			client.setIdTariff(1L);
			client.setLastModifiedDate(new Date());
			tariffService.create(tariff);
			clientService.create(client);
		};
	}
}
