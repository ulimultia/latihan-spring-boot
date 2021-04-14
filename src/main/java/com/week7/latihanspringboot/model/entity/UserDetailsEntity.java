package com.week7.latihanspringboot.model.entity;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="user_details")
public class UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String domisili;

    @Column
    private String nik;

    @Column
    private String golDar;

    @Basic
    private Date tanggalLahir;
    
    @OneToOne
    // tambah referenceColumnName jika menggunakan selain id primary key
    @JoinColumn(name = "userId", referencedColumnName = "username")
    private UsersEntity user;

    // konstruktor
    public UserDetailsEntity(String fname, String lname, String domisili, String nik, String golDar, Date tgl){
        this.firstName = fname;
        this.lastName = lname;
        this.domisili = domisili;
        this.nik = nik;
        this.golDar = golDar;
        this.tanggalLahir = tgl;
    }
}
