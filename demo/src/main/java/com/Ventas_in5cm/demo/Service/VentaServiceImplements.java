package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Venta;
import com.Ventas_in5cm.demo.Repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImplements implements VentaService {

    private  VentaRepository ventaRepository;

    public VentaServiceImplements(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> getAllVentas(){
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentasById(Integer id){
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public Venta saveVentas(Venta venta){
        return ventaRepository.save(venta);
    }

    @Override
    public void deleteVentas(Integer id){
        if (!ventaRepository.existsById(id)){
            throw new RuntimeException("Venta no existe");
        }
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta updateVentas(Integer id, Venta venta){
        Venta existingVenta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La venta no existe"));

        existingVenta.setFechaVenta(venta.getFechaVenta());
        existingVenta.setTotal(venta.getTotal());
        existingVenta.setEstado(venta.getEstado());
        existingVenta.setClientesDpiCliente(venta.getClientesDpiCliente());
        existingVenta.setUsuariosCodigoUsuario(venta.getUsuariosCodigoUsuario());

        return ventaRepository.save(existingVenta);
    }
}