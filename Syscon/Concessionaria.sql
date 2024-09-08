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
	vei_descricao varchar(250) not null
    vei_gal gallery (20)
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
	(0,'0',0,0);
insert into Cliente (cli_id,cli_nome,cli_whats,cli_con,cli_vei) values 
	(0,'0','0',0,0);
insert into Acessorios (ace_id,ace_nome,ace_vei) values 
	(0,'0',0);
insert into Veiculo (vei_id,vei_nome,vei_ano,vei_mod,vei_marca,
	vei_condicao,vei_placa,vei_km,vei_combustivel,vei_cambio,
	vei_carroc,vei_cor,vei_acess,vei_cli,vei_descricao,vei_gal) values 
	(0,'0',0,0,'0','0','0',0,'0','0','0','0',0,0,'0','0');
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
