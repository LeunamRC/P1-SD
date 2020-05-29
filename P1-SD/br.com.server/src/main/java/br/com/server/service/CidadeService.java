package br.com.server.service;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;


import br.com.model.Cidade;
import br.com.server.db.CidadeDB;

public class CidadeService extends UnicastRemoteObject implements ICidadeService  {

	
	public CidadeService() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = -7920381882104836973L;

	public boolean add(Cidade cidade) throws RemoteException {
		return new CidadeDB().add(cidade);
	}

	public boolean update(Cidade cidade) throws RemoteException {
		return new CidadeDB().update(cidade);
	}

	public boolean delete(Cidade cidade) throws RemoteException {
		return new CidadeDB().delete(cidade);
		
	}

	public ArrayList<Cidade> select(Cidade cidade) throws RemoteException {
		return new CidadeDB().select(cidade);
	}

	

}
