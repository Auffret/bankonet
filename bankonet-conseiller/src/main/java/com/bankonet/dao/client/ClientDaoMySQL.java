package com.bankonet.dao.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import classes.Client;

public class ClientDaoMySQL extends ClientDao {

	static String bddName = "";

	public void save(Client c) {
		if (!exist(c)) {
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Connection connection;
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonetbdd","Auffret","mdp");
				Statement statement = connection.createStatement();
				// statement.executeUpdate("INSERT INTO client(ID,NAME,PRICE)
				// VALUES(1,'Regina',12.0)");
				statement.executeUpdate("INSERT INTO client VALUES(\"" + c.getIdentifiant() + "\",\"" + c.getNom() + "\",\""+ c.getPrenom() + "\",\"" + c.getPassword() + "\",\"" + "CC01" + "\",\"" + "\")");
				statement.close();
				connection.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		;

		/*
		 * 
		 * // dialoguer avec bdd Statement statement =
		 * connection.createStatement();
		 */
		// TODO Auto-generated method stub

	}

	@Override
	public Client getClient(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exist(Client c) {
		boolean b = false;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection connection;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonetbdd","Auffret","mdp");
			Statement statement = connection.createStatement();
			ResultSet resultats = statement.executeQuery("SELECT COUNT(*) FROM client WHERE login=\"" + c.getIdentifiant()+"\"");
			// Integer i = statement.executeQuery("SELECT COUNT(*) FROM client
			// WHERE login="+c.getIdentifiant());
			if (!resultats.next()) {
				b = true;
			}
			/*
			 * while(resultats.next()) {
			 * 
			 * Integer id = resultats.getInt("ID");
			 * 
			 * String name = resultats.getString("NAME"); BigDecimal price =
			 * resultats.getBigDecimal("PRICE");
			 * 
			 * System.out.println("[id=" + id + " name=" + name + " price=" +
			 * price
			 * 
			 * + "]"); }
			 */
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return b;
	}

	@Override
	public Map<String, Client> findAll() throws ClientException {
		Map<String, Client> map = new HashMap<String, Client>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection connection;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonetbdd","Auffret","mdp");
			Statement statement = connection.createStatement();
			
			ResultSet resultats = statement.executeQuery("SELECT * FROM client");
			while (resultats.next()) {
				Client c=new Client();
				c.setIdentifiant(resultats.getString("login"));
				c.setNom(resultats.getString("nom"));
				c.setPrenom(resultats.getString("prenom"));
				c.setPassword(resultats.getString("mdp"));
				map.put(resultats.getString("login"), c);
				//c.setC(resultats.getString("cc"));//TODO
				//c.setC(resultats.getString("ce"));
			}
			
			statement.close();
			connection.close();
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
