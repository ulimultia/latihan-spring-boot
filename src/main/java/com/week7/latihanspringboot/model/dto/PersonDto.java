package com.week7.latihanspringboot.model.dto;

import java.sql.Date;

public class PersonDto {
    private String firstName, lastName, domisili;
    private Date tanggalLahir;

    // konstruktor
    public PersonDto(){}
    public PersonDto(String fName, String lName, String domisili, Date tanggal){
        this.firstName = fName;
        this.lastName = lName;
        this.domisili = domisili;
        this.tanggalLahir = tanggal;
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
}
