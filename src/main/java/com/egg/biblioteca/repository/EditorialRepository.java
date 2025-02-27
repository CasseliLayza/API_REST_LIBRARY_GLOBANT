package com.egg.biblioteca.repository;

import com.egg.biblioteca.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, UUID> {
}
