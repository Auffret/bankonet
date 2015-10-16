package com.bankonet.dao.compte;

import java.io.FileReader;
import java.util.List;

import com.bankonet.Compte;

public class CompteDaoFile implements CompteDao{

	private FileReader fileReader;
	
	public List<Compte> findAll(){
		
		return null;
	}
	
	public void save(Compte c){
		
	}
}
