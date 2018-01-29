package com.intive.training.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.Data;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Data
@Table(name = "customers")
@Entity
class Customer {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;
	private String email;
}

@RepositoryRestResource
interface CustomerInterface extends JpaRepository<Customer, Long> {

}