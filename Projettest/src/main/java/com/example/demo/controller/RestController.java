package com.example.demo.controller;
import com.example.demo.entite.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.IEtudiantService;


@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="/api")

public class RestController {
	
	
	@Autowired
	
	IEtudiantService etudservice;
	
	@GetMapping(value="/RestAll")
	
	public List<Etudiant> pageindex(){
		List<Etudiant> lst=etudservice.selectAll();
		return lst;
	}
	
	
	@DeleteMapping(value="/supprimeretudinat/{id}")
	public void delete(@PathVariable("id")int id) {
		etudservice.delete(id);
		
	}
	
	@RequestMapping(value="/modifieretudiant/{id}")
	
	public Etudiant update(@PathVariable("id")int id) {
		Etudiant et=etudservice.selectById(id);
		return et;
	}
	
	
	
	@PostMapping(value="/insereretudiant")
	
	public void insereretudiant(Etudiant et) {
		etudservice.save(et);
	}
	
	@PutMapping(value="/insereretudiant")
	
	public void insert(Etudiant et) {
		etudservice.save(et);
	}
	

}
