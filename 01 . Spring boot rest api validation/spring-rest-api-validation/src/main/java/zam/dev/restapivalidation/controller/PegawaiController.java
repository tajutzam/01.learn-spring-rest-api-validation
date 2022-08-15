package zam.dev.restapivalidation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import zam.dev.restapivalidation.model.entity.Pegawai;
import zam.dev.restapivalidation.response.ResponsePegawai;
import zam.dev.restapivalidation.service.PegawaiService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/pegawai")
public class PegawaiController {

    @Autowired
    private PegawaiService pegawaiService;

    @GetMapping
    public String home(){
        return "Hello Controller";
    }
    @GetMapping("/all")
    public Iterable<Pegawai> showPegawai(){
        return pegawaiService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponsePegawai<Optional<Pegawai>>> fingByID(@PathVariable("id") Long id){
        ResponsePegawai <Optional<Pegawai>> responsePegawai = new ResponsePegawai<>();
       if(pegawaiService.searchById(id).isPresent()){
           responsePegawai.setStatus(true);
           responsePegawai.setPayLoad(pegawaiService.searchById(id));
           responsePegawai.setMessage(Collections.singletonList("Data Ketemu dek"));
           return ResponseEntity.ok(responsePegawai);
       }

        responsePegawai.setStatus(false);
        responsePegawai.setMessage(Collections.singletonList("Data dengan Id , "+id+"Tidak di temukan"));
        responsePegawai.setPayLoad(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsePegawai);

    }

    @PostMapping("/add")
    public ResponseEntity<ResponsePegawai<Pegawai>> add(@Valid @RequestBody Pegawai pegawai , Errors errors){
        ResponsePegawai<Pegawai> responsePegawai = new ResponsePegawai<>();
        if(errors.hasErrors()){
            for (var erorr: errors.getAllErrors()
                 ) {
                responsePegawai.getMessage().add(erorr.getDefaultMessage());
            }
            responsePegawai.setStatus(false);
            responsePegawai.setPayLoad(null);
        }else{
            responsePegawai.setStatus(true);
            responsePegawai.setMessage(Collections.singletonList("Succes Add"));
            responsePegawai.setPayLoad(pegawaiService.addPegawai(pegawai));
        }
        return ResponseEntity.ok(responsePegawai);
    }

    @PutMapping("/update")
    public Pegawai update(@Valid @RequestBody Pegawai pegawai){
        return pegawaiService.updatePegawai(pegawai);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponsePegawai<Pegawai>> deleteById(@PathVariable("id") Long id){
        ResponsePegawai<Pegawai> responsePegawai = new ResponsePegawai<>();
        if(pegawaiService.delete(id)){
            responsePegawai.setMessage(Collections.singletonList("Berhasil Menghapus Data Pegawai"));
            responsePegawai.setStatus(true);
            responsePegawai.setPayLoad(null);
            return ResponseEntity.ok(responsePegawai);
        }else{
            responsePegawai.setStatus(false);
            responsePegawai.setMessage(Collections.singletonList("gagal Menghapus data data tidak ada"));
            responsePegawai.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsePegawai);
        }
    }

}
