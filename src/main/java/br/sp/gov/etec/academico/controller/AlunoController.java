package br.sp.gov.etec.academico.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.sp.gov.etec.academico.model.Aluno;
import br.sp.gov.etec.academico.repository.AlunoRepository;


@Controller
//@RequestMapping("/Alunos")
public class AlunoController {
	
	@Autowired
	AlunoRepository repository;

	@GetMapping("/Listar")	
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("Alunos/Lista");	
			
		List<Aluno> listaAlunos = repository.findAll();						
		
		view.addObject("alunos", listaAlunos);
		
		return view;
	}
	
	@GetMapping("/Cadastrar")	
	public String cadastrar(Model model) {
		model.addAttribute(new Aluno());
		return "Alunos/CadastroAluno";
	}
	
	@PostMapping("/Confirmar")	
	public String confirmar(Aluno aluno) {	
		repository.save(aluno);
		return "redirect:/Listar";
	}
	
	@GetMapping("/aluno/editar/{id}")	
	public String editarAluno(@PathVariable Long id, Model model) {
		Aluno aluno = repository.findById(id).get();
		model.addAttribute(aluno);
		return "Alunos/CadastroAluno";
	}
	
	@GetMapping("/aluno/excluir/{id}")	
	public String excluirAluno(@PathVariable Long id, Model model) {
		repository.deleteById(id);		
		return "redirect:/Listar";
	}
	
}
