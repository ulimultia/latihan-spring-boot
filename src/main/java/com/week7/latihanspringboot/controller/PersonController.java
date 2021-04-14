package com.week7.latihanspringboot.controller;

import com.week7.latihanspringboot.repository.PersonRepository;
import com.week7.latihanspringboot.service.PersonService;

import java.util.List;

import com.week7.latihanspringboot.model.dto.PersonDto;
import com.week7.latihanspringboot.model.entity.PersonEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService PersonService;

    // get all persons
    @GetMapping("/all")
    public List<PersonEntity> getPersons(){
        List<PersonEntity> persons = personRepository.findAll();
        return persons;
    }

    // get all firstname only
    @GetMapping("/all-firstname")
    public List<String> getFirstNameList(){
            // kode ini jika menggunakan fungsi dari query native pada kelas interface PersonRepository
            List<String> firstName = personRepository.getFirstName();
            return firstName;
        }

    // create person
    @PostMapping("/create")
    public ResponseEntity<?> createPerson(@RequestBody PersonDto personDto){
        PersonEntity personEntity = PersonService.insertData(personDto);
        return ResponseEntity.ok(personEntity);
    }

    // get by id
    @GetMapping("/search/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Integer id){
        PersonEntity personEntity = personRepository.findById(id).get();
        return ResponseEntity.ok(personEntity);
    }


    // update 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Integer id, @RequestBody PersonDto dto){
        PersonEntity personEntity = PersonService.editData(dto, id);
        return ResponseEntity.ok(personEntity);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleEntity(@PathVariable Integer id){
        PersonEntity personEntity = personRepository.findById(id).get();
        personRepository.delete(personEntity);
        return ResponseEntity.ok(personEntity);
    }
}
