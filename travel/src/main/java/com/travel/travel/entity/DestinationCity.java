package com.travel.travel.entity;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
public class DestinationCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private LocalDateTime date;

    /*----------------------------------------------*/

    public DestinationCity() {
    }

    public DestinationCity(long id, String cidade, LocalDateTime date) {
        this.id = id;
        this.cidade = cidade;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
