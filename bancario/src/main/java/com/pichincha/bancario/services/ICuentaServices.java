package com.pichincha.bancario.services;

import com.pichincha.bancario.model.dto.CuentaDTO;

import java.util.List;

public interface ICuentaServices {

    List<CuentaDTO> listarCuenta();
    CuentaDTO creaCuenta(CuentaDTO cuentaDTO);
    CuentaDTO actualizarCuenta(CuentaDTO cuentaDTO);
    CuentaDTO eliminarCuenta(CuentaDTO cuentaDTO);

}
