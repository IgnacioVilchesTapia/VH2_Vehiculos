package cl.duoc.HuechurabaBMW.model;

import lombok.*;

@Entity 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelVehiculo {

    @Id
    private Long id;
    private String marca;
    private String modelo;
    private int año;
    private String color;

}

