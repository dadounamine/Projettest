package com.example.demo.DAO;
import com.example.demo.entite.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EtudiantDAO implements IEtudiantDAO {
	
	@PersistenceContext
	
	EntityManager entitymanager;
	
	public List<Etudiant> findAll(){
		
		Query query=entitymanager.createQuery("from Etudiant");
		        List<Etudiant> lst=   query.getResultList();
		        return lst;
		
	}
	
	public void insert(Etudiant et) {
		entitymanager.merge(et);
	}
	
	public void delete(int id) {
		Etudiant et=entitymanager.find(Etudiant.class, id);
		entitymanager.remove(et);
	}
	
	public Etudiant findById(int id) {
		Etudiant et=entitymanager.find(Etudiant.class, id);
		return et;
	}
	

}
