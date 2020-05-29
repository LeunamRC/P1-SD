package br.com.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import br.com.model.Contato;

public interface IContatoService extends Remote  {

	boolean add (Contato contato) throws RemoteException;
	boolean update (Contato contato) throws RemoteException;
	boolean delete (Contato contato) throws RemoteException;
	ArrayList<Contato> select(Contato contato) throws RemoteException;
}
