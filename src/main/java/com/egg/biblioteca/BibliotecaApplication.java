package com.egg.biblioteca;

import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.exception.DuplicateAutorException;
import com.egg.biblioteca.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {
    @Autowired
    private IAutorService autorService;

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    @Override
    public void run(String... args) throws DuplicateAutorException {
        //list
        autorService.listarAutores();
        //Register
        Autor autorARegistrar= new Autor();
        autorARegistrar.setNombre("Casse");
        autorService.registrarAutor(autorARegistrar);


    }
}
