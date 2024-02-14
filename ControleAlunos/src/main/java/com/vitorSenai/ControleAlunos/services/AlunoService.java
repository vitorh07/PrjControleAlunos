package com.vitorSenai.ControleAlunos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorSenai.ControleAlunos.entities.Aluno;
import com.vitorSenai.ControleAlunos.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno getAlunoById(Long idAluno) {
		return alunoRepository.findById(idAluno).orElse(null);
	}

	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public boolean deleteAluno(Long id) {
		Optional<Aluno> alunoExistente = alunoRepository.findById(id);
		if (alunoExistente.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Aluno updateAluno(Long idAluno, Aluno novoAluno) {
		Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);
		if (alunoOptional.isPresent()) {
			Aluno alunoExistente = alunoOptional.get();
			alunoExistente.setNome(novoAluno.getNome());
			alunoExistente.setCpf(novoAluno.getCpf());
			alunoExistente.setRg(novoAluno.getRg());
			alunoExistente.setEndereco(novoAluno.getEndereco());

	}
		return null;
}
}