package br.com.zallpy.controller;

import br.com.zallpy.model.dto.RegisterDTO;
import br.com.zallpy.model.entity.Register;
import br.com.zallpy.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/registers")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public ResponseEntity<List<RegisterDTO>> findAll() {
        List<Register> registerList = registerService.findAll();
        List<RegisterDTO> registerDTOList = registerList.stream().
                map(driver -> new RegisterDTO(driver)).collect(Collectors.toList());
        return ResponseEntity.ok().body(registerDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RegisterDTO> findById(@PathVariable Long id) {
        Register register = this.registerService.findById(id);
        return ResponseEntity.ok().body(new RegisterDTO(register));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RegisterDTO> update(@PathVariable Long id, @RequestBody RegisterDTO driverDTO) {
        Register register = registerService.update(id, driverDTO);
        return ResponseEntity.ok().body(new RegisterDTO(register));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<RegisterDTO> delete(@PathVariable Long id) {
        registerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
