package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IProduitRepository;
import com.example.entities.Produit;

@RestController
public class Cataloguecontroller {
	@Autowired
	private IProduitRepository produitRepository;
	
	@RequestMapping("/save")
	public Produit saveProduit(Produit p){
		produitRepository.save(p);
		return p;
	}
	@RequestMapping("/all")
	public List<Produit> getProduits(){
		return produitRepository.findAll();
	}
	@RequestMapping("/produits")
	public Page<Produit> produitPage(int page){
		return produitRepository.findAll(new PageRequest(page, 5));
	}
    @RequestMapping("/produitMotcle")
	public Page<Produit> produitMc(String mc, int page){
    	return produitRepository.produitMotCle("%"+mc+"%", new PageRequest(page,5));
    	
    }
    @RequestMapping("/get")
    public Produit getProduit(Long ref){
    	return produitRepository.findOne(ref);
    }
    @RequestMapping("/delete")
    public boolean delete(Long ref){
    	produitRepository.delete(ref);
    	return true;
    }
    @RequestMapping("/update")
    public Produit update(Produit p){
    	produitRepository.saveAndFlush(p);
    	return p;
    }
}
