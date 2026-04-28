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

    public ModelRepuestos save(DTORepuestos dto) {

    if (!List.of("Mercedes", "Audi", "BMW").contains(dto.getMarca())) {
        throw new RuntimeException("La marca no es válida");
    }

    ModelRepuestos repuesto = new ModelRepuestos();
    repuesto.setMarca(dto.getMarca());
    repuesto.setNombre(dto.getNombre());
    repuesto.setStock(dto.getStock());
    repuesto.setPrecio(dto.getPrecio());

    return repository.save(repuesto);
    }

    public List<ModelRepuestos> listar() {
        return repository.findAll();
    }
    public ModelRepuestos buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));
}
    public ModelRepuestos vender(Long id){
        ModelRepuestos r = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));

    if (r.getStock() <= 0){
        throw new RuntimeException("No hay stock disponible");
    }

    r.setStock(r.getStock() - 1 );
    return repository.save(r);
}

    public ModelRepuestos agregarStock(Long id, int cantidad){
    if (cantidad <= 0) {
        throw new RuntimeException("Cantidad inválida");
    }

    ModelRepuestos r = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));

    r.setStock(r.getStock() + cantidad);
    return repository.save(r);
}
}