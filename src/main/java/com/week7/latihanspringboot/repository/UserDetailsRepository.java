package com.week7.latihanspringboot.repository;

import com.week7.latihanspringboot.model.entity.UserDetailsEntity;
import com.week7.latihanspringboot.model.entity.UsersEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Integer>{
    public UserDetailsEntity findByUser(UsersEntity user);
}
