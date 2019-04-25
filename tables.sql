CREATE TABLE CLIENTE (
EMAIL varchar(256) not null,
PASSWORD varchar(256) not null,
CPF varchar(14) not null,
NAME varchar(256) not null,
GENDER varchar(2) not null,
BIRTHDATE varchar(10) not null,
PHONE varchar(20) not null,

PRIMARY KEY (CPF)
);

CREATE TABLE LOCADORA 
(
EMAIL varchar(256) not null,
PASSWORD varchar(256) not null,
CNPJ varchar(19) not null,
NAME varchar(256) not null,
CITY varchar(256) not null,

PRIMARY KEY (CNPJ)
);

CREATE TABLE LOCACAO 
(
ID integer not null generated always as identity (start with 1, increment by 1),
CPF varchar(14) not null,
CNPJ varchar(19) not null,
RENTDATE date not null,

PRIMARY KEY (ID),
FOREIGN KEY (CPF) REFERENCES CLIENTE(CPF),
FOREIGN KEY (CNPJ) REFERENCES LOCADORA(CNPJ)
);

CREATE TABLE USUARIO 
(
EMAIL varchar(256) not null,
PASSWORD varchar(256) not null,
ROLE varchar(256) not null,

PRIMARY KEY (EMAIL)
);
