package br.ml.simios.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "simios")
public class SimiosEntity {

    @Id
    @Column(name = "idt_simian", nullable = false)
    private UUID simianId;

    @Column(name = "des_dna", nullable = false)
    private String dna;

    @Column(name = "flg_simian", nullable = false)
    private boolean simian;

}
