package br.com.server.service;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;


import br.com.model.Agenda;
import br.com.server.db.AgendaDB;

public class AgendaService extends UnicastRemoteObject implements IAgendaService  {

	
	public AgendaService() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = -7920381882104836973L;

	public boolean add(Agenda agenda) throws RemoteException {
		return new AgendaDB().add(agenda);
	}

	public boolean update(Agenda agenda) throws RemoteException {
		return new AgendaDB().update(agenda);
	}

	public boolean delete(Agenda agenda) throws RemoteException {
		return new AgendaDB().delete(agenda);
		
	}

	public ArrayList<Agenda> select(Agenda agenda) throws RemoteException {
		return new AgendaDB().select(agenda);
	}

	

}
