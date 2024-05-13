package com.pichincha.bancario.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CuentaDTO {

    private Long id;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean Estado;

}
