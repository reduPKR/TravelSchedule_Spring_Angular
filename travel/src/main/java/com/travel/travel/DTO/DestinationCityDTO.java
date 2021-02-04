package com.travel.travel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationCityDTO {
    private long id;

    @NotEmpty
    @Size(min=3, max=100, message = "cidade tem que ter mais de 3")
    private String cidade;

    @NotNull
    private LocalDateTime date;
}
