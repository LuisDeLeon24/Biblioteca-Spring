package com.luisDeleon.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisDeleon.webapp.biblioteca.model.Cliente;
import com.luisDeleon.webapp.biblioteca.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }
    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
    @Override
    public Cliente buscarClientePorId(Long DPI) {
        return clienteRepository.findById(DPI).orElse(null);
    }
}
