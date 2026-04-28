package cl.duoc.HuechurabaBMW.controller;

import cl.duoc.HuechurabaBMW.model.ModelRepuestos;
import cl.duoc.HuechurabaBMW.repository.RepositoryRepuestos;
import cl.duoc.HuechurabaBMW.except.ExcepcionRepuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 3: Ver stock
    @GetMapping("/{id}/stock")
    public String verStock(@PathVariable Long id) {
        ModelRepuestos r = repository.findById(id)
                .orElseThrow(() -> new ExcepcionRepuestos("Repuesto no encontrado"));

        return "Stock disponible: " + r.getStock();
    }

    // 4: Vender
    @PutMapping("/{id}/vender")
    public String venderRepuesto(@PathVariable Long id, @RequestParam int cantidad) {

        ModelRepuestos r = repository.findById(id)
                .orElseThrow(() -> new ExcepcionRepuestos("Repuesto no encontrado"));

        if (r.getStock() < cantidad) {
            throw new ExcepcionRepuestos("No hay suficiente stock");
        }

        r.setStock(r.getStock() - cantidad);
        repository.save(r);

        return "Venta realizada. Nuevo stock: " + r.getStock();
    }

    // 5: Agregar stock
    @PutMapping("/{id}/agregar")
    public String agregarStock(@PathVariable Long id, @RequestParam int cantidad) {

        ModelRepuestos r = repository.findById(id)
                .orElseThrow(() -> new ExcepcionRepuestos("Repuesto no encontrado"));

        r.setStock(r.getStock() + cantidad);
        repository.save(r);

        return "Stock actualizado. Nuevo stock: " + r.getStock();
    }
}