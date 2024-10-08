package com.luisDeleon.webapp.biblioteca.service;

import java.util.List;

import com.luisDeleon.webapp.biblioteca.model.Cliente;

public interface IClienteService {
    public List<Cliente> listarClientes();

    public Cliente buscarClientePorId(long id);

    public Cliente guardarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);
}
