package com.week7.latihanspringboot.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    // dari person, user, dan detail user
    private String firstName, lastName, domisili, nik, golDar, username, password;
    private Date tanggalLahir; 
    // dari domisili
    private String alamat, rt, rw, kelurahan, kecamatan, provinsi, kodePos;
}
