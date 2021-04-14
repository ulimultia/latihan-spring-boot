package com.week7.latihanspringboot.service;

import java.util.List;

import com.week7.latihanspringboot.model.dto.PersonDto;
import com.week7.latihanspringboot.model.entity.UserDetailsEntity;
import com.week7.latihanspringboot.model.entity.UsersEntity;

import org.springframework.http.ResponseEntity;

public interface UsersService {
    public ResponseEntity<?> registerUser(PersonDto dto);
    public List<UsersEntity> getAllUsers();
    public List<UserDetailsEntity> getAllUserDetails();
    public ResponseEntity<?> getUserDetails(String username);
    public ResponseEntity<?> updateUsername(String username, PersonDto dto);
    public ResponseEntity<?> updatePassword(String username, PersonDto dto);
    public ResponseEntity<?> updateUserDetails(String username, PersonDto dto);
    public ResponseEntity<?> deleteUserDetails(String username);
    public ResponseEntity<?> deleteUser(String username);
    public ResponseEntity<?> deleteDomisili(String username);

}
