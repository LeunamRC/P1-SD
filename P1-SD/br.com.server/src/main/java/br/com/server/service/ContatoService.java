package br.com.server.service;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;



import br.com.model.Contato;
import br.com.server.db.ContatoDB;

public class ContatoService extends UnicastRemoteObject implements IContatoService  {

	private static final long serialVersionUID = 1L;

	public ContatoService() throws RemoteException {
		super();
	}


	public boolean add(Contato contato) throws RemoteException {
		return new ContatoDB().add(contato);
	}

	public boolean update(Contato contato) throws RemoteException {
		return new ContatoDB().update(contato);
	}

	public boolean delete(Contato contato) throws RemoteException {
		return new ContatoDB().delete(contato);
		
	}

	public ArrayList<Contato> select(Contato contato) throws RemoteException {
		return new ContatoDB().select(contato);
	}

	
	

}
