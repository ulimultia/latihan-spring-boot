package com.week7.latihanspringboot.repository;

import java.util.List;

import com.week7.latihanspringboot.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer>{
    // bisa ditambahkan query sesuai kebutuhan
    @Query(value = "SELECT first_name from persons", nativeQuery = true)
    public List<String> getFirstName();

    // dengan parameter
    @Query(value = "SELECT first_name from persons where id=?", nativeQuery = true)
    public List<String> getFirstName(String firstName); //overloading
}
