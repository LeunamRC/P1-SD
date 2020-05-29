package br.com.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.model.Agenda;

public class AgendaDB {

	Connection connection;
	String url = "jdbc:sqlserver://localhost:1434;databaseName=P1-Andre-SD";
	String user = "Teste";
	String password = "505050";

	public boolean add(Agenda agenda) {

		try {
			connection = DriverManager.getConnection(url, user, password);

			Statement st = connection.createStatement();
			String q1 = "insert into Agenda values('" + agenda.getId_contato() + "', '" + agenda.getDt_agendamento() + "', '" + agenda.getHorario()+ "','" 
			+ agenda.getObs() + "', '" + agenda.getSituacao() + "' )";
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

	public boolean update(Agenda agenda) {
	
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
            String q1 = "update agenda set ID_Contato = '"+agenda.getId_contato()+"' ,Dt_Agendamento = '"+agenda.getDt_agendamento()+"' ,Horario = '" 
			+agenda.getHorario()+ "' ,Obs =  '" + agenda.getObs() + "' ,Situação = '" + agenda.getSituacao() +"' "
			+ "where ID = '"+agenda.getId()+ "' "; 
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public boolean delete (Agenda agenda) {
		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
			Statement st = connection.createStatement();
            // Deleting from database 
            String q1 = "DELETE from Agenda WHERE ID = '" + agenda.getId() +"' "; 
                      
            int x = st.executeUpdate(q1); 
              
            if (x > 0)             
            	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;

	}

	public ArrayList<Agenda> select(Agenda agenda) {

		try
		{ 
			Connection connection = DriverManager.getConnection(url,user,password);
            // Updating database 
			Statement st = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append("select ID,ID_Contato,Dt_Agendamento,Horario,Obs,Situação from Agenda ");		
			sb.append("where ID = '"+ agenda.getId() + "' ");
            ResultSet x = st.executeQuery(sb.toString()); 
              
            ArrayList<Agenda> c = new ArrayList<Agenda>();
            while(x.next()) {
            	Agenda aux = new Agenda();
            	aux.setId(x.getInt("ID"));
            	aux.setId_contato(x.getInt("ID_Contato"));
            	aux.setDt_agendamento(x.getString("Dt_Agendamento"));
            	aux.setHorario(x.getString("Horario"));
            	aux.setObs(x.getString("Obs"));
            	aux.setSituacao(x.getString("Situação"));
            	c.add(aux);
            }
            return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		

	}
}
