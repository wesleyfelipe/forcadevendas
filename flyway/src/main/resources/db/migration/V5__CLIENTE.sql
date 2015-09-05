CREATE TABLE FDV_ONLINE.CLIENTE (
	ID SERIAL,
	NOME VARCHAR(255) NOT NULL,
	CNPJ BIGINT UNIQUE NOT NULL,
	EMAIL VARCHAR(255),
	FONE BIGINT NOT NULL,
	ENDERECO VARCHAR(255) NOT NULL,
	SITUACAO CHAR(1) NOT NULL,
	IDCIDADE SERIAL REFERENCES FDV_ONLINE.CIDADE(ID) NOT NULL,
	PRIMARY KEY (ID)
);

INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('Calçados Londres', 123123123123, 'londrescalcados@gmail.com', 33338987, 'Rua da Fazenda, nº 300, Bairro Centro', 'A', 2);
INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('Calçados Lima', 123123123134, 'limacalcados@hotmail.com', 33338988, 'Av. Bento Gonçalves, nº 3432, Bairro Floresta', 'I', 2);
INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('Roma Calçados', 54565445353345, 'romacalcados@gmail.com', 33331987, 'Rua das Flores, nº 444, Bairro Centro', 'A', 2);
INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('Calçados Estrela', 454654645212, 'calcadosestrela@gmail.com', 33338987, 'Rua da Fazenda, nº 300, Bairro Centro', 'A', 2);
INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('Paris Modas', 64564645646, 'parismodas@hotmail.com', 33338987, 'Rua da Fazenda, nº 432, Bairro Centro', 'A', 2);
INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('MD Sports', 343345345343, 'mdsports@outlook.com', 333389997, 'Rua Conceição, nº 1111, Bairro Centro', 'A', 2);
INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('KD Bolsas', 1231231245423, 'kdbolsas@live.com', 333389997, 'Rua Marte, nº 432, Bairro Partenon', 'A', 2);
INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('XX Esportes', 12423424525, 'xxesportes@gmail.com', 333389197, 'Rua 7 de setembro, nº 7655, Bairro Três Figueiras', 'A', 2);
INSERT INTO FDV_ONLINE.CLIENTE (NOME, CNPJ, EMAIL, FONE, ENDERECO, SITUACAO, IDCIDADE) VALUES ('Kalçados', 4234325443534, 'kalcados@gmail.com', 333289197, 'Rua 20 de setembro, nº 7655, Bairro Centro', 'A', 2);