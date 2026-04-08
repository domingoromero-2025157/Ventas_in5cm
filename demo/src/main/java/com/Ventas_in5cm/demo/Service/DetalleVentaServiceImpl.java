package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.*;
import com.Ventas_in5cm.demo.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleVentaRepository repository;
    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final VentaRepository ventaRepository;

    public DetalleVentaServiceImpl(
            DetalleVentaRepository repository,
            ProductoRepository productoRepository,
            ClienteRepository clienteRepository,
            UsuarioRepository usuarioRepository,
            VentaRepository ventaRepository) {

        this.repository = repository;
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<DetalleVenta> getAll() {
        return repository.findAll();
    }

    @Override
    public DetalleVenta getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
    }

    @Override
    public DetalleVenta save(DetalleVenta detalleVenta) {
        return repository.save(detalleVenta);
    }

    @Override
    public DetalleVenta update(Integer id, DetalleVenta detalleVenta) {

        DetalleVenta existente = getById(id);

        existente.setCantidad(detalleVenta.getCantidad());
        existente.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        existente.setSubtotal(detalleVenta.getSubtotal());



        Producto producto = productoRepository.findById(
                detalleVenta.getProducto().getCodigoProductos()
        ).orElseThrow(() -> new RuntimeException("Producto no existe"));

        Cliente cliente = clienteRepository.findById(
                detalleVenta.getCliente().getDpiCliente()
        ).orElseThrow(() -> new RuntimeException("Cliente no existe"));

        Usuario usuario = usuarioRepository.findById(
                detalleVenta.getUsuario().getCodigoUsuario()
        ).orElseThrow(() -> new RuntimeException("Usuario no existe"));

        Venta venta = ventaRepository.findById(
                detalleVenta.getVenta().getCodigoVenta()
        ).orElseThrow(() -> new RuntimeException("Venta no existe"));

        existente.setProducto(producto);
        existente.setCliente(cliente);
        existente.setUsuario(usuario);
        existente.setVenta(venta);

        return repository.save(existente);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Detalle no existe");
        }
        repository.deleteById(id);
    }
}