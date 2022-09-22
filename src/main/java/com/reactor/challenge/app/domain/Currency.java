package com.reactor.challenge.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="tbl_currency")
public class Currency {

    private @Id
    @GeneratedValue
    Long id;

    @Column(name="originCurrency")
    private String originCurrency;

    @Column(name="destinationCurrency")
    private String destinationCurrency;

    @Column(name="value")
    private String value;

    public Currency() {
    }

    public Currency( String originCurrency, String destinationCurrency, String value) {

        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
