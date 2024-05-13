package com.pichincha.bancario.controller;


import com.pichincha.bancario.model.dto.CuentaDTO;
import com.pichincha.bancario.services.ICuentaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
@RequiredArgsConstructor
public class CuentaController {

    private final ICuentaServices cuentaServices;

    @PostMapping()
    public ResponseEntity<CuentaDTO> crearCuenta(@RequestBody CuentaDTO cuentaDTO) {
        CuentaDTO createdCuenta = cuentaServices.creaCuenta(cuentaDTO);
        return ResponseEntity.ok(createdCuenta
        );
    }

    @PutMapping()
    public ResponseEntity<CuentaDTO> actualizarCuenta(@RequestBody CuentaDTO CuentaDTO) {
        CuentaDTO updatedCuenta
                = cuentaServices.actualizarCuenta
                (CuentaDTO);
        return ResponseEntity.ok(updatedCuenta);
    }

    @DeleteMapping()
    public ResponseEntity<CuentaDTO> eliminarCuenta(@RequestBody CuentaDTO CuentaDTO) {
        CuentaDTO deletedCuenta
                = cuentaServices.eliminarCuenta
                (CuentaDTO);
        return ResponseEntity.ok(deletedCuenta);
    }

}
