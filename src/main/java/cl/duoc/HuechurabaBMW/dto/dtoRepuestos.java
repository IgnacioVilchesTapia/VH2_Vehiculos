package cl.duoc.HuechurabaBMW.dto;

import lombok.*;
<<<<<<< HEAD
=======
import jakarta.validation.constraints.*;
>>>>>>> 8d5c7e6e37c1de08c564bf75ecf0825fc6c7a395

@Getter
@Setter
@NoArgsConstructor
<<<<<<< HEAD
@AllArgConstructor

public class dtoRepuestos {
    private Long id;
    private String marca;
    private String nombre;
    private int stock;
=======
@AllArgsConstructor
public class DTORepuestos {

    @NotBlank(message = "La marca no puede estar vacía")
    private String marca;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Min(value = 0, message = "El stock debe ser mayor o igual a 0")
    private int stock;

    @Min(value = 0, message = "El precio debe ser mayor o igual a 0")
>>>>>>> 8d5c7e6e37c1de08c564bf75ecf0825fc6c7a395
    private double precio;
}
