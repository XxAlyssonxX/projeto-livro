package com.gerencialivro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerencialivro.entities.Livro;
import com.gerencialivro.repository.LivroRepository;

@Service
public class LivroService {
	private final LivroRepository LivroRepository;
	

	@Autowired
	public LivroService(LivroRepository LivroRepository) {
		this.LivroRepository = LivroRepository;
	}

	public List<Livro> getAllLivros() {
		return LivroRepository.findAll();
	}

	public Livro getLivroById(Long id) {
		Optional<Livro> Livro = LivroRepository.findById(id);
		return Livro.orElse(null);
	}

	public Livro saveLivro(Livro Livro) {
		return LivroRepository.save(Livro);
	}

	public Livro changeLivro(Long id, Livro changeU) {
		Optional<Livro> existeLivro = LivroRepository.findById(id);
		if (existeLivro.isPresent()) {
			changeU.setId(id);
			return LivroRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteLivro(Long id) {
		Optional<Livro> existeLivro= LivroRepository.findById(id);
		if (existeLivro.isPresent()) {
			LivroRepository.deleteById(id);
			return true;
		}
		return false;
	}

}