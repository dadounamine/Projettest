package com.example.demo.service;

import java.util.List;

import com.example.demo.entite.Etudiant;

public interface IEtudiantService {
	
	public List<Etudiant> selectAll();
	public void save(Etudiant et);
	public void delete(int id);
	public Etudiant selectById(int id);

}
