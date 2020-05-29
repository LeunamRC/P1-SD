package br.com.client;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import br.com.model.Agenda;
import br.com.model.Cidade;
import br.com.model.Contato;
import br.com.model.Endereco;
import br.com.model.Telefone;
import br.com.server.service.IAgendaService;
import br.com.server.service.ICidadeService;
import br.com.server.service.IContatoService;
import br.com.server.service.IEnderecoService;
import br.com.server.service.ITelefoneService;

public class AppPrincipal {
	public static void main (String[] args) {
		boolean menu = true;
		while(menu) {
		
		System.out.println("Digite a opção desejada:");
		System.out.println("1- Menu Cidade");
		System.out.println("2- Menu Contato");
		System.out.println("3- Menu Agenda");
		System.out.println("4- Menu Endereço");
		System.out.println("5- Menu Telefone Contato");
		System.out.println("0- Sair");
		Scanner escolha = new Scanner(System.in);
		int menu_escolha = escolha.nextInt();
		
		if (menu_escolha==1) {
			System.out.println("1- Cadastrar nova cidade");
			System.out.println("2- Alterar cidade");
			System.out.println("3- Deletar cidade");
			System.out.println("4- Listar todas as cidades");
			System.out.println("0- Voltar");
			Scanner cidade = new Scanner(System.in);
			int menu_cidade = cidade.nextInt();
			
			if(menu_cidade==1) {
				System.out.println("Digite o nome da cidade");
				Scanner nome_cidade = new Scanner(System.in);
				String n_cidade = nome_cidade.nextLine();
				System.out.println("Digite o estado");
				Scanner uf = new Scanner(System.in);
				String s_uf = uf.nextLine();
				insertCidade(n_cidade,s_uf);
			}
		
			if(menu_cidade==2) {
				System.out.println("Digite o id da cidade");
				Scanner updt_cidade = new Scanner(System.in);
				int id_cidade = updt_cidade.nextInt();
				System.out.println("Digite o novo nome da cidade");
				Scanner nome_cidade = new Scanner(System.in);
				String n_cidade = nome_cidade.nextLine();
				System.out.println("Digite o novo estado");
				Scanner uf = new Scanner(System.in);
				String s_uf = uf.nextLine();
				updateCidade(id_cidade,n_cidade,s_uf);
			}
			
			if(menu_cidade==3) {
				System.out.println("Digite o id da cidade");
				Scanner del_cidade = new Scanner(System.in);
				int id_cidade = del_cidade.nextInt();
				deletecidade(id_cidade);
			}
			
			if(menu_cidade==4) {
				System.out.println("Digite o nome da cidade ou parte dele");
				Scanner sel_cidade = new Scanner(System.in);
				String nome_cidade = sel_cidade.nextLine();
				selectcidade(nome_cidade);
			}
		}
		
		if (menu_escolha==2) {
			System.out.println("1- Cadastrar novo contato");
			System.out.println("2- Alterar contato");
			System.out.println("3- Deletar contato");
			System.out.println("4- Consultar contatos");
			System.out.println("0- Voltar");
			Scanner contato = new Scanner(System.in);
			int menu_contato = contato.nextInt();
			
			if(menu_contato==1) {
				System.out.println("Digite o CPF do contato");
				Scanner cpf_contato = new Scanner (System.in);
				String cpf_con = cpf_contato.nextLine();
				System.out.println("Digite o RG do contato");
				Scanner rg_contato = new Scanner (System.in);
				String rg_con = rg_contato.nextLine();
				System.out.println("Digite o nome da contato");
				Scanner nome_contato = new Scanner(System.in);
				String n_contato = nome_contato.nextLine();
				System.out.println("Digite o Apelido do contato ou deixe em branco");
				Scanner apelido_contato = new Scanner(System.in);
				String apelido_con = apelido_contato.nextLine();
				System.out.println("Digite a data de Nascimento");
				Scanner dt_contato = new Scanner(System.in);
				String dt_con = dt_contato.nextLine(); 
				System.out.println("Digite o Sexo");
				Scanner sexo_contato = new Scanner(System.in);
				String sexo_con = sexo_contato.nextLine();
				insertContato(cpf_con,rg_con,n_contato,apelido_con,dt_con,sexo_con);
			}
		
			if(menu_contato==2) {
				System.out.println("Digite o ID do contato");
				Scanner updt_contato = new Scanner(System.in);
				int id_contato = updt_contato.nextInt();
				System.out.println("Digite o Novo CPF do contato");
				Scanner cpf_contato = new Scanner(System.in);
				String cpf_con = cpf_contato.nextLine();
				System.out.println("Digite o Novo RG do contato");
				Scanner rg_contato = new Scanner(System.in);
				String rg_con = rg_contato.nextLine();
				System.out.println("Digite o novo nome do contato");
				Scanner nome_contato = new Scanner(System.in);
				String n_contato = nome_contato.nextLine();
				System.out.println("Digite o novo Apelido do contato");
				Scanner apelido_contato = new Scanner(System.in);
				String apelido_con = apelido_contato.nextLine();
				System.out.println("Digite a nova data de nascimento do contato");
				Scanner dt_contato = new Scanner(System.in);
				String dt_con = dt_contato.nextLine();
				System.out.println("Digite o novo Sexo");
				Scanner sx_contato = new Scanner(System.in);
				String sx_con = sx_contato.nextLine();
				updateContato(id_contato,cpf_con,rg_con,n_contato,apelido_con,dt_con,sx_con);
			}
			
			if(menu_contato==3) {
				System.out.println("Digite o id do contato");
				Scanner del_contato = new Scanner(System.in);
				int id_contato = del_contato.nextInt();
				deletecontato(id_contato);
			}
			
			if(menu_contato==4) {
				System.out.println("Digite o Nome do Contato ou parte dele");
				Scanner nome_contato = new Scanner(System.in);
				String n_contato = nome_contato.nextLine();
				selectcontato(n_contato);
			}
			
		}
	
		if (menu_escolha==3) {
			System.out.println("1- Cadastrar novo Agendamento");
			System.out.println("2- Alterar Agendamento");
			System.out.println("3- Deletar Agendamento");
			System.out.println("4- Listar Agendamentos");
			System.out.println("0- Voltar");
			Scanner agenda = new Scanner(System.in);
			int menu_agenda = agenda.nextInt();
			
			if(menu_agenda==1) {
				System.out.println("Digite o ID do Contato");
				Scanner id_contato =  new Scanner(System.in);
				int id_con = id_contato.nextInt();
				System.out.println("Digite a Data de Agendamento no Formato DD/MM/AA");
				Scanner data_agenda =  new Scanner(System.in);
				String dt_agnd = data_agenda.nextLine();
				System.out.println("Digite o Horario Marcado no Formato HH:MM");
				Scanner hr_agenda =  new Scanner(System.in);
				String hr_agnd = hr_agenda.nextLine();
				System.out.println("Digite uma observação se necessario");
				Scanner obs_agenda =  new Scanner(System.in);
				String obs_agnd = obs_agenda.nextLine();
				System.out.println("Digite a Situação do agendamento");
				Scanner situacao_agenda =  new Scanner(System.in);
				String st_agnd = situacao_agenda.nextLine();
				insertAgenda(id_con,dt_agnd,hr_agnd,obs_agnd,st_agnd);
			}
			
			if (menu_agenda==2) {
				System.out.println("Digite o ID do agendamento");
				Scanner updt_agenda = new Scanner(System.in);
				int id_agenda = updt_agenda.nextInt();
				System.out.println("Digite o ID do novo Contato");
				Scanner id_contato = new Scanner(System.in);
				int id_con = id_contato.nextInt();
				System.out.println("Digite a Nova Data do agendamento");
				Scanner dt_agenda = new Scanner(System.in);
				String dt_agnd = dt_agenda.nextLine();
				System.out.println("Digite o Novo Horario do agendamento");
				Scanner hr_agenda = new Scanner(System.in);
				String hr_agnd= hr_agenda.nextLine();
				System.out.println("Digite uma Nova Observação se Necessario");
				Scanner obs_agenda = new Scanner(System.in);
				String obs_agnd = obs_agenda.nextLine();
				System.out.println("Digite uma Nova Situação para o Agendamento");
				Scanner st_agenda = new Scanner(System.in);
				String st_agnd = st_agenda.nextLine();
				updateAgenda(id_agenda,id_con,dt_agnd,hr_agnd,obs_agnd,st_agnd);
				
			}
			
			if (menu_agenda==3) {
				System.out.println("Digite o ID do agendamento");
				Scanner id_agenda = new Scanner(System.in);
				int id_agnd = id_agenda.nextInt();
				deleteagenda(id_agnd);	
			}
			
			if (menu_agenda ==4) {
				System.out.println("Digite o ID do agendamento");
				Scanner id_agenda = new Scanner(System.in);
				int id_agnd = id_agenda.nextInt();
				selectagenda(id_agnd);
			}
		}
		
		if(menu_escolha==4) {
			System.out.println("1- Cadastrar novo Endereço");
			System.out.println("2- Alterar Endereço");
			System.out.println("3- Deletar Endereço");
			System.out.println("4- Listar todos os Endereços");
			System.out.println("0- Voltar");
			Scanner endereco = new Scanner(System.in);
			int menu_endereco = endereco.nextInt();
			
			if(menu_endereco==1) {
				System.out.println("Digite o ID da cidade");
				Scanner cid_cidade = new Scanner(System.in);
				int id_cidade = cid_cidade.nextInt();
                System.out.println("Digite a sigla da UF");
				Scanner csigla = new Scanner(System.in);
				String sigla_uf = csigla.nextLine();
				System.out.println("Digite o ID do Contato");
				Scanner cid_contato = new Scanner(System.in);
				int id_contato = cid_contato.nextInt();
				System.out.println("Digite o logradouro");
				Scanner clogradouro = new Scanner(System.in);
				String logradouro = clogradouro.nextLine();
				System.out.println("Digite o Numero");
				Scanner cnumero = new Scanner(System.in);
				int numero = cnumero.nextInt();
                System.out.println("Digite o bairro");
				Scanner cbairro = new Scanner(System.in);
				String bairro = cbairro.nextLine();
                System.out.println("Digite o complemento");
				Scanner ccomplemento = new Scanner(System.in);
				String complemento = ccomplemento.nextLine();
                System.out.println("Digite o cep");
				Scanner ccep = new Scanner(System.in);
				int cep = ccep.nextInt();
				insertEndereco(id_cidade,sigla_uf,id_contato,logradouro,numero,bairro,complemento,cep);
			}
			
			if(menu_endereco==2) {
				System.out.println("Digite o ID do endereço");
				Scanner cid_endereco = new Scanner(System.in);
				int id_endereco = cid_endereco.nextInt();
				System.out.println("Digite o ID da cidade");
				Scanner cid_cidade = new Scanner(System.in);
				int id_cidade = cid_cidade.nextInt();
                System.out.println("Digite a sigla da UF");
				Scanner csigla = new Scanner(System.in);
				String sigla_uf = csigla.nextLine();
				System.out.println("Digite o ID do Contato");
				Scanner cid_contato = new Scanner(System.in);
				int id_contato = cid_contato.nextInt();
				System.out.println("Digite o logradouro");
				Scanner clogradouro = new Scanner(System.in);
				String logradouro = clogradouro.nextLine();
				System.out.println("Digite o Numero");
				Scanner cnumero = new Scanner(System.in);
				int numero = cnumero.nextInt();
                System.out.println("Digite o bairro");
				Scanner cbairro = new Scanner(System.in);
				String bairro = cbairro.nextLine();
                System.out.println("Digite o complemento");
				Scanner ccomplemento = new Scanner(System.in);
				String complemento = ccomplemento.nextLine();
                System.out.println("Digite o cep");
				Scanner ccep = new Scanner(System.in);
				int cep = ccep.nextInt();
				updateEndereco(id_endereco,id_cidade,sigla_uf,id_contato,logradouro,numero,bairro,complemento,cep);
			}
			
			if(menu_endereco==3) {
				System.out.println("Digite o ID do endereço");
				Scanner cid_endereco = new Scanner(System.in);
				int id_endereco = cid_endereco.nextInt();
				deleteendereco(id_endereco);
				
			}
			
			if(menu_endereco==4) {
				System.out.println("Digite o ID do contato");
				Scanner cid_contato = new Scanner(System.in);
				int id_contato = cid_contato.nextInt();
				selectendereco(id_contato);
				
			}
			
			
		}
		
		if(menu_escolha==5) {
			System.out.println("1- Cadastrar novo Telefone");
			System.out.println("2- Alterar Telefone");
			System.out.println("3- Deletar Telefone");
			System.out.println("4- Consultar Telefones");
			System.out.println("0- Voltar");
			Scanner telefone = new Scanner(System.in);
			int menu_telefone = telefone.nextInt();
						

			if(menu_telefone==1) {
							System.out.println("Digite o numero do telefone");
							Scanner nmr_telefone = new Scanner(System.in);
							int n_telefone = nmr_telefone.nextInt();
							System.out.println("Digite o ID do Contato");
							Scanner id_contato = new Scanner(System.in);
							int idc_telefone = id_contato.nextInt();
							System.out.println("Digite o Tipo");
							Scanner tipo_tel = new Scanner(System.in);
							String t_telefone = tipo_tel.nextLine();
							insertTelefone(n_telefone,idc_telefone,t_telefone);
						}
					
						if(menu_telefone==2) {
							System.out.println("Digite o ID do telefone a ser alterado");
							Scanner id_tel = new Scanner(System.in);
							int id_telefone = id_tel.nextInt();
							System.out.println("Digite o novo numero do telefone");
							Scanner nmr_telefone = new Scanner(System.in);
							int n_telefone = nmr_telefone.nextInt();
							System.out.println("Digite o Tipo");
							Scanner tipo_tel = new Scanner(System.in);
							String t_telefone = tipo_tel.nextLine();
							updateTelefone(id_telefone,n_telefone,t_telefone);
						}
						
						if(menu_telefone==3) {
							System.out.println("Digite o ID do telefone");
							Scanner id_telefone = new Scanner(System.in);
							int id_tel = id_telefone.nextInt();
							deletetelefone(id_tel);
							
						}
						
						if(menu_telefone==4) {
							System.out.println("Digite o ID do Contato");
							Scanner idc_telefone = new Scanner(System.in);
							int id_contato = idc_telefone.nextInt();
							selecttelefone(id_contato);
						}
			
			}
		if(menu_escolha==0) {
			System.exit(1);
		}
		if(menu_escolha!=1 && menu_escolha!=2 && menu_escolha!=3 && menu_escolha!=4 && menu_escolha!=5 && menu_escolha!=0) {
			
			System.out.println("Opção invalida!! \n");
		}
		
		}
		
	}
	//-------------------------------------------------METODO CIDADE---------------------------------------------------------------------------	
	
