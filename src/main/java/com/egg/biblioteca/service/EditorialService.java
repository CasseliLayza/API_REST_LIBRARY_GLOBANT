package com.egg.biblioteca.service;

import com.egg.biblioteca.entity.Editorial;
import com.egg.biblioteca.exception.ResourceNotFoundException;
import com.egg.biblioteca.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Transactional
    public void crearEditorial(String nombre) throws ResourceNotFoundException {

        validarNombre(nombre);

        Editorial editorial = new Editorial();// Instancio un objeto del tipo Autor
        editorial.setNombre(nombre);// Seteo el atributo, con el valor recibido como parámetro


        editorialRepository.save(editorial); // Persisto el dato en mi BBDD
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {

        List<Editorial> editorials = new ArrayList<>();

        editorials = editorialRepository.findAll();
        return editorials;
    }

    @Transactional
    public void modificarAutor(String nombre, UUID id) throws ResourceNotFoundException {

        validarNombre(nombre);

        Optional<Editorial> editorialOptional = editorialRepository.findById(id);
        if (editorialOptional.isPresent()) {
            Editorial editorial = editorialOptional.get();

            editorial.setNombre(nombre);
            editorialRepository.save(editorial);
        }
    }

    private void validarNombre(String nombre) throws ResourceNotFoundException {
        if (nombre.isEmpty() || nombre == null) {
            throw new ResourceNotFoundException("el nombre no puede ser nulo o estar vacío");
        }
    }

}
