package com.Ventas_in5cm.demo.Controller;

import com.Ventas_in5cm.demo.Entity.Venta;
import com.Ventas_in5cm.demo.Service.VentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService){
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Venta> getAllVentas(){
        return ventaService.getAllVentas();
    }

    @PostMapping
    public ResponseEntity<Object> createVentas(@Valid @RequestBody Venta ventas){
        try{
            Venta createdVentas = ventaService.saveVentas(ventas);
            return new ResponseEntity<>(createdVentas, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVentas(@PathVariable Integer id){
        try {
            ventaService.deleteVentas(id);
            return ResponseEntity.ok("Venta eliminada correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVentas(@PathVariable Integer id, @Valid @RequestBody Venta ventas){
        try {
            Venta actualizado = ventaService.updateVentas(id, ventas);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}