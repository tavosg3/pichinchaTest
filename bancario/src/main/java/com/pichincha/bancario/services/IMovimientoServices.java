package com.pichincha.bancario.services;

import com.pichincha.bancario.model.dto.MovimientoDTO;

import java.util.List;

public interface IMovimientoServices {

    List<MovimientoDTO> listarMovimiento();
    MovimientoDTO creaMovimiento(MovimientoDTO movimientoDTO);
    MovimientoDTO actualizarMovimiento(MovimientoDTO movimientoDTO);
    MovimientoDTO eliminarMovimiento(MovimientoDTO movimientoDTO);
}
