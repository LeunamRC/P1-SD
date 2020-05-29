package br.com.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.model.Contato;

public class ContatoDB {
	Connection connection;
	String url = "jdbc:sqlserver://localhost:1434;databaseName=P1-Andre-SD";
	String user = "Teste";
	String password = "505050";
	
	public boolean add(Contato contato) {

		try {
			connection = DriverManager.getConnection(url, user, password);

			Statement st = connection.createStatement();
			String q1 = "insert into Contato values('" + contato.getCpf() + "', '" 
			+ contato.getRg() + "', '" + contato.getNome() + "', '" + contato.getApelido()+ "', '" 
			+ contato.getDt_nascimento() + "', '" + contato.getSexo() + "')";
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
	
	public boolean update(Contato contato) {
		
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
            String q1 = "update Contato set CPF = '"+contato.getCpf()+ "' ,RG = '"+ contato.getRg() + "' ,Nome = '" + contato.getNome() + 
            "' ,Apelido = '" + contato.getApelido() +"' ,Dt_Nascimento = '" + contato.getDt_nascimento() +"' ,Sexo = '" + contato.getSexo()+ "' "+ 
            " where ID = "+contato.getId() ; 
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	public boolean delete (Contato contato) {
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement st = connection.createStatement();
            // Deleting from database 
            String q1 = "DELETE from Contato WHERE ID = " + contato.getId() ; 
                      
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;

	}

	public ArrayList<Contato> select(Contato contato) {

		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("select ID,CPF,RG,Nome,Apelido,Dt_Nascimento,Sexo from Contato ");		
			sb.append("where Nome like '%"+ contato.getNome() + "%' ");
            ResultSet x = st.executeQuery(sb.toString()); 
              
            ArrayList<Contato> c = new ArrayList<Contato>();
            while(x.next()) {
            	Contato aux = new Contato();
            	aux.setId(x.getInt("ID"));
            	aux.setCpf(x.getString("CPF"));
            	aux.setRg(x.getString("RG"));
            	aux.setNome(x.getString("Nome"));
            	aux.setApelido(x.getString("Apelido"));
            	aux.setDt_nascimento(x.getString("Dt_Nascimento"));
            	aux.setSexo(x.getString("Sexo"));
            	c.add(aux);
            }
            return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		

	}

	

}
