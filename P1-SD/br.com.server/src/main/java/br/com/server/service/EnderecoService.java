package br.com.server.service;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;


import br.com.model.Endereco;
import br.com.server.db.EnderecoDB;

public class EnderecoService extends UnicastRemoteObject implements IEnderecoService  {

	private static final long serialVersionUID = 1L;
	

	public EnderecoService() throws RemoteException {
		super();
	}



	public boolean add(Endereco endereco) throws RemoteException {
		return new EnderecoDB().add(endereco);
	}

	public boolean update(Endereco endereco) throws RemoteException {
		return new EnderecoDB().update(endereco);
	}

	public boolean delete(Endereco endereco) throws RemoteException {
		return new EnderecoDB().delete(endereco);
		
	}

	public ArrayList<Endereco> select(Endereco endereco) throws RemoteException {
		return new EnderecoDB().select(endereco);
	}

	

}