package cl.duoc.HuechurabaBMW.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.HuechurabaBMW.model.ModelRepuestos;
import cl.duoc.HuechurabaBMW.repository.RepositoryRepuestos;
import cl.duoc.HuechurabaBMW.dto.DTORepuestos;

import java.util.List;

@Service
public class ServiceRepuestos {

    @Autowired
    private RepositoryRepuestos repository;

    public ModelRepuestos save (DTORepuestos dto) {
        if (!List.of ("Mercedes", "Audi", "BMW").contains(dto.getMarca())) {
            throw new RuntimeException("La marca no es válida");
        }

           ModelRepuestos repuesto = new ModelRepuestos();
            repuesto.setMarca(repuesto.getMarca());
            repuesto.setNombre(repuesto.getNombre());
            repuesto.setStock(repuesto.getStock());
            repuesto.setPrecio(repuesto.getPrecio());

            return repository.save(repuesto);
    }}
