package br.com.zallpy.service;


import br.com.zallpy.model.dto.RegisterDTO;
import br.com.zallpy.model.entity.Register;
import br.com.zallpy.repository.RegisterRepository;
import br.com.zallpy.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    public List<Register> findAll() {
        return registerRepository.findAll();
    }

    public Register findById(Long id) {
        Optional<Register> driverOptional = registerRepository.findById(id);
        return driverOptional.orElseThrow(() -> new ObjectNotFoundException("register id " + id + " not found"));
    }

    public Register update(Long id, RegisterDTO registerDTO) {
        registerDTO.setId(id);
        Register oldRegister = findById(id);
        oldRegister = new Register(registerDTO);
        return registerRepository.save(oldRegister);
    }

    public void delete(Long id) {
        Register driver = findById(id);
        registerRepository.deleteById(id);
    }

}
