package com.egg.biblioteca.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "LIBROS")
public class Libro {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;
    private String titulo;
    private Integer ejemplares;
    @Temporal(TemporalType.DATE)
    private Date alta;
    @ManyToOne
    //@JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
    @ManyToOne
    //@JoinColumn(name = "editorial_id", nullable = false)
    private Editorial editorial;

    public Libro() {
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", ejemplares=" + ejemplares +
                ", alta=" + alta +
                ", autor=" + autor +
                ", editorial=" + editorial +
                '}';
    }
}
