package br.com.server.service;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;



import br.com.model.Telefone;
import br.com.server.db.TelefoneDB;

public class TelefoneService extends UnicastRemoteObject implements ITelefoneService  {

	
	public TelefoneService() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = -7920381882104836973L;

	public boolean add(Telefone telefone) throws RemoteException {
		return new TelefoneDB().add(telefone);
	}

	public boolean update(Telefone telefone) throws RemoteException {
		return new TelefoneDB().update(telefone);
	}

	public boolean delete(Telefone telefone) throws RemoteException {
		return new TelefoneDB().delete(telefone);
		
	}

	public ArrayList<Telefone> select(Telefone telefone) throws RemoteException {
		return new TelefoneDB().select(telefone);
	}

	
	

}
