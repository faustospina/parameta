package com.parameta.demo.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Employee")
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="nombres")
    private String nombres;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="tipo_documento")
    private String tipoDocumento;
    @Column(name="numero_documento")
    private String numeroDocumento;
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name="fecha_vinculacion")
    private Date fechaVinculacion;
    @Column(name="cargo")
    private String cargo;
    @Column(name="salario")
    private double salario;



}
