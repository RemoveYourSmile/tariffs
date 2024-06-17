package ru.sgu.tariff.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Clients {

    @Id
    private Long id;

    private String login;

    private Long idTariff;

    private Date lastModifiedDate;

    public Clients() {
    }

    public Clients(String login, Long idTariff, Date lastModifiedDate) {
        this.login = login;
        this.idTariff = idTariff;
        this.lastModifiedDate = lastModifiedDate;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(Long idTariff) {
        this.idTariff = idTariff;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
