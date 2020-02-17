package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.IEtudiantDAO;
import com.example.demo.entite.Etudiant;

@Service
public class EtudiantService implements IEtudiantService {
	
	IEtudiantDAO dao;
	
	public IEtudiantDAO getDao() {
		return dao;
	}
	
	public void setDao(IEtudiantDAO dao) {
		this.dao=dao;
	}
	
	public List<Etudiant> selectAll(){
		List<Etudiant> lt=dao.findAll();
		return lt;
	}
	
	public void save(Etudiant et) {
		dao.insert(et);
	}
	
	public void delete(int id) {
		dao.delete(id);
	}
	
	public Etudiant selectById(int id) {
		Etudiant et=dao.findById(id);
		return et;
	}
	
	

}
