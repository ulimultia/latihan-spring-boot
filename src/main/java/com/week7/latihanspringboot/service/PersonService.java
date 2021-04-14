package com.week7.latihanspringboot.service;

import com.week7.latihanspringboot.model.dto.PersonDto;
import com.week7.latihanspringboot.model.entity.PersonEntity;

public interface PersonService {
    public PersonEntity insertData(PersonDto dto);
    public PersonEntity editData(PersonDto dto, Integer id);
}
