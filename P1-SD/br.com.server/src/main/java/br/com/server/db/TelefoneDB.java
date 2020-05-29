package br.com.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.model.Telefone;

public class TelefoneDB {
	Connection connection;
	String url = "jdbc:sqlserver://localhost:1434;databaseName=P1-Andre-SD";
	String user = "Teste";
	String password = "505050";
	
	public boolean add(Telefone telefone) {

		try {
			connection = DriverManager.getConnection(url, user, password);

			Statement st = connection.createStatement();
			String q1 = "insert into Telefone_Contato values('" + telefone.getNumero() + "', '"+ telefone.getId_contato() + "', '" + telefone.getTipo() +"')";
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
	
	public boolean update(Telefone telefone) {
		
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
            String q1 = "update Telefone_Contato set Numero = '"+telefone.getNumero()+ "' ,Tipo = '"+ telefone.getTipo() +"' "+ 
			"where ID = '"+telefone.getId()+ "' "; 
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	public boolean delete (Telefone telefone) {
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement st = connection.createStatement();
            // Deleting from database 
            String q1 = "DELETE from Telefone_Contato WHERE ID = '" + telefone.getId() +"' "; 
                      
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;

	}
	public ArrayList<Telefone> select(Telefone telefone) {

		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("select ID,Numero,ID_Contato,Tipo from Telefone_Contato ");		
			sb.append("where Id_Contato = '"+ telefone.getId_contato() + "' ");
            ResultSet x = st.executeQuery(sb.toString()); 
              
            ArrayList<Telefone> t = new ArrayList<Telefone>();
            while(x.next()) {
            	Telefone aux = new Telefone();
            	aux.setId(x.getInt("ID"));
            	aux.setNumero(x.getInt("Numero"));
            	aux.setId_contato(x.getInt("Id_contato"));
            	aux.setTipo(x.getString("Tipo"));
            	t.add(aux);
            }
            return t;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		

	}
	

}
