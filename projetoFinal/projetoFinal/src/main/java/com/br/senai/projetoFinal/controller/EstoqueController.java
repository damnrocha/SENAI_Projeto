package com.br.senai.projetoFinal.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.br.senai.projetoFinal.model.EstoqueModel;
import com.br.senai.projetoFinal.repository.EstoqueRepository;

@Controller
public class EstoqueController {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@GetMapping("/estoque")
	public String listaEstoqueModel(Model model) {

		List<EstoqueModel> estoqueModel = estoqueRepository.findAll();
		model.addAttribute("estoqueModel", estoqueModel);
		return "produtos";
	}

	@GetMapping("/tabelaDeProdutos")
	public String mostrarTabela(Model estoqueModel) {
		List<EstoqueModel> estoqueMode = estoqueRepository.findAll();
		estoqueModel.addAttribute("estoqueModel", estoqueMode);
		return "tabelaProdutos";
	}

	@GetMapping("/index")
	public String index(Model estoqueModel) {
		List<EstoqueModel> estoqueMode = estoqueRepository.findAll();
		estoqueModel.addAttribute("estoqueModel", estoqueMode);
		return "index";
	}

	@GetMapping("/cadastrar")
	public String novoProduto(EstoqueModel estoque) {
		return "/cadastrar_produtos";
	}

	@PostMapping("cadastrar")
	public String adicionaProduto(@Valid EstoqueModel estoque, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "/cadastrar_produtos";

		}
		estoqueRepository.save(estoque);
		return "redirect:/estoque";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioAtualizacao(@PathVariable("id") long id, Model model) {
		EstoqueModel estoque = estoqueRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Identificador não é válido" + id));
		model.addAttribute("estoqueModel", estoque);
		return "atualizar_produtos";
	}

	@PostMapping("/atualizar_es/{id}")
	public String atualizaProduto(@PathVariable("id") long id, @ModelAttribute("estoque") EstoqueModel estoque, 
			Model model) {
		estoque.setId(id);
		estoqueRepository.save(estoque);
		return "redirect:/estoque";
	}

	@GetMapping("/delete/{id}")
	public String deletarProduto(@PathVariable("id") long id, Model model) {
		EstoqueModel estoque = estoqueRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Identificador não é válido" + id));
		estoqueRepository.delete(estoque);
		return "redirect:/estoque";
	
	}
	

}