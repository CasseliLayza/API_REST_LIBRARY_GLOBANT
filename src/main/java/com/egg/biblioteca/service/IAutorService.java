package com.egg.biblioteca.service;

import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.exception.DuplicateAutorException;

import java.util.List;
import java.util.UUID;

public interface IAutorService {

    List<Autor> listarAutores();

    Autor registrarAutor(Autor autor) throws DuplicateAutorException;

    Autor buscarAutor(UUID id) throws Exception;

    Autor actualizarAutor(Autor autor, UUID id);

    void eliminarAutor(UUID id) throws Exception;

}
