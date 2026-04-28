package cl.duoc.HuechurabaBMW.controller;

import cl.duoc.HuechurabaBMW.model.ModelRepuestos;
import cl.duoc.HuechurabaBMW.repository.RepositoryRepuestos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repuestos")
public class ControllerRepuestos {

    @Autowired
    private RepositoryRepuestos repository;

    // 1: Agregar nuevo repuesto
    @PostMapping
    public ModelRepuestos agregarRepuesto(@RequestBody ModelRepuestos repuesto) {
        return repository.save(repuesto);
    }

    // 2: Ver todos los repuestos
    @GetMapping
    public List<ModelRepuestos> obtenerRepuestos() {
        return repository.findAll();
    }

    // 3: Ver stock de un repuesto por ID
    @GetMapping("/{id}/stock")
    public String verStock(@PathVariable Long id) {
        Optional<ModelRepuestos> repuesto = repository.findById(id);

        if (repuesto.isPresent()) {
            return "Stock disponible: " + repuesto.get().getStock();
        } else {
            return "Repuesto no encontrado";
        }
    }

    //4: Vender repuesto (disminuir stock)
    @PutMapping("/{id}/vender")
    public String venderRepuesto(@PathVariable Long id, @RequestParam int cantidad) {
        Optional<ModelRepuestos> repuesto = repository.findById(id);

        if (repuesto.isPresent()) {
            ModelRepuestos r = repuesto.get();

            if (r.getStock() >= cantidad) {
                r.setStock(r.getStock() - cantidad);
                repository.save(r);
                return "Venta realizada. Nuevo stock: " + r.getStock();
            } else {
                return "No hay suficiente stock";
            }
        } else {
            return "Repuesto no encontrado";
        }
    }

    // 5: Agregar unidades (aumentar stock)
    @PutMapping("/{id}/agregar")
    public String agregarStock(@PathVariable Long id, @RequestParam int cantidad) {
        Optional<ModelRepuestos> repuesto = repository.findById(id);

        if (repuesto.isPresent()) {
            ModelRepuestos r = repuesto.get();
            r.setStock(r.getStock() + cantidad);
            repository.save(r);
            return "Stock actualizado. Nuevo stock: " + r.getStock();
        } else {
            return "Repuesto no encontrado";
        }
    }
}
