package com.pichincha.clientes.services;

import com.pichincha.clientes.services.dto.ClienteDTO;

public interface IClienteServices {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO actualizarCliente(ClienteDTO clienteDTO);

    ClienteDTO eliminarCliente(ClienteDTO clienteDTO);

}
