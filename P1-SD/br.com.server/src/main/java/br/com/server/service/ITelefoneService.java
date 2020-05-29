package br.com.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import br.com.model.Telefone;

public interface ITelefoneService extends Remote  {

	boolean add (Telefone telefone) throws RemoteException;
	boolean update (Telefone telefone) throws RemoteException;
	boolean delete (Telefone telefone) throws RemoteException;
	ArrayList<Telefone> select(Telefone telefone) throws RemoteException;
}
