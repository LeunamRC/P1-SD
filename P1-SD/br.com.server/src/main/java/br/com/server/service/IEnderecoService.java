package br.com.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import br.com.model.Endereco;

public interface IEnderecoService extends Remote  {

	boolean add (Endereco endereco) throws RemoteException;
	boolean update (Endereco endereco) throws RemoteException;
	boolean delete (Endereco endereco) throws RemoteException;
	ArrayList<Endereco> select(Endereco endereco) throws RemoteException;
}
