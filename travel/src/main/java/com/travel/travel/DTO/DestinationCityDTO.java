package com.travel.travel.DTO;

import lombok.Builder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Builder
public class DestinationCityDTO {
    private long id;

    @NotEmpty
    @Size(min=3, max=100, message = "cidade tem que ter mais de 3")
    private String cidade;

    @NotNull
    private LocalDateTime date;

    /*----------------------------------------------*/

    public DestinationCityDTO() {
    }

    public DestinationCityDTO(long id, String cidade, LocalDateTime date) {
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
