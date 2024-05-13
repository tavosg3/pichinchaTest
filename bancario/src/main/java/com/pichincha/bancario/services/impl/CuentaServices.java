package com.pichincha.bancario.services.impl;

import com.pichincha.bancario.services.ICuentaServices;
import lombok.RequiredArgsConstructor;
import com.pichincha.bancario.model.Cuenta;
import com.pichincha.bancario.model.dto.CuentaDTO;
import com.pichincha.bancario.model.repository.CuentaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CuentaServices implements ICuentaServices {

    @Autowired
    CuentaJpaRepository cuentaRepository;

    @Override
    public List<CuentaDTO> listarCuenta() {
        return cuentaRepository.findAll().stream().map(cuenta -> CuentaDTO.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .Estado(cuenta.getEstado())
                .saldoInicial(cuenta.getSaldoInicial())
                .build()).collect(Collectors.toList());
    }

    @Override
    public CuentaDTO creaCuenta(CuentaDTO cuentaDTO) {

        Cuenta cuenta = cuentaRepository.save(Cuenta.builder()
                        .numeroCuenta(cuentaDTO.getNumeroCuenta())
                        .Estado(cuentaDTO.getEstado())
                        .tipoCuenta(cuentaDTO.getTipoCuenta())
                        .saldoInicial(cuentaDTO.getSaldoInicial())
                        .build());
        return CuentaDTO.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .Estado(cuenta.getEstado())
                .saldoInicial(cuenta.getSaldoInicial())
                .build();
    }

    @Override
    public CuentaDTO actualizarCuenta(CuentaDTO cuentaDTO) {

        Optional<Cuenta> cuentaUpdated =  cuentaRepository.findById(cuentaDTO.getId());
        if(cuentaUpdated.isPresent()){
            cuentaUpdated.get().setNumeroCuenta(cuentaDTO.getNumeroCuenta());
            cuentaUpdated.get().setTipoCuenta(cuentaDTO.getTipoCuenta());
            cuentaUpdated.get().setSaldoInicial(cuentaDTO.getSaldoInicial());
            cuentaUpdated.get().setEstado(cuentaDTO.getEstado());
        }

        Cuenta cuentaUpdated2 = cuentaRepository.save(cuentaUpdated.get());
        return CuentaDTO.builder()
                .numeroCuenta(cuentaUpdated2.getNumeroCuenta())
                .tipoCuenta(cuentaUpdated2.getTipoCuenta())
                .Estado(cuentaUpdated2.getEstado())
                .saldoInicial(cuentaUpdated2.getSaldoInicial())
                .build();
    }

    @Override
    public CuentaDTO eliminarCuenta(CuentaDTO cuentaDTO) {

        Optional<Cuenta> clienteDelete = cuentaRepository.findById(cuentaDTO.getId());
        cuentaRepository.delete(clienteDelete.get());
        return cuentaDTO;
    }
}
