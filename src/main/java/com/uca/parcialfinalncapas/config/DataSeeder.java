package com.uca.parcialfinalncapas.config;

import com.uca.parcialfinalncapas.entities.Ticket;
import com.uca.parcialfinalncapas.entities.User;
import com.uca.parcialfinalncapas.repository.TicketRepository;
import com.uca.parcialfinalncapas.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, TicketRepository ticketRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            System.out.println("Ejecutando seeder...");
            if (userRepository.count() == 0) {
                User user1 = User.builder()
                        .nombre("Juan Pérez")
                        .correo("user1@example.com")
                        .password(passwordEncoder.encode("user123"))
                        .nombreRol("USER")
                        .build();

                User tech1 = User.builder()
                        .nombre("Lucía Técnico")
                        .correo("tech1@example.com")
                        .password(passwordEncoder.encode("tech123"))
                        .nombreRol("TECH")
                        .build();

                userRepository.save(user1);
                userRepository.save(tech1);

                Ticket ticket1 = Ticket.builder()
                        .titulo("Problema con el mouse")
                        .descripcion("No funciona el botón izquierdo")
                        .estado("ABIERTO")
                        .usuarioId(user1.getId())
                        .fecha(LocalDateTime.now())
                        .build();

                Ticket ticket2 = Ticket.builder()
                        .titulo("Error de red")
                        .descripcion("No hay acceso a internet")
                        .estado("ABIERTO")
                        .usuarioId(user1.getId())
                        .fecha(LocalDateTime.now())
                        .build();

                ticketRepository.save(ticket1);
                ticketRepository.save(ticket2);
            }
        };
    }
}
