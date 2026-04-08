package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> getAllClientes();

    Cliente getClienteById(Integer id);

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Integer id, Cliente cliente);

    void deleteCliente(Integer id);
}