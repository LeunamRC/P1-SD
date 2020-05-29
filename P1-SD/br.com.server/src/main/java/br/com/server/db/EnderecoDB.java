package br.com.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.model.Endereco;

public class EnderecoDB {
	Connection connection;
	String url = "jdbc:sqlserver://localhost:1434;databaseName=P1-Andre-SD";
	String user = "Teste";
	String password = "505050";
	
	public boolean add(Endereco endereco) {

		try {
			connection = DriverManager.getConnection(url, user, password);

			Statement st = connection.createStatement();
			String q1 = "insert into Endereco values(" + endereco.getId_cidade() + ", '" 
			+ endereco.getSigla_uf() + "', " + endereco.getId_contato() + ", '" + endereco.getLogradouro() + 
			"', " + endereco.getNumero() + ", '" + endereco.getBairro() + "', '" + endereco.getComplemento() +
			"', " + endereco.getCep() +  ")";
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
	
	public boolean update(Endereco endereco) {
		
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
            String q1 = "update Endereco set ID_Cidade = "+endereco.getId_cidade()+ " ,Sigla_UF = '"
			+ endereco.getSigla_uf() + "' ,ID_Contato = "+ endereco.getId_contato() + " ,Logradouro = '" 
            		+ endereco.getLogradouro() +  "' ,Numero = "+ endereco.getNumero() + " ,Bairro = '"+ endereco.getBairro() +
            		"' ,Complemento = '"+ endereco.getComplemento() + "' ,Cep = "+ endereco.getCep() + "where ID = '"+endereco.getId()+ "' ";
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public boolean delete (Endereco endereco) {
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement st = connection.createStatement();
            // Deleting from database 
            String q1 = "DELETE from Endereco WHERE ID = '" + endereco.getId() +"' "; 
                      
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;

	}
	
	public ArrayList<Endereco> select(Endereco endereco) {

		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("select ID,ID_Cidade,Sigla_UF,ID_Contato,Logradouro,Numero,Bairro,Complemento,Cep from Endereco ");		
			sb.append("where ID_Contato = '"+ endereco.getId_contato() + "' ");
            ResultSet x = st.executeQuery(sb.toString()); 
              
            ArrayList<Endereco> c = new ArrayList<Endereco>();
            while(x.next()) {
            	Endereco aux = new Endereco();
            	aux.setId(x.getInt("ID"));
            	aux.setId_cidade(x.getInt("ID_Cidade"));
            	aux.setSigla_uf(x.getString("Sigla_UF"));
            	aux.setId_contato(x.getInt("ID_Contato"));
            	aux.setLogradouro(x.getString("Logradouro"));
            	aux.setNumero(x.getInt("Numero"));
            	aux.setBairro(x.getString("Bairro"));
            	aux.setComplemento(x.getString("Complemento"));
            	aux.setCep(x.getInt("Cep"));
            	c.add(aux);
            }
            return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		

	}
}
