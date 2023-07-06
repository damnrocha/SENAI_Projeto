package com.br.senai.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/adicionarProduto")
	public String adicionaProduto(@Valid EstoqueModel estoqueModel, BindingResult result, Model model) {
	
		if(result.hasErrors()) {
			return "/ ";
			
		}
		estoqueRepository.save(estoqueModel);
		return "redirect:/estoque";
	}
	
	

}