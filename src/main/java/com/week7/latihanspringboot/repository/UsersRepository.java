package com.week7.latihanspringboot.repository;

import com.week7.latihanspringboot.model.entity.UsersEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer>{
    public UsersEntity findByUsername(String username);
}
