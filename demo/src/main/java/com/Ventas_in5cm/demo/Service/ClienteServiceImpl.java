package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Cliente;
import com.Ventas_in5cm.demo.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente cliente) {
        Cliente existente = getClienteById(id);

        existente.setNombreCliente(cliente.getNombreCliente());
        existente.setApellidoCliente(cliente.getApellidoCliente());
        existente.setDireccion(cliente.getDireccion());
        existente.setEstado(cliente.getEstado());

        return clienteRepository.save(existente);
    }

    @Override
    public void deleteCliente(Integer id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no existe");
        }
        clienteRepository.deleteById(id);
    }
}