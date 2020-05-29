package br.com.server.open;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import br.com.server.service.AgendaService;
import br.com.server.service.CidadeService;
import br.com.server.service.ContatoService;
import br.com.server.service.EnderecoService;
import br.com.server.service.TelefoneService;

public class StartServer {
	public StartServer() throws RemoteException {
		try {
			LocateRegistry.createRegistry(8282);
			Naming.rebind("rmi://localhost:8282/cidade", new CidadeService());
			Naming.rebind("rmi://localhost:8282/telefone", new TelefoneService());
			Naming.rebind("rmi://localhost:8282/contato", new ContatoService());
			Naming.rebind("rmi://localhost:8282/agenda", new AgendaService());
			Naming.rebind("rmi://localhost:8282/endereco", new EnderecoService());
			System.out.println("Rodando...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws RemoteException {
		new StartServer();
	}
}
