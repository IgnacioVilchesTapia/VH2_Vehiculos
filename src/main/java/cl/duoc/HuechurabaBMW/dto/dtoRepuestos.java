package cl.duoc.HuechurabaBMW.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTORepuestos {

    @NotBlank(message = "La marca no puede estar vacía")
    private String marca;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Min(value = 0, message = "El stock debe ser mayor o igual a 0")
    private int stock;

    @Min(value = 0, message = "El precio debe ser mayor o igual a 0")
    private double precio;
    
}
