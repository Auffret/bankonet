package com.bankonet.dao.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import classes.Client;





public class ClientDaoFile extends ClientDao{

	public Map<String,Client> findAll() throws ClientException{
		File file = new File(fileName);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileInput);
			for(Object o: prop.keySet()){
				System.out.println(o);
				
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
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
	public void save(Client c) {
		File file = new File(fileName);
		Properties prop = new Properties();
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(file,true);
			prop.setProperty(c.getIdentifiant(), "nom:" + c.getNom() + "&prenom:" + c.getPrenom() + "&mdp:"+ c.getPassword() + "&compte_courant:CC1");
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
	}

	@Override
	public Client getClient(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean exist(Client c){
		boolean exist=false;
		File file = new File(fileName);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileInput);
			if (prop.getProperty(c.getIdentifiant()) != null) {
				//System.out.println("Client déja existant");
				exist = true;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
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
