drop database bangkokbd;

/*Criando o banco*/

create database if not exists bangkokbd character set latin1 collate latin1_swedish_ci;

/*Criando as tabelas*/

use bangkokbd;

create table banda(
	codigo int,
    nome varchar(30),
    genero varchar(30),
    constraint pk_banda primary key (codigo)
);

create table lugar(
	codigo int, 
    nome varchar(50),
    lotacao int, 
    logradouro varchar(50),
    numero varchar(20),
    complemento varchar(30),
    bairro varchar(30),
    cidade varchar(30),
    estado varchar(2),
    cep varchar (9),
    constraint pk_local primary key (codigo) 
);

create table evento(
	codigo int,
    descricao varchar(500),
    dia varchar(10),
    hora varchar(5),
    estado varchar(20),
    banda int not null,
    lugar int,
    constraint pk_evento primary key (codigo),
    constraint fk_banda_banda_codigo foreign key (banda) references banda (codigo) on update cascade on delete restrict,
    constraint fk_lugar_lugar_codigo foreign key (lugar) references lugar (codigo) on update cascade on delete restrict
);

create table cliente(
	codigo  int,
    nome varchar(50),
	tipo varchar (15),
    constraint pk_cliente primary key (codigo)
);

create table ingresso(
	codigoEvento int,
    codigoCliente int,
    constraint pk_ingresso primary key (codigoEvento, codigoCliente),
    constraint fk_codigoEvento_evento_codigo foreign key (codigoEvento) references evento (codigo) on update cascade on delete restrict,
    constraint fk_codigoCliente_cliente_codigo foreign key (codigoCLiente) references cliente (codigo) on update cascade on delete restrict
);

/*Inserindo dados*/

insert into banda (codigo, nome, genero) values
(1, 'Scorpions', 'Rock'),
(2, 'Henrique e Juliano', 'Sertanejo'),
(3, 'Coldplay', 'Alternativo'),
(4, 'Molejo', 'Pagode'),
(5, 'Bon Jovi', 'Rock');

insert into lugar (codigo, nome, lotacao, logradouro, numero, complemento, bairro, cidade, estado, cep) values
(1, 'Estádio Municipal Radialista Mário Helênio', 31863, 'Av. Eugênio do Nascimento', '10', null, 'Dom Orione', 'Juiz de Fora', 'MG', '36038-330'),
(2, 'Estádio Maracanã', 78838, 'Av. Pres. Castelo Branco', 'SN', null ,'Maracanã', 'Rio de Janeiro', 'RJ', '20271-130'),
(3, 'Estádio do Morumbi', 72039,  'Praça Roberto Gomes Pedrosa', '1', null, 'Morumbi', 'São Paulo', 'SP' , '05653-070');

insert into evento (codigo, descricao, dia, hora, estado, banda, lugar) values
(1, 'Show do Molejão', '10/11/2016', '22:00', 'ShowEstadoCadastrado', 4, 1),
(2, 'Show Coldplay', '20/4/2016', '21:00', 'ShowEstadoRealizado', 3, 2);

insert into cliente (codigo, nome, tipo) values
(1, 'Gilcicleide de Jesus', 'Estudante'),
(2, 'Walterson da Avenida', 'Normal'),
(3, 'Helenice de Sá', 'Fidelidade'),
(4, 'Otávio Goulart', 'Estudante'),
(5, 'Sylvia da Silva', 'Normal'),
(6, 'Cleber Mattos', 'Fidelidade');

insert into ingresso (codigoEvento, codigoCliente) values
(1,1),
(1,2),
(1,3),
(2,4),
(2,5),
(1,6);