package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//GET METHOD
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee>getAllEmployees(){
        return employeeRepository.findAll();
    }

    //POST METHOD
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //GET ELEMENT BY ID
    @GetMapping("{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable Long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exists with given id"+id));
        return  ResponseEntity.ok(employee);



    }
    //PUT METHOD
   @PutMapping("{id}")
    public ResponseEntity<Employee >updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id"+id));
        updateEmployee.setFname(employeeDetails.getFname());
        updateEmployee.setLname(employeeDetails.getLname());
        updateEmployee.setEmail(employeeDetails.getEmail());
       employeeRepository.save(updateEmployee);
       return ResponseEntity.ok(updateEmployee);

    }

    //DELETE METHOD
    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable long id){
     Employee employee=employeeRepository.findById(id)
             .orElseThrow(()->new ResourceNotFoundException("Employee not exists with id:"+id));
     employeeRepository.delete(employee);
     return  "user with given id has been deleted successfully"+id;

    }
}
