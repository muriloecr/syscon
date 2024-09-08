create database Concessionaria;
use Concessionaria;
create table Consultor (
	con_id int(4) unique not null primary key,
    con_nome varchar(30) not null,
# ARMAZENA O CODIGO DOS CLIENTES
    con_cli int(4),
# ARMAZENA OS VEÍCULOS VISITADOS
    con_vei int(4)
#    foreign key (con_cli) references Cliente (cli_id),
#    foreign key (con_vei) references Veiculo (vei_id)
);
create table Cliente (
	cli_id int(4) unique not null primary key,
    cli_nome varchar(30) not null,
    cli_whats varchar(16) not null,
# ARMAZENA O CODIGO DO VENDEDOR
    cli_con int(4),
# ARMAZENA OS CODIGOS DE VEICULOS DE INTERESSE
    cli_vei int(4)
#   foreign key (cli_con) references Vendedor (ven_id),
#	foreign key (cli_res) references Veiculo (vei_id)
);
create table Veiculo (
	vei_id int(4) unique not null primary key,
    vei_nome varchar(30) not null,
    vei_ano int(2) not null,
    vei_mod int(2) not null,
    vei_marca varchar(30) not null,
    vei_condicao varchar(8) not null,
    vei_placa varchar(8) not null,
	vei_km int(8) not null,
    vei_combustivel varchar(15) not null,
    vei_cambio varchar(15) not null,
    vei_carroc varchar(15) not null,
    vei_cor varchar(15) not null,
# ARMAZENA O CODIGO DE ACESSORIOS DO VEÍCULO
    vei_aces int(4),
# ARMAZENA OS CLIENTES INTERESSADOS
	vei_cli int(4),
# ARMAZENA OS CONSULTORES
	vei_con int(4),
	vei_descricao varchar(250) not null,
    vei_gal longblob
#   foreign key (vei_vis) references Cliente (cli_id)
#	foreign key (vei_aces) references Acessorios (ace_id)
#   foreign key (vei_res) references Cliente (cli_id)
);
create table Acessorios (
	ace_id int(4) unique not null primary key,
    ace_nome varchar(30) not null,
# ARMAZENA OS VEÍCULOS QUE CONTÉM ESTE ACESSÓRIO
    ace_vei int(4)
#   foreign key (ace_vei) references Veiculo (vei_id)
);
insert into Consultor (con_id,con_nome,con_cli,con_vei) values 
	(0,'0',0,0),(1111,'jose durval',0001,0001),(2222,'maria do socorro',0002,0002),
    (3333,'paulo sanches',0003,0001),(4444,'clara antunes',0006,0003);
insert into Cliente (cli_id,cli_nome,cli_whats,cli_con,cli_vei) values 
	(0,'0','0',0,0),(0001,'carla maria','(85) 9.8947-8473',1111,0001),(0002,'jose abreu lima','(85) 9.4547-8473',4444,0004),
	(0006,'pedro felipe','(85) 9.8057-8783',2222,0002),(0005,'rogerio mateus','(85) 9.844357-8783',3333,0002),
    (0003,'edumondo dants','(85) 9.8457-8783',2222,0002),(0004,'marcio garci','(85) 9.8347-8876',3333,0003);
insert into Acessorios (ace_id,ace_nome,ace_vei) values 
	(0,'0',0),(0001,'alarme',1001),(0002,'airbags',1001),
    (0004,'som',1001),(0003,'gps',1001);
insert into Veiculo (vei_id,vei_nome,vei_ano,vei_mod,vei_marca,
	vei_condicao,vei_placa,vei_km,vei_combustivel,vei_cambio,
	vei_carroc,vei_cor,vei_acess,vei_cli,vei_con,vei_descricao,vei_gal) values 
	(0,'0',0,0,'0','0','0',0,'0','0','0','0',0,0,0,'0',''),
    (0001,'Saveiro',2020,2021,'volkswagen','usado','pns-9374',120.000,
    'flex','maunual','pick-up','azul',0001,0001,1111,'pickup nova e revisada',''),
    (0002,'Uno',2019,2020,'fiat','usado','kso-2586',180.000,
    'flex','maunual','passeio','verde',0003,0006,4444,'muito economico',''),
    (0003,'corsa',2019,2020,'gm','usado','ddo-2786',90.000,
    'flex','automatico','uber','branco',0002,0002,2222,'top',''),
    (0004,'ford k',2019,2020,'ford','novo','kso-2544',127.000,
    'flex','automatico','anda','bege',0004,0004,3333,'ainda anda','');
alter table Consultor add
	foreign key (con_cli) references Cliente (cli_id);
alter table Consultor add
	foreign key (ven_vei) references Veiculo (vei_id);
alter table Cliente add
	foreign key (cli_con) references Vendedor (ven_id);
alter table Cliente add
	foreign key (cli_res) references Veiculo (vei_id);
alter table Veiculo add
	foreign key (vei_vis) references Cliente (cli_id);
alter table Veiculo add
	foreign key (vei_aces) references Acessorios (ace_id);
alter table Veiculo add
	foreign key (vei_res) references Cliente (cli_id);
alter table Acessorios add
	foreign key (ace_vei) references Veiculo (vei_id);

select * from Consultor;
select * from Cliente;
select * from Veiculo;
select * from Acessorios;
