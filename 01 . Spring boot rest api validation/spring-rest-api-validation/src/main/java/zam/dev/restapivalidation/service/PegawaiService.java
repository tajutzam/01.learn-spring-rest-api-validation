package zam.dev.restapivalidation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zam.dev.restapivalidation.model.entity.Pegawai;
import zam.dev.restapivalidation.model.repo.PegawaiRepository;

import java.util.Optional;

@Service
public class PegawaiService {

    @Autowired
    private PegawaiRepository pegawaiRepository;

    public Iterable<Pegawai> findAll(){
        if(pegawaiRepository.findAll().isEmpty()){
            return null;
        }else{
            return pegawaiRepository.findAll();
        }
    }

    public Pegawai addPegawai(Pegawai pegawai){
        return pegawaiRepository.save(pegawai);
    }

    public Pegawai updatePegawai(Pegawai pegawai){
        return pegawaiRepository.save(pegawai);
    }

    public boolean delete(Long id){
        if(pegawaiRepository.findById(id).isPresent()){
            pegawaiRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Pegawai> searchById(Long id){
       if(pegawaiRepository.findById(id).isPresent()){
           return true;
       }else{
            pegawaiRepository.findById(id);
            return false;
       }
    }




}
