package com.bankonet.dao.compte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import classes.Compte;

public class CompteDaoFile implements CompteDao{

	private FileReader fileReader;
	
	/*
	public void save(Compte c){
		
	}
	*/
	
	@Override
	public ArrayList<Compte> findAll(String identifiant) {
		List<Compte> comptes=new ArrayList<Compte>();
		File file = new File(fileName);
		FileInputStream fileInput = null;
		try {								
			fileInput = new FileInputStream(file);
			Properties prop = new Properties();			
			//load a properties file from class path, inside static method
			prop.load(fileInput);
			String line=prop.getProperty(identifiant);//possibilité d'user de split pour créer un map
			String[] attributs=line.split(":");	
			for(String cc:attributs[2].split(",")){	
				String[] attributCC=cc.split("&");
				//String numero=
				//Compte c=new Compte(attributCC[0],intitule,solde);//refaire
				
			
			}
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
		finally {
			if (fileInput != null) {
				try {
					fileInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
	}

	@Override
	public void creerCompte(Compte c) {//TODO
		File file = new File(fileName);	
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(file,true);
			Properties prop = new Properties();					
			String retour="";
			retour+="numero:" + c.getNumero() + "&intitulé:CC"+ c.getIntitule() + "&solde:"+ c.getSolde();			
			prop.setProperty(c.getNumero(), retour);//TODO découvert			
			prop.store(output, null);										
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	
	public boolean exist(String identifiant){
		boolean exist=false;
		File file = new File(fileName);
		FileInputStream fileInput = null;
		try {								
			fileInput = new FileInputStream(file);
			Properties prop = new Properties();			
			//load a properties file from class path, inside static method
			prop.load(fileInput);
			if(prop.getProperty(identifiant)!=null){				// Client déja présent
				exist=true;				
			}
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
		finally {
			if (fileInput != null) {
				try {
					fileInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return exist;
	}
}
