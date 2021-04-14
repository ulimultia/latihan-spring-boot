// package com.week7.latihanspringboot.controller;

// import com.week7.latihanspringboot.model.dto.MessagesDto;
// import com.week7.latihanspringboot.model.dto.PersonDto;
// import com.week7.latihanspringboot.model.entity.Domiciles;
// import com.week7.latihanspringboot.model.entity.UserDetailsEntity;
// import com.week7.latihanspringboot.model.entity.UsersEntity;
// import com.week7.latihanspringboot.repository.DomicilesRepository;
// import com.week7.latihanspringboot.repository.UserDetailsRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/domicile")
// public class DomicileController {
//     @Autowired private UserDetailsRepository detail;
//     @Autowired private UsersEntity user;
//     @Autowired private DomicilesRepository domisili;

//     // create
//     @PostMapping("/add/{username}")
//     public ResponseEntity<?> create(@PathVariable String username,@RequestBody PersonDto dto){
//         MessagesDto<Domiciles> result = new MessagesDto();
//         UsersEntity user = new UsersEntity();
//         UserDetailsEntity detail = new UserDetailsEntity();
//         Domiciles domisili = new Domiciles();

//         domisili.setAlamat(dto.getAlamat());
//         domisili.setRt(dto.getRt());
//         domisili.setRw(dto.getRw());
//         domisili.setKelurahan(dto.getKelurahan());
//         domisili.setKecamatan(dto.getKecamatan());
//         domisili.setProvinsi(dto.getProvinsi());

//         return ResponseEntity.ok(result);
//     }
//     // read
//     // update
//     // delete

// }
