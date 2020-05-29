package br.com.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.model.Cidade;

public class CidadeDB {

	Connection connection;
	String url = "jdbc:sqlserver://localhost:1434;databaseName=P1-Andre-SD";
	String user = "Teste";
	String password = "505050";

	public boolean add(Cidade cidade) {

		try {
			connection = DriverManager.getConnection(url, user, password);

			Statement st = connection.createStatement();
			String q1 = "insert into Cidade values('" + cidade.getNome() + "', '" + cidade.getUf() + "')";
			int x = st.executeUpdate(q1);
			if (x > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean update(Cidade cidade) {
	
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
            String q1 = "update cidade set Nome = '"+cidade.getNome()+"' ,Sigla_UF = '"+cidade.getUf()+"' "+ "where ID = '"+cidade.getId()+ "' "; 
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public boolean delete (Cidade cidade) {
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement st = connection.createStatement();
            // Deleting from database 
            String q1 = "DELETE from Cidade WHERE ID = '" + cidade.getId() +"' "; 
                      
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;

	}

	public ArrayList<Cidade> select(Cidade cidade) {

		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("select ID,nome,Sigla_UF from Cidade ");		
			sb.append("where nome like '%"+ cidade.getNome() + "%' ");
            ResultSet x = st.executeQuery(sb.toString()); 
              
            ArrayList<Cidade> c = new ArrayList<Cidade>();
            while(x.next()) {
            	Cidade aux = new Cidade();
            	aux.setId(x.getInt("ID"));
            	aux.setNome(x.getString("nome"));
            	aux.setUf(x.getString("Sigla_Uf"));
            	c.add(aux);
            }
            return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		

	}
}
