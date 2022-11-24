create database petshop;
use petshop;

create table funcionario(
idFuncionario int primary key auto_increment,
email VARCHAR(60) unique,
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
nomeDono varchar(45),
nomeAnimal varchar(45),
telefone varchar(45),
animal varchar(45),
servico varchar(45),
hora varchar(45),
kilos varchar(45),
agenda varchar(45),
cpf varchar(45) 
);



