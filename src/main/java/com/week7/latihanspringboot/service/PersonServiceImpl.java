package com.week7.latihanspringboot.service;

import java.sql.Timestamp;
import java.time.Instant;

import com.week7.latihanspringboot.model.dto.PersonDto;
import com.week7.latihanspringboot.model.entity.PersonEntity;
import com.week7.latihanspringboot.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonEntity insertData(PersonDto dto) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setFirstName(dto.getFirstName());
        personEntity.setLastName(dto.getLastName());
        personEntity.setDomisili(dto.getDomisili());
        personEntity.setTanggalLahir(dto.getTanggalLahir());

        personEntity.setCreatedAt(Timestamp.from(Instant.now()));
        personEntity.setUpdatedAt(personEntity.getCreatedAt());

        personRepository.save(personEntity);
        return personEntity;
    }

    @Override
    public PersonEntity editData(PersonDto dto, Integer id) {
        PersonEntity personEntity = personRepository.findById(id).get();

        personEntity.setFirstName(dto.getFirstName());
        personEntity.setLastName(dto.getLastName());
        personEntity.setDomisili(dto.getDomisili());
        personEntity.setTanggalLahir(dto.getTanggalLahir());
        personEntity.setUpdatedAt(Timestamp.from(Instant.now()));

        personRepository.save(personEntity);
        return personEntity;
    }
    
}
