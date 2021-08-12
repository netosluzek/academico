package br.sp.gov.etec.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sp.gov.etec.academico.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
