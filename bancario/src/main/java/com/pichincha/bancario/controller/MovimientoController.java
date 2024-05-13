package com.pichincha.bancario.controller;

import com.pichincha.bancario.model.dto.MovimientoDTO;
import com.pichincha.bancario.services.IMovimientoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimiento")
@RequiredArgsConstructor
public class MovimientoController {

    private final IMovimientoServices movimientoServices;

    @PostMapping()
    public ResponseEntity<MovimientoDTO> crearMovimiento(
            @RequestBody MovimientoDTO MovimientoDTO) {
        MovimientoDTO createdMovimiento = movimientoServices.creaMovimiento(MovimientoDTO);
        return ResponseEntity.ok(createdMovimiento);
    }

    @PutMapping()
    public ResponseEntity<MovimientoDTO> actualizarMovimiento(
            @RequestBody MovimientoDTO MovimientoDTO) {
        MovimientoDTO updatedMovimiento = movimientoServices.actualizarMovimiento(MovimientoDTO);
        return ResponseEntity.ok(updatedMovimiento);
    }

    @DeleteMapping()
    public ResponseEntity<MovimientoDTO> eliminarMovimiento(
            @RequestBody MovimientoDTO MovimientoDTO) {
        MovimientoDTO deletedMovimiento = movimientoServices.eliminarMovimiento(MovimientoDTO);
        return ResponseEntity.ok(deletedMovimiento);
    }
    
}
