package ru.sgu.tariff.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class Tariffs {

    @Id
    private Long id;

    private String nameTariff;

    private int bid;

    private Date lastModifiedDate;

    public Tariffs() {
    }

    public Tariffs(String nameTariff, int bid, Date lastModifiedDate) {
        this.nameTariff = nameTariff;
        this.bid = bid;
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNameTariff() {
        return nameTariff;
    }

    public void setNameTariff(String nameTariff) {
        this.nameTariff = nameTariff;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
