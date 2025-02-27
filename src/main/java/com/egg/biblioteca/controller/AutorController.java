package com.egg.biblioteca.controller;

import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.exception.DuplicateAutorException;
import com.egg.biblioteca.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autors")
public class AutorController {
    @Autowired
    private IAutorService autorService;

    @GetMapping("/list")
    public List<Autor> listarAutores() {
        return autorService.listarAutores();
    }

    @PostMapping("register")
    public Autor registrarAutor(@RequestBody Autor autor) throws DuplicateAutorException {
        return autorService.registrarAutor(autor);
    }


}
