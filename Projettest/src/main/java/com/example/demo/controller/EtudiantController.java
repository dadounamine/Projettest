package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entite.Etudiant;
import com.example.demo.service.IEtudiantService;

@Controller
public class EtudiantController {
	
	IEtudiantService etudiantservice;
	
	public IEtudiantService getEtudiantservice() {
		return etudiantservice;
	}
	
	public void setEtudiantservice(IEtudiantService etudiantservice) {
		this.etudiantservice=etudiantservice;
	}
	
	@RequestMapping("/Lister")
	public String test(Model M) {
		
		List<Etudiant> list=etudiantservice.selectAll();
		M.addAttribute("list",list);
		return "Lister";
		
	}
	
	@RequestMapping("/Ajouter")

	public String afficher(Model M) {
		
		Etudiant et=new Etudiant();
		M.addAttribute("et",et);
		return "Ajouter";
	}
	
	
	
	@RequestMapping("/saveetudiant")
	
	public String save(@ModelAttribute("et")Etudiant et) {
		etudiantservice.save(et);
		return"redirect:/Lister";
	}
	
	@RequestMapping("/supprimeretudiant/{id}")
	
	
	public String suppetudiant(@PathVariable("id") int id) {
		etudiantservice.delete(id);
        return "redirect:/Lister";
	}
	
	
	@RequestMapping("modifieretudiant/{id}")
	
	public String modifieretudiant(@PathVariable("id") int id, Model M) {
		Etudiant et2=etudiantservice.selectById(id);
		M.addAttribute("et",et2);
		return "redirect:/Ajouter";
	}
	
	@RequestMapping("/afficherlogin")

	public String afficherlogin() {
		return "Authentification";
	}
	
	
	@RequestMapping("/accesrefuse")
	
	public String accessdenied() {
		return "acces";
	}
	
	
	@RequestMapping("/Etudiant/afficher")
	
	public String afficheretudiant() {
		return "etudiant";
	}
}
