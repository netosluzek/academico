package br.sp.gov.etec.academico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CursoController {

	@GetMapping("/Cursos")
		public String listar() {
			return "ListaCursos";
	}
}
