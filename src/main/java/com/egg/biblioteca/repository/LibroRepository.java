package com.egg.biblioteca.repository;

import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo);

    List<Autor> findByAutor(Autor autor);

    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombreAutor")
    List<Libro> buscarPorAutor(@Param("nombreAutor") String nombreAutor);



}
