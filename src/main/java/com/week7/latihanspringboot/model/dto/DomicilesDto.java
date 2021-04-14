package com.week7.latihanspringboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomicilesDto {
    private String alamat, rt, rw, kelurahan, kecamatan, provinsi, kodePos;
}
