package com.pichincha.bancario.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id")
    private Long id;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean Estado;

}
