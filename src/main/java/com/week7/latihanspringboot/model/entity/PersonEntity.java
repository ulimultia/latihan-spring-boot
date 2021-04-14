package com.week7.latihanspringboot.model.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id

    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String firstName;
    
    @Column(length = 50)
    private String lastName;

    @Column(length = 200)
    private String domisili;

    @Basic
    private Date tanggalLahir;

    @Basic
    private Timestamp createdAt;
    
    @Basic
    private Timestamp updatedAt;

    public PersonEntity(){}
    public PersonEntity(String fname, String lname, String domisili, Date tanggal){
        this.firstName = fname;
        this.lastName = lname;
        this.domisili = domisili;
        this.tanggalLahir = tanggal;
    }
    
    // setter dan getter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDomisili() {
        return domisili;
    }
    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }
    public Date getTanggalLahir() {
        return tanggalLahir;
    }
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }   
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
