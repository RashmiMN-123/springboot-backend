package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
    @Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String...args)throws Exception{
		Employee employee =new Employee();
		employee.setFname("ABC");
		employee.setLname("Rao");
		employee.setEmail("abc@gmail.com");
		employeeRepository.save(employee);


		Employee employee1 =new Employee();
		employee1.setFname("JOHN");
		employee1.setLname("CENA");
		employee1.setEmail("johncena@gmail.com");
		employeeRepository.save(employee1);
	}


}
