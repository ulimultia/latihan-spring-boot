package com.week7.latihanspringboot.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "domiciles")
public class Domiciles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String alamat;

    @Column
    private String rt;

    @Column
    private String rw;

    @Column
    private String kelurahan;

    @Column
    private String kecamatan;

    @Column
    private String provinsi;

    @Column
    private String kodePos;

    @OneToOne
    @JoinColumn(name = "userDetails", referencedColumnName = "id")
    private UserDetailsEntity details;
}
