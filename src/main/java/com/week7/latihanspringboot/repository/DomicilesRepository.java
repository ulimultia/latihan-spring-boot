package com.week7.latihanspringboot.repository;

import com.week7.latihanspringboot.model.entity.Domiciles;
import com.week7.latihanspringboot.model.entity.UserDetailsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilesRepository extends JpaRepository<Domiciles, Integer>{
    // public Domiciles findByUserDetails(UserDetailsEntity detail);
    @Query(value = "SELECT * FROM domiciles where user_details = ?", nativeQuery = true)
    public Domiciles findByUserdetails(Integer id);
}
