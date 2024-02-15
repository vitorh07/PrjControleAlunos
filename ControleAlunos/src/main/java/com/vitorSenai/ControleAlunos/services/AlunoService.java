package com.vitorSenai.ControleAlunos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorSenai.ControleAlunos.entities.Aluno;
import com.vitorSenai.ControleAlunos.repositories.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService (AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno getAlunoById(Long idAluno) {
		return alunoRepository.findById(idAluno).orElse(null);
	}
	//listar todos os produtos
	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
	}
	
	//apagar produto
	public boolean deleteAluno(Long idAluno) {
		Optional<Aluno> alunoExistente = alunoRepository.findById(idAluno);
		if (alunoExistente.isPresent()) {
			alunoRepository.deleteById(idAluno);
			return true;
		} else {
			return false;
		}
	}
	
	// fazendo o update do aluno com o optional
		public Aluno updateAluno(Long idAluno, Aluno novoAluno) {
	        Optional<Aluno> alunoOptional = alunoRepository.findById(idAluno);
	        if (alunoOptional.isPresent()) {
	        	Aluno alunoExistente = alunoOptional.get();
	           	alunoExistente.setNome(novoAluno.getNome());
	        	alunoExistente.setCpf(novoAluno.getCpf());     
	        	alunoExistente.setRg(novoAluno.getRg());  
	        	alunoExistente.setEndereco(novoAluno.getEndereco());  
	            return alunoRepository.save(alunoExistente); 
	        } else {
	            return null; 
	        }
	    }
}
