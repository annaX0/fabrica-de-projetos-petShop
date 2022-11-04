create database petshop;
use petshop;

create table funcionario(
idFuncionario int primary key auto_increment,
nome VARCHAR(60) unique,
senha VARCHAR(30),
nivel INT,
cpf VARCHAR(45),
funcao VARCHAR(45)
);

create table cliente(
idCliente int primary key auto_increment,
nome varchar(60),
email varchar(60),
endereco varchar(120),
telefone int
);

create table pet(
idPet int primary key auto_increment,
nome varchar(60),
especie varchar(60),
data_nascimento date,
idDono int references Cliente(idCliente)
);

create table agendamento(
idFuncionario int references funcionario(idFuncionario),
idDono int references cliente(idCliente),
idPet int references pet(idPet),
acao varchar(45),
descricao varchar(45),
data_agendamento date
);



