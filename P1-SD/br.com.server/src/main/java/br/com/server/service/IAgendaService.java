package br.com.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import br.com.model.Agenda;

public interface IAgendaService extends Remote  {

	boolean add (Agenda agenda) throws RemoteException;
	boolean update (Agenda agenda) throws RemoteException;
	boolean delete (Agenda agenda) throws RemoteException;
	ArrayList<Agenda> select(Agenda agenda) throws RemoteException;
}