	private static void insertCidade(String n_cidade, String s_uf) {
		Cidade cidade = new Cidade();
		
		
		cidade.setNome(n_cidade);
		cidade.setUf(s_uf);

		try {
			ICidadeService objCidade = (ICidadeService) Naming.lookup("rmi://localhost:8282/cidade");
			objCidade.add(cidade);
			System.out.println("Dado inserido com Sucesso");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateCidade(int id_cidade, String n_cidade, String s_uf) {
		Cidade cidade = new Cidade();
		
		cidade.setId(id_cidade);
		cidade.setNome(n_cidade);
		cidade.setUf(s_uf);

		try {
			ICidadeService objCidade = (ICidadeService) Naming.lookup("rmi://localhost:8282/cidade");
			objCidade.update(cidade);
			System.out.println("Update realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
		
	private static void deletecidade(int id_cidade) {
		Cidade cidade = new Cidade();
		
		cidade.setId(id_cidade);
		
		try {
			ICidadeService objCidade = (ICidadeService) Naming.lookup("rmi://localhost:8282/cidade");
			objCidade.delete(cidade);
			System.out.println("Delete realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void selectcidade(String nome_cidade) {
		Cidade cidade = new Cidade();
		cidade.setNome(nome_cidade);
		try {
			ArrayList<Cidade> sc;
			ICidadeService objCidade = (ICidadeService) Naming.lookup("rmi://localhost:8282/cidade");
			sc = objCidade.select(cidade);
			
			for(Cidade c: sc) {
				System.out.println("\nID:"+c.getId()+" - " + c.getNome()+" - "+c.getUf()+"\n");
				
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}
	
	//-------------------------------------------------METODO CONTATO---------------------------------------------------------------------------
	

	private static void insertContato(String cpf_con, String rg_con, String n_contato, String apelido_con, String dt_con,
			String sexo_con) {
		Contato contato = new Contato();
		
		
		contato.setCpf(cpf_con);
		contato.setRg(rg_con);
        contato.setNome(n_contato);
        contato.setApelido(apelido_con);
        contato.setDt_nascimento(dt_con);
        contato.setSexo(sexo_con);
        
		try {
			IContatoService objContato = (IContatoService) Naming.lookup("rmi://localhost:8282/contato");
			objContato.add(contato);
			System.out.println("Dado inserido com Sucesso");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void updateContato(int id_contato, String cpf_con, String rg_con, String n_contato,
			String apelido_con, String dt_con, String sx_con) {
		Contato contato = new Contato();
		
		contato.setId(id_contato);
		contato.setCpf(cpf_con);
		contato.setRg(rg_con);
		contato.setNome(n_contato);
		contato.setApelido(apelido_con);
		contato.setDt_nascimento(dt_con);
		contato.setSexo(sx_con);

		try {
			IContatoService objContato = (IContatoService) Naming.lookup("rmi://localhost:8282/contato");
			objContato.update(contato);
			System.out.println("Update realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}

	
	
	private static void deletecontato(int id_contato) {
		Contato contato = new Contato();
		
		contato.setId(id_contato);
		
		try {
			IContatoService objContato = (IContatoService) Naming.lookup("rmi://localhost:8282/contato");
			objContato.delete(contato);
			System.out.println("Delete realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void selectcontato(String n_contato) {
		Contato contato = new Contato();
		
		contato.setNome(n_contato);
		
		try {
			ArrayList<Contato> scon;
			IContatoService objContato = (IContatoService) Naming.lookup("rmi://localhost:8282/contato");
			scon = objContato.select(contato);
			
			for(Contato c: scon) {
				System.out.println("\nID:"+c.getId()+ "\nCPF: "+c.getCpf()+"\nRG: " + c.getRg()+"\nNome: "+c.getNome()+"\nApelido: "
			+c.getApelido()+"\nData Nascimento: "+c.getDt_nascimento()+"\nSexo: "+c.getSexo()+"");
				
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//-------------------------------------------------METODO AGENDA---------------------------------------------------------------------------
	
	private static void insertAgenda(int id_con, String dt_agnd, String hr_agnd, String obs_agnd, String st_agnd) {
		Agenda agenda = new Agenda();
		
		
		agenda.setId_contato(id_con);
		agenda.setDt_agendamento(dt_agnd);
		agenda.setHorario(hr_agnd);
		agenda.setObs(obs_agnd);
		agenda.setSituacao(st_agnd);
		
		try {
			IAgendaService objAgenda = (IAgendaService) Naming.lookup("rmi://localhost:8282/agenda");
			objAgenda.add(agenda);
			System.out.println("Dado inserido com Sucesso");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateAgenda(int id_agenda, int id_con, String dt_agnd, String hr_agnd, String obs_agnd, String st_agnd) {
		Agenda agenda = new Agenda();
		
		agenda.setId(id_agenda);
		agenda.setId_contato(id_con);
		agenda.setDt_agendamento(dt_agnd);
		agenda.setHorario(hr_agnd);
		agenda.setObs(obs_agnd);
		agenda.setSituacao(st_agnd);
		
		try {
			IAgendaService objAgenda = (IAgendaService) Naming.lookup("rmi://localhost:8282/agenda");
			objAgenda.update(agenda);
			System.out.println("Update realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
		
	private static void deleteagenda(int id_agnd) {
		Agenda agenda = new Agenda();
		
		agenda.setId(id_agnd);
		
		try {
			IAgendaService objAgenda = (IAgendaService) Naming.lookup("rmi://localhost:8282/agenda");
			objAgenda.delete(agenda);
			System.out.println("Delete realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void selectagenda(int id_agnd) {
		Agenda agenda = new Agenda();
		agenda.setId(id_agnd);
		try {
			ArrayList<Agenda> sa;
			IAgendaService objAgenda = (IAgendaService) Naming.lookup("rmi://localhost:8282/agenda");
			sa = objAgenda.select(agenda);
			
			for(Agenda a: sa) {
				System.out.println("\nID: "+a.getId()+" \nID_Contato: " + a.getId_contato()+"\nData DE agendamento: "+a.getDt_agendamento()+
						"\nHorario: " +a.getHorario()+ "\nObs: " + a.getObs()+ "\nSituação: " + a.getSituacao()+"\n");
				
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

	}
	
	//-------------------------------------------------METODO ENDEREÇO
	
	private static void insertEndereco(int id_cidade, String sigla_uf, int id_contato, String logradouro, int numero, String bairro, String complemento, int cep) {
		Endereco endereco = new Endereco();
		
		
		endereco.setId_cidade(id_cidade);
		endereco.setSigla_uf(sigla_uf);
		endereco.setId_contato(id_contato);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setComplemento(complemento);
		endereco.setCep(cep);


		try {
			IEnderecoService objEndereco = (IEnderecoService) Naming.lookup("rmi://localhost:8282/endereco");
			objEndereco.add(endereco);
			System.out.println("Dado inserido com Sucesso");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateEndereco(int id_endereco, int id_cidade, String sigla_uf, int id_contato, String logradouro, int numero, String bairro, String complemento, int cep) {
		Endereco endereco = new Endereco();
		
		endereco.setId(id_endereco);
		endereco.setId_cidade(id_cidade);
		endereco.setSigla_uf(sigla_uf);
		endereco.setId_contato(id_contato);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setComplemento(complemento);
		endereco.setCep(cep);

		try {
			IEnderecoService objEndereco = (IEnderecoService) Naming.lookup("rmi://localhost:8282/endereco");
			objEndereco.update(endereco);
			System.out.println("Update realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteendereco(int id_endereco) {
		Endereco endereco = new Endereco();
		
		endereco.setId(id_endereco);
		
		try {
			IEnderecoService objEndereco = (IEnderecoService) Naming.lookup("rmi://localhost:8282/endereco");
			objEndereco.delete(endereco);
			System.out.println("Delete realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void selectendereco(int id_contato) {
		Endereco endereco = new Endereco();
		
		endereco.setId_contato(id_contato);
		
		try {
			ArrayList<Endereco> se;
			IEnderecoService objEndereco = (IEnderecoService) Naming.lookup("rmi://localhost:8282/endereco");
			se = objEndereco.select(endereco);
			
			for(Endereco e: se) {
				System.out.println("\nID:"+e.getId()+ "\nID Cidade: "+e.getId_cidade()+ "\nSigla UF: "+e.getSigla_uf()+ "\nID Contato: " + e.getId_contato()+
						"\nLogradouro: "+e.getLogradouro()+"\nNumero: "+e.getNumero()+"\nBairro: "+e.getBairro()+"\nComplemento: "+e.getComplemento()+"\nCep: "+e.getCep()+"\n");
				
	

			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//-------------------------------------------------METODO TELEFONE---------------------------------------------------------------------------
	
	private static void insertTelefone(int n_telefone, int idc_telefone, String t_telefone) {
		Telefone telefone = new Telefone();
		
		
		telefone.setNumero(n_telefone);
		telefone.setId_contato(idc_telefone);
        telefone.setTipo(t_telefone);

		try {
			ITelefoneService objTelefone = (ITelefoneService) Naming.lookup("rmi://localhost:8282/telefone");
			objTelefone.add(telefone);
			System.out.println("Dado inserido com Sucesso");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}

	
	private static void updateTelefone(int id_telefone, int n_telefone, String t_telefone) {
		Telefone telefone = new Telefone();
		
		telefone.setNumero(n_telefone);
        telefone.setTipo(t_telefone);
        telefone.setId(id_telefone);
        
        try {
			ITelefoneService objTelefone = (ITelefoneService) Naming.lookup("rmi://localhost:8282/telefone");
			objTelefone.update(telefone);
			System.out.println("Update realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void deletetelefone(int id_tel) {
		Telefone telefone = new Telefone();
		
		telefone.setId(id_tel);
		
		try {
			ITelefoneService objTelefone = (ITelefoneService) Naming.lookup("rmi://localhost:8282/telefone");
			objTelefone.delete(telefone);
			System.out.println("Delete realizado");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}

	private static void selecttelefone(int id_contato) {
		Telefone telefone = new Telefone();
		
		telefone.setId_contato(id_contato);
		
		try {
			ArrayList<Telefone> st;
			ITelefoneService objTelefone = (ITelefoneService) Naming.lookup("rmi://localhost:8282/telefone");
			st = objTelefone.select(telefone);
			
			for(Telefone t: st) {
				System.out.println("\nID:"+t.getId()+ "\nNumero: "+t.getNumero()+"\nID Contato: " + t.getId_contato()+"\nTipo: "+t.getTipo()+"\n");
				
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}

	
}
