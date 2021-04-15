package com.week7.latihanspringboot.repository;

import com.week7.latihanspringboot.model.entity.Educations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationsRepository extends JpaRepository<Educations, Integer>{
    public Educations findByKodePendidikan(String kodePendidikan);
}
