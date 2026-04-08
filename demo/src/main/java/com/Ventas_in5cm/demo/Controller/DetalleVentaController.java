package com.Ventas_in5cm.demo.Controller;

import com.Ventas_in5cm.demo.Entity.DetalleVenta;
import com.Ventas_in5cm.demo.Service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detalle")
public class DetalleVentaController {

    private final DetalleVentaService service;

    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleVenta> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DetalleVenta detalle) {
        return ResponseEntity.ok(service.save(detalle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DetalleVenta detalle) {
        return ResponseEntity.ok(service.update(id, detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("Detalle eliminado");
    }
}