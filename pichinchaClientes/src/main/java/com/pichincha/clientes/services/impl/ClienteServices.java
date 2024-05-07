package com.pichincha.clientes.services.impl;

import com.pichincha.clientes.model.Cliente;
import com.pichincha.clientes.model.repository.ClienteJpaRepository;
import com.pichincha.clientes.services.IClienteServices;
import com.pichincha.clientes.services.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServices implements IClienteServices {

    @Autowired
    private ClienteJpaRepository clienteRepository;

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {

        Cliente clienteCreated = clienteRepository.save(Cliente.builder()
                .direccion(clienteDTO.getDireccion())
                .estado(clienteDTO.getEstado())
                .genero(clienteDTO.getGenero())
                .edad(clienteDTO.getEdad())
                .nombre(clienteDTO.getNombre())
                .telefono(clienteDTO.getTelefono())
                .contrasena(clienteDTO.getContrasena())
                .estado(clienteDTO.getEstado())
                .build());

        return ClienteDTO.builder()
                .direccion(clienteCreated.getDireccion())
                .edad(clienteCreated.getEdad())
                .estado(clienteCreated.getEstado())
                .genero(clienteCreated.getGenero())
                .nombre(clienteCreated.getNombre())
                .telefono(clienteCreated.getTelefono())
                .build();
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) {

        Optional<Cliente> clienteUpdate = clienteRepository.findById(clienteDTO.getClienteid());
        if (clienteUpdate.isPresent()) {
            clienteUpdate.get().setDireccion(clienteDTO.getDireccion());
            clienteUpdate.get().setEdad(clienteDTO.getEdad());
            clienteUpdate.get().setEstado(clienteDTO.getEstado());
            clienteUpdate.get().setGenero(clienteDTO.getGenero());
            clienteUpdate.get().setNombre(clienteDTO.getNombre());
            clienteUpdate.get().setTelefono(clienteDTO.getTelefono());
        }

        Cliente clienteUpdated = clienteRepository.save(clienteUpdate.get());

        return ClienteDTO.builder()
                .direccion(clienteUpdated.getDireccion())
                .edad(clienteUpdated.getEdad())
                .estado(clienteUpdated.getEstado())
                .genero(clienteUpdated.getGenero())
                .nombre(clienteUpdated.getNombre())
                .telefono(clienteUpdated.getTelefono())
                .build();
    }

    @Override
    public ClienteDTO eliminarCliente(ClienteDTO clienteDTO) {

        Optional<Cliente> clienteDelete = clienteRepository.findById(clienteDTO.getClienteid());
        clienteRepository.delete(clienteDelete.get());
        return clienteDTO;
    }
}
