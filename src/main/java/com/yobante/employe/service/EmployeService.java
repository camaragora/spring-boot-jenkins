package com.yobante.employe.service;

import com.yobante.employe.model.Employe;
import com.yobante.employe.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository){
        this.employeRepository = employeRepository;
    }

    public Optional<Employe> getEmploye(final Long id) {
        return employeRepository.findById(id);
    }

    public Iterable<Employe> getEmployes() {
        return employeRepository.findAll();
    }

    public void deleteEmploye(final Long id) {
        employeRepository.deleteById(id);
    }

    public Employe saveEmployee(Employe employe) {
        Employe savedEmploye = employeRepository.save(employe);

        return savedEmploye;
    }
}
