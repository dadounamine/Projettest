package com.example.demo.DAO;

import java.util.List;

import com.example.demo.entite.Etudiant;

public interface IEtudiantDAO {
	
	public List<Etudiant> findAll();
	public void insert(Etudiant et);
	public void delete(int id);
	public Etudiant findById(int id);

}
