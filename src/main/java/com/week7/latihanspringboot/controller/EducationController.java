package com.week7.latihanspringboot.controller;

import java.util.List;

import com.week7.latihanspringboot.model.dto.EducationsDto;
import com.week7.latihanspringboot.model.entity.Educations;
import com.week7.latihanspringboot.model.entity.UsersEntity;
import com.week7.latihanspringboot.repository.EducationsRepository;
import com.week7.latihanspringboot.repository.UsersRepository;

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
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private EducationsRepository eduRepo;
    @Autowired
    private UsersRepository userRepo;

    // create pendidikan
    @PostMapping("/add")
    public ResponseEntity<?> addEducation(@RequestBody EducationsDto dto){
        Educations edu = new Educations();
        UsersEntity user = userRepo.findByUsername(dto.getUsername());
        
        edu.setKodePendidikan("P"+edu.getId());
        edu.setJenjang(dto.getJenjang());
        edu.setInstitusi(dto.getInstitusi());
        edu.setUser(user);
        eduRepo.save(edu);

        // edit kodePendidikan
        edu.setKodePendidikan("P"+edu.getId());
        eduRepo.save(edu);
        return ResponseEntity.ok("Berhasil ditambahakan...!");
    }

    // read all pendidikan
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Educations> educations = eduRepo.findAll();
        return ResponseEntity.ok(educations);
    }

    // update pendidikan
    @PutMapping("/edit/{kodePendidikan}")
    public ResponseEntity<?> editEducation(@PathVariable String kodePendidikan, @RequestBody EducationsDto dto){
        Educations edu = eduRepo.findByKodePendidikan(kodePendidikan);
        
       
        edu.setJenjang(dto.getJenjang());
        edu.setInstitusi(dto.getInstitusi());
        eduRepo.save(edu);

        return ResponseEntity.ok("Berhasil diubah...!");
    }

    // delete pendidikan
    @DeleteMapping ("delete/{kodePendidikan}")
    public ResponseEntity<?> removeEducation(@PathVariable String kodePendidikan){
        Educations edu = eduRepo.findByKodePendidikan(kodePendidikan);
        eduRepo.delete(edu);
        return ResponseEntity.ok("Berhasil dihapus...!");
    }
}
