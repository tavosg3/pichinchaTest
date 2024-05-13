package com.pichincha.bancario.services.impl;

import com.pichincha.bancario.services.IMovimientoServices;
import lombok.RequiredArgsConstructor;
import com.pichincha.bancario.model.Movimiento;
import com.pichincha.bancario.model.dto.MovimientoDTO;
import com.pichincha.bancario.model.repository.MovimientoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MovimientoServices implements IMovimientoServices {

    @Autowired
    MovimientoJpaRepository movimientoJpaRepository;

    @Override
    public List<MovimientoDTO> listarMovimiento() {
        return movimientoJpaRepository.findAll().stream().map(movimiento -> MovimientoDTO.builder()
                .idMovimiento(movimiento.getIdMovimiento())
                .fecha(movimiento.getFecha())
                .tipo(movimiento.getTipo())
                .saldo(movimiento.getSaldo())
                .valor(movimiento.getValor())
                .build()).collect(Collectors.toList());
    }

    @Override
    public MovimientoDTO creaMovimiento(MovimientoDTO movimientoDTO) {

        Movimiento movimiento = movimientoJpaRepository.save(Movimiento.builder()
                .idMovimiento(movimientoDTO.getIdMovimiento())
                .fecha(movimientoDTO.getFecha())
                .tipo(movimientoDTO.getTipo())
                .saldo(movimientoDTO.getSaldo())
                .valor(movimientoDTO.getValor())
                .build());
        return MovimientoDTO.builder()
                .idMovimiento(movimiento.getIdMovimiento())
                .fecha(movimiento.getFecha())
                .saldo(movimiento.getSaldo())
                .valor(movimiento.getValor())
                .build();
    }

    @Override
    public MovimientoDTO actualizarMovimiento(MovimientoDTO movimientoDTO) {
        Optional<Movimiento> movimientoUpdated =  movimientoJpaRepository.findById(movimientoDTO.getIdMovimiento());
        if(movimientoUpdated.isPresent()){
            movimientoUpdated.get().setTipo(movimientoDTO.getTipo());
            movimientoUpdated.get().setValor(movimientoDTO.getValor());
            movimientoUpdated.get().setSaldo(movimientoDTO.getSaldo());
        }

        Movimiento movimiento = movimientoJpaRepository.save(movimientoUpdated.get());
        return MovimientoDTO.builder()
                .idMovimiento(movimiento.getIdMovimiento())
                .fecha(movimiento.getFecha())
                .saldo(movimiento.getSaldo())
                .valor(movimiento.getValor())
                .build();
    }

    @Override
    public MovimientoDTO eliminarMovimiento(MovimientoDTO movimientoDTO) {
        return null;
    }
}
