package br.com.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import br.com.model.Cidade;

public interface ICidadeService extends Remote  {

	boolean add (Cidade cidade) throws RemoteException;
	boolean update (Cidade cidade) throws RemoteException;
	boolean delete (Cidade cidade) throws RemoteException;
	ArrayList<Cidade> select(Cidade cidade) throws RemoteException;
}
