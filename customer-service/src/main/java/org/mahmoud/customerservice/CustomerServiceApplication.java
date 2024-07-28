package org.mahmoud.customerservice;

import org.mahmoud.customerservice.configs.GlobalConfig;
import org.mahmoud.customerservice.entities.Customer;
import org.mahmoud.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .firstName("Mahmoud")
                    .lastName("Mesrar")
                    .email("mesrar.mahmoud@gmail.com")
                    .build()
            );
            customerRepository.save(Customer.builder()
                    .firstName("Mahmoud")
                    .lastName("Mesrar")
                    .email("mesrar.mahmoud@gmail.com")
                    .build()
            );

        };
    }


}
