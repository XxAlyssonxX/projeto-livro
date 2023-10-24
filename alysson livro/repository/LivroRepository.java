package com.gerencialivro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerencialivro.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro,Long> {

}
