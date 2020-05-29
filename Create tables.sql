use [P1-Andre-SD]

create table Contato(
						ID int IDENTITY (1,1) not null,
						CPF varchar (11) not null,
						RG varchar (15),
						Nome varchar (50) not null,
						Apelido varchar (30),
						Dt_Nascimento varchar (20) not null,
						Sexo varchar(20) not null,
						constraint pk_contato primary key (ID),
						constraint un_contato unique (CPF),);

create table Telefone_Contato(
						ID int IDENTITY (1,1) not null,
						Numero int not null,
						ID_Contato int not null,
						Tipo varchar (10),
						constraint pk_telefone_contato primary key (ID),
						constraint un_telefone_contato unique (Numero,ID_Contato),
						constraint fk_telefone_contato foreign key (ID_Contato) references Contato (ID),);

create table Agenda(
						ID int IDENTITY (1,1) not null,
						ID_Contato int not null,
						Dt_Agendamento varchar (15) not null,
						Horario varchar (15) not null,
						Obs varchar (100),
						Situação varchar (30) not null,
						constraint pk_agenda primary key (ID),
						constraint fk_agenda foreign key (ID_Contato) references Contato (ID),);

create table UF(
						Sigla varchar (2) not null,
						Descricao varchar (30) not null,
						constraint pk_uf primary key (Sigla),);

create table Cidade(
						ID int IDENTITY (1,1) not null,
						Nome varchar (50) not null,
						Sigla_UF varchar (2) not null,
						constraint pk_cidade primary key (ID),
						constraint fk_cidade foreign key (Sigla_UF) references UF (Sigla),);

create table Endereco(
						ID int IDENTITY (1,1) not null,
						ID_Cidade int not null,
						Sigla_UF varchar (2) not null,
						ID_Contato int not null,
						Logradouro varchar (100) not null,
						Numero int not null,
						Bairro varchar (50) not null,
						Complemento varchar (100) not null,
						Cep int not null,
						constraint pk_endereço primary key (ID),
						constraint fk_endereço_cidade foreign key (ID_Cidade) references Cidade (ID),
						constraint fk_endereço_Sigla_UF foreign key (Sigla_UF) references UF (Sigla),
						constraint fk_endereço_contato foreign key (ID_Contato) references Contato (ID),);


drop table Endereco
drop table Cidade
drop table UF
drop table Agenda
drop table Telefone_Contato
drop table Contato

select * from cidade where Nome = 'Teste6'
select * from UF
select * from contato
select * from agenda
select * from endereco
select * from dbo.Table1$
select * from telefone_contato

insert into Cidade (Nome,Sigla_UF)
select Nome,Sigla_UF from dbo.Table1$ where Sigla_UF <> ''

update cidade set Nome = 'Teste5' ,Sigla_UF = 'PA' where ID = 

select id,nome,Sigla_uf from cidade where nome like '%araraquara%'

insert into contato values (4680558281,542163962,'Leunam','te','23/04/98','Masculino')
delete from contato where ID = 9

delete from telefone_contato where ID =1 

insert into Contato values('1', '2', 'teste', 'te', '23/54/22', 'masc')

select ID,CPF,RG,Nome,Apelido,Dt_Nascimento,Sexo from Contato where nome like '%Da%'

update contato set CPF = 10, RG =20 where ID = 10

select ID,ID_Contato,Dt_Agendamento,Horario,Obs,Situação from Agenda where ID = ''

insert into Agenda values (3,'22/22/22','22:22','Nada a dizer','Em andamento')

update agenda set ID_Contato = 2, Dt_Agendamento = '21/21/21', Horario = '21:21',Obs = 'Teste',Situação = 'kkkkkk' where ID = 

