package cl.duoc.HuechurabaBMW.controller;

import cl.duoc.HuechurabaBMW.dto.DTORepuestos;
import cl.duoc.HuechurabaBMW.model.ModelRepuestos;
import cl.duoc.HuechurabaBMW.service.ServiceRepuestos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repuestos")
public class ControllerRepuestos {

    @Autowired
    private ServiceRepuestos service;

    @PostMapping
    public ResponseEntity<ModelRepuestos> agregar(@RequestBody @Valid DTORepuestos dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ModelRepuestos>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelRepuestos> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/{id}/stock")
    public ResponseEntity<Integer> verStock(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id).getStock());
    }

    @PutMapping("/{id}/vender")
    public ResponseEntity<ModelRepuestos> vender(@PathVariable Long id) {
        return ResponseEntity.ok(service.vender(id));
    }

    @PutMapping("/{id}/stock/agregar")
    public ResponseEntity<ModelRepuestos> agregarStock(
            @PathVariable Long id,
            @RequestParam int cantidad) {

        return ResponseEntity.ok(service.agregarStock(id, cantidad));
    }
}