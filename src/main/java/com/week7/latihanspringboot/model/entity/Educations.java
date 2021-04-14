package com.week7.latihanspringboot.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "educations")
public class Educations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String kodePendidikan;

    @Column
    private String jenjang;

    @Column
    private String institusi;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UsersEntity user;

    public Educations(String kode, String jenjang, String institusi, UsersEntity user){
        this.kodePendidikan = kode;
        this.jenjang = jenjang;
        this.institusi = institusi;
        this.user = user;
    }
}
