package com.week7.latihanspringboot.service;

import java.util.List;

import com.week7.latihanspringboot.model.dto.MessagesDto;
import com.week7.latihanspringboot.model.dto.PersonDto;
import com.week7.latihanspringboot.model.entity.Domiciles;
import com.week7.latihanspringboot.model.entity.UserDetailsEntity;
import com.week7.latihanspringboot.model.entity.UsersEntity;
import com.week7.latihanspringboot.repository.DomicilesRepository;
import com.week7.latihanspringboot.repository.UserDetailsRepository;
import com.week7.latihanspringboot.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired 
    private DomicilesRepository domicilesRepository;
    
    @Override
    public ResponseEntity<?> registerUser(PersonDto dto) {
        MessagesDto<UsersEntity> result = new MessagesDto();
        if(dto.getNik().length() !=16){
            result.setStatus(HttpStatus.BAD_REQUEST.value());
            result.setMessage("NIK harus 16 digit!");
            return ResponseEntity.badRequest().body(result);
        }
        // buat obyek dari entity class
        UsersEntity user = new UsersEntity();
        UserDetailsEntity userDetail = new UserDetailsEntity();
        Domiciles domisili = new Domiciles();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        // simpan data user terlebih dahulu
        usersRepository.save(user);

        userDetail.setNik(dto.getNik());
        userDetail.setFirstName(dto.getFirstName());
        userDetail.setLastName(dto.getLastName());
        userDetail.setTanggalLahir(dto.getTanggalLahir());
        userDetail.setDomisili(dto.getDomisili());
        userDetail.setGolDar(dto.getGolDar());
        userDetail.setUser(user); // menyambungan pk dan fk ===> ambil id usernya
        // menyimpan data detail dari user
        userDetailsRepository.save(userDetail);

        domisili.setAlamat(dto.getAlamat());
        domisili.setRt(dto.getRt());
        domisili.setRw(dto.getRw());
        domisili.setKelurahan(dto.getKelurahan());
        domisili.setKecamatan(dto.getKecamatan());
        domisili.setProvinsi(dto.getProvinsi());
        domisili.setKodePos(dto.getKodePos());
        // menyimpan data domisili lengkap
        domisili.setDetails(userDetail);
        domicilesRepository.save(domisili);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Registrasi berhasil...!");
        result.setData(user);
        return ResponseEntity.ok(result);
    }
    
    // tampil semua pengguna
    public List<UsersEntity> getAllUsers(){
        List<UsersEntity> users = usersRepository.findAll();
        return users;
    }

    // tampil semua detail pengguna
    public List<UserDetailsEntity> getAllUserDetails(){
        List<UserDetailsEntity> details = userDetailsRepository.findAll();
        return details;
    }

    // tampil detail user berdasarkan usernmame
    public ResponseEntity<?> getUserDetails(String username){
        UsersEntity user = usersRepository.findByUsername(username);
        UserDetailsEntity detail = userDetailsRepository.findByUser(user);

        MessagesDto<UserDetailsEntity> result = new MessagesDto();
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Detail user ditemukan!");
        result.setData(detail);
        return ResponseEntity.ok(result);
    }

    // update data username ===> BELUM BERHASIL
    public ResponseEntity<?> updateUsername(String username, PersonDto dto){
        UsersEntity user = usersRepository.findByUsername(username);

        user.setUsername(dto.getUsername());
        usersRepository.save(user);

        return ResponseEntity.ok("Username berhasil diubah ... !");
    }

    // update data password
    public ResponseEntity<?> updatePassword(String username, PersonDto dto){
        UsersEntity user = usersRepository.findByUsername(username);

        user.setPassword(dto.getPassword());
        usersRepository.save(user);

        return ResponseEntity.ok("Password berhasil diubah ... !");
    }

    // update detail user
    public ResponseEntity<?> updateUserDetails(String username, PersonDto dto){
        UsersEntity user = usersRepository.findByUsername(username);
        UserDetailsEntity detail = userDetailsRepository.findByUser(user);

        detail.setFirstName(dto.getFirstName());
        detail.setLastName(dto.getLastName());
        detail.setDomisili(dto.getDomisili());
        detail.setNik(dto.getNik());
        detail.setGolDar(dto.getGolDar());
        detail.setTanggalLahir(dto.getTanggalLahir());
       
        userDetailsRepository.save(detail);

        return ResponseEntity.ok("Detail pengguna berhasil diubah ... !");
    }

    // delete detail user
    public ResponseEntity<?> deleteUserDetails(String username){
        UsersEntity user = usersRepository.findByUsername(username);
        UserDetailsEntity detail = userDetailsRepository.findByUser(user);

        userDetailsRepository.delete(detail);
        return ResponseEntity.ok("Berhasil dihapus ... !");
    }

    // delete user dan detailnya serta domisilinya berdasarkan username
    public ResponseEntity<?> deleteUser(String username){
        UsersEntity user = usersRepository.findByUsername(username);
        UserDetailsEntity detail = userDetailsRepository.findByUser(user);
        // Domiciles domisili = domicilesRepository.findByUserDetails(detail);
        Domiciles domisili = domicilesRepository.findByUserdetails(detail.getId());

        userDetailsRepository.delete(detail);
        usersRepository.delete(user);
        domicilesRepository.delete(domisili);
        return ResponseEntity.ok("Berhasil dihapus ... !");
    }

    @Override
    public ResponseEntity<?> deleteDomisili(String username) {
        UsersEntity user = usersRepository.findByUsername(username);
        UserDetailsEntity detail = userDetailsRepository.findByUser(user);
        // Domiciles domisili = domicilesRepository.findByUserDetails(detail);
        Domiciles domisili = domicilesRepository.findByUserdetails(detail.getId());

        domicilesRepository.delete(domisili);
        return ResponseEntity.ok("Berhasil dihapus ... !");
    }
}
