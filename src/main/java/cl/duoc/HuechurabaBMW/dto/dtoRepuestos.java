package cl.duoc.HuechurabaBMW.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgConstructor

public class dtoRepuestos {
    private Long id;
    private String marca;
    private String nombre;
    private int stock;
    private double precio;
}
