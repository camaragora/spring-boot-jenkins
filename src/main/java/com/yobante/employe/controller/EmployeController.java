package com.yobante.employe.controller;

import com.yobante.employe.model.Employe;
import com.yobante.employe.service.EmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeController {
    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    /**
     * Create - Add a new employee
     * @param employee An object employee
     * @return The employee object saved
     */
    @PostMapping("/employe")
    public Employe createEmploye(@RequestBody Employe employe) {
        return employeService.saveEmployee(employe);
    }


    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/employe/{id}")
    public Employe getEmploye(@PathVariable("id") final Long id) {
        Optional<Employe> employe = employeService.getEmploye(id);

        if(employe.isPresent()) {
            return employe.get();
        } else {
            return null;
        }

      //  return employe.orElse(null);
    }

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/employes")
    public Iterable<Employe> getEmployes() {
        return employeService.getEmployes();
    }

    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param employe - The employee object updated
     * @return
     */
    @PutMapping("/employe/{id}")
    public Employe updateEmploye(@PathVariable("id") final Long id, @RequestBody Employe employe) {
        Optional<Employe> e = employeService.getEmploye(id);

        if(e.isPresent()) {
            Employe currentEmploye = e.get();

            String prenom = employe.getPrenom();

            if(prenom != null) {
                currentEmploye.setPrenom(prenom);
            }

            String nom = employe.getNom();

            if(nom != null) {
                currentEmploye.setPrenom(prenom);
            }

            String email = employe.getEmail();

            if(email != null) {
                currentEmploye.setEmail(email);
            }

            employeService.saveEmployee(currentEmploye);
            return currentEmploye;

        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/employse/{id}")
    public void deleteEmploye(@PathVariable("id") final Long id) {
        employeService.deleteEmploye(id);
    }
}
