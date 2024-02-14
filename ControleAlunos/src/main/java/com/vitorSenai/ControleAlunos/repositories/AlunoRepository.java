package com.vitorSenai.ControleAlunos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorSenai.ControleAlunos.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
