package com.pichincha.clientes.controller;

import com.pichincha.clientes.services.IClienteServices;
import com.pichincha.clientes.services.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private IClienteServices clienteService;

    @PostMapping()
    public ResponseEntity<ClienteDTO> crearCliente(
            @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO createdCliente = clienteService.crearCliente(clienteDTO);
        return ResponseEntity.ok(createdCliente);
    }

    @PutMapping()
    public ResponseEntity<ClienteDTO> actualizarCliente(
            @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO updatedCliente = clienteService.actualizarCliente(clienteDTO);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping()
    public ResponseEntity<ClienteDTO> eliminarCliente(
            @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO deletedCliente = clienteService.eliminarCliente(clienteDTO);
        return ResponseEntity.ok(deletedCliente);
    }

}
