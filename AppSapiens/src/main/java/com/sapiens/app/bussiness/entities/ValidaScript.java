package com.sapiens.app.bussiness.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@Entity
public class ValidaScript {

    @Id
    @Column
    private String nombreScript;

    @Column
    private String script;

    @Column
    private String codigoDemanda;

    @Column
    private String codigoSd;

    @Column
    private String codigoModelo;

    @Column
    private String codigoSubModelo;

    @Column
    private String usuario;

}
