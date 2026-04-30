package cl.duoc.HuechurabaBMW.controller;

import cl.duoc.HuechurabaBMW.model.ModelRepuestos;
import cl.duoc.HuechurabaBMW.service.ServiceRepuestos;
import cl.duoc.HuechurabaBMW.dto.DTORepuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repuestos")
public class ControllerRepuestos {

    @Autowired
    private ServiceRepuestos service;

    @PostMapping
    public ModelRepuestos agregarRepuesto(@RequestBody DTORepuestos dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<ModelRepuestos> obtenerRepuestos() {
        return service.listar();
    }

    @GetMapping("/{id}/stock")
    public String verStock(@PathVariable Long id) {
        return "Stock disponible: " + service.buscarPorId(id).getStock();
    }

    @PutMapping("/{id}/vender")
    public ModelRepuestos vender(@PathVariable Long id) {
        return service.vender(id);
    }

    @PutMapping("/{id}/agregar")
    public ModelRepuestos agregarStock(@PathVariable Long id,
                                       @RequestParam int cantidad) {
        return service.agregarStock(id, cantidad);
    }
}