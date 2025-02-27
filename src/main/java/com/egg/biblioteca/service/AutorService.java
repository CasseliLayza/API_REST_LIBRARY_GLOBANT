package com.egg.biblioteca.service;

import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.exception.DuplicateAutorException;
import com.egg.biblioteca.exception.ResourceNotFoundException;
import com.egg.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService implements IAutorService {
    @Autowired
    private AutorRepository autorRepository;


    @Transactional
    public void crearAutor(String nombre) throws ResourceNotFoundException {

        validarNombre(nombre);

        Autor autor = new Autor();// Instancio un objeto del tipo Autor
        autor.setNombre(nombre);// Seteo el atributo, con el valor recibido como parámetro

        autorRepository.save(autor); // Persisto el dato en mi BBDD
    }


    @Transactional(readOnly = true)
    public List<Autor> listarAutoresSimple() {

        List<Autor> autors = new ArrayList<>();

        autors = autorRepository.findAll();
        return autors;
    }


    @Transactional
    public void modificarAutor(String nombre, UUID id) throws ResourceNotFoundException {

        validarNombre(nombre);

        Optional<Autor> respuesta = autorRepository.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();

            autor.setNombre(nombre);
            autorRepository.save(autor);
        }
    }


    private void validarNombre(String nombre) throws ResourceNotFoundException {
        if (nombre.isEmpty() || nombre == null) {
            throw new ResourceNotFoundException("el nombre no puede ser nulo o estar vacío");
        }
    }


    @Override
    public List<Autor> listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        System.out.println("Lista de autores:");
        for (Autor autor : autores) {
            System.out.println("autor = " + autor);

        }
        return autores;
    }


    @Override
    public Autor registrarAutor(Autor autor) throws DuplicateAutorException {

        Autor autorBuscado = autorRepository.findByNombre(autor.getNombre());

        if (autorBuscado != null) {
            throw new DuplicateAutorException("Autor existe en el sistema, verificar nombre: " + autor.getNombre());
        }

        Autor autorActualizado = autorRepository.save(autor);
        System.out.println("autorActualizado = " + autorActualizado);

        return autorActualizado;
    }

    @Override
    public Autor buscarAutor(UUID id) {

        Autor autorBuscado = autorRepository.findById(id)
                .orElseThrow();
        System.out.println("autorBuscado = " + autorBuscado);
        return autorBuscado;
    }


    @Override
    public Autor actualizarAutor(Autor autor, UUID id) {
        Autor autorAActualizar = buscarAutor(id);
        Autor autorActualizado = null;
        if (autorAActualizar == null)
            throw new RuntimeException("Autor no existe en el sistema, verificar id: " + id);

        autorAActualizar.setId(id);
        autorActualizado = autorRepository.save(autorAActualizar);

        return autorActualizado;
    }

    @Override
    public void eliminarAutor(UUID id) throws Exception {
        if (buscarAutor(id) != null) {
            autorRepository.deleteById(id);
        } else {
            throw new Exception("Autor no existe. verificar id: " + id);
        }

    }
}
