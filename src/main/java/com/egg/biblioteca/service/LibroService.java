package com.egg.biblioteca.service;

import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.entity.Editorial;
import com.egg.biblioteca.entity.Libro;
import com.egg.biblioteca.exception.ResourceNotFoundException;
import com.egg.biblioteca.repository.AutorRepository;
import com.egg.biblioteca.repository.EditorialRepository;
import com.egg.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class LibroService {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private LibroRepository libroRepository;


    @Transactional
    public Libro crearLibro(Long isbn, UUID idAutor, UUID idEditorial, String titulo, Integer ejemplares) throws Exception {

        validarTitulo(titulo);

        Optional<Autor> autorOptional = autorRepository.findById(idAutor);
        Optional<Editorial> editorialOptional = editorialRepository.findById(idEditorial);
        Optional<Libro> libroOptional = libroRepository.findById(isbn);
        Libro libroARegistrar = new Libro();

        if (libroOptional.isPresent()) {
            libroARegistrar.setIsbn(libroOptional.get().getIsbn());
        } else {
            throw new Exception("El Libro no existe verificar id: " + isbn);
        }

        if (autorOptional.isPresent()) {
            libroARegistrar.setAutor(autorOptional.get());
        } else {
            throw new Exception("El autor no existe verificar id: " + idAutor);
        }

        if (editorialOptional.isPresent()) {
            libroARegistrar.setEditorial(editorialOptional.get());
        } else {
            throw new Exception("La editorial no existe verificar id: " + idEditorial);
        }

        libroARegistrar.setTitulo(titulo);
        libroARegistrar.setEjemplares(ejemplares);
        libroARegistrar.setAlta(new Date());
        libroRepository.save(libroARegistrar);

        return libroARegistrar;

    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {

        List<Libro> libros = new ArrayList<>();

        libros = libroRepository.findAll();
        System.out.println("libros = " + libros);
        return libros;
    }


    @Transactional
    public Libro actualizarLibro(Long isbn, UUID idAutor, UUID idEditorial, String titulo, Integer ejemplares) throws ResourceNotFoundException {

        Libro libroAActualizar = libroRepository.findById(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("El libro no existe, verificar isdn :" + isbn));

        Autor autorAActualizar = autorRepository.findById(idAutor)
                .orElseThrow(() -> new ResourceNotFoundException("El autor no existe, verificar idAutor :" + idAutor));

        Editorial editorialActualizar = editorialRepository.findById(idEditorial)
                .orElseThrow(() -> new ResourceNotFoundException("La Editorial no existe, verificar idEditorial :" + idEditorial));


        libroAActualizar.setIsbn(isbn);
        libroAActualizar.setEditorial(editorialActualizar);
        libroAActualizar.setAutor(autorAActualizar);
        libroAActualizar.setTitulo(titulo);
        libroAActualizar.setEjemplares(ejemplares);

        Libro libroActualizado = libroRepository.save(libroAActualizar);
        System.out.println("libroActualizado = " + libroActualizado);

        return libroActualizado;
    }



    private void validarTitulo(String nombre) throws ResourceNotFoundException {
        if (nombre.isEmpty() || nombre == null) {
            throw new ResourceNotFoundException("el nombre no puede ser nulo o estar vacío");
        }
    }
}
