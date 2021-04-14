package com.week7.latihanspringboot.controller;

import java.util.List;

import com.week7.latihanspringboot.model.dto.MessagesDto;
import com.week7.latihanspringboot.model.dto.PersonDto;
import com.week7.latihanspringboot.model.entity.Domiciles;
import com.week7.latihanspringboot.model.entity.UserDetailsEntity;
import com.week7.latihanspringboot.model.entity.UsersEntity;
import com.week7.latihanspringboot.repository.UserDetailsRepository;
import com.week7.latihanspringboot.repository.UsersRepository;
import com.week7.latihanspringboot.service.UsersService;
import com.week7.latihanspringboot.service.UsersServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestController
@RequestMapping("/user")
public class UsersController {
    // @Autowired
    // private UsersRepository usersRepository;
    // @Autowired
    // private UserDetailsRepository userDetailsRepository;
    @Autowired
    private UsersService usersService;

    // registrasi pengguna
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody PersonDto dto){
        MessagesDto<UsersEntity> result = new MessagesDto();
        try {
            return usersService.registerUser(dto);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    // tampil semua pengguna
    @GetMapping("/all-users")
    public List<UsersEntity> getAllUser(){
        return usersService.getAllUsers();
    }

    // tampil semua detail pengguna
    @GetMapping("/all-details")
    public List<UserDetailsEntity> getAllUserDetails(){
        return usersService.getAllUserDetails();
    }

    // tampil detail user berdasarkan usernmame
    @GetMapping("/search/{username}")
    public ResponseEntity<?> getUserDetails(@PathVariable String username){
        MessagesDto<UserDetailsEntity> result = new MessagesDto();
        try {
            return usersService.getUserDetails(username);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    // update data username
    @PutMapping("change/username/{username}")
    public ResponseEntity<?> updateUsername(@PathVariable String username, @RequestBody PersonDto dto){
        MessagesDto<UsersEntity> result = new MessagesDto();
        try {
            return usersService.updateUsername(username, dto);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    // update data password
    @PutMapping("change/password/{username}")
    public ResponseEntity<?> updatePassword(@PathVariable String username, @RequestBody PersonDto dto){
        MessagesDto<UsersEntity> result = new MessagesDto();
        try {
            return usersService.updatePassword(username, dto);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    // update detail user
    @PutMapping("change/detail/{username}")
    public ResponseEntity<?> updateUserDetails(@PathVariable String username, @RequestBody PersonDto dto){
        MessagesDto<UserDetailsEntity> result = new MessagesDto();
        try {
            return usersService.updateUserDetails(username, dto);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    // delete domisili user
    // @DeleteMapping("delete/domisili/{username}")
    // public ResponseEntity<?> deleteDomisili(@PathVariable String username){
    //     MessagesDto<Domiciles> result = new MessagesDto();
    //     try {
    //         return usersService.deleteDomisili(username);
    //     } catch (Exception e) {
    //         result.setMessage(e.getMessage());
    //         return ResponseEntity.badRequest().body(result);
    //     }
    // }

    // delete detail user
    @DeleteMapping("delete/detail/{username}")
    public ResponseEntity<?> deleteUserDetails(@PathVariable String username){
        MessagesDto<UserDetailsEntity> result = new MessagesDto();
        try {
            return usersService.deleteUserDetails(username);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    // delete user dan detailnya serta domisilinya
    @DeleteMapping("delete/user/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username){
        MessagesDto<UsersEntity> result = new MessagesDto();
        try {
            return usersService.deleteUser(username);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
}
