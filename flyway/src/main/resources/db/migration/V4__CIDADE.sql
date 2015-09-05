CREATE TABLE FDV_ONLINE.CIDADE (
	ID SERIAL,
	NOME VARCHAR(255) NOT NULL,
	IDESTADO SERIAL REFERENCES FDV_ONLINE.ESTADO(ID) NOT NULL,
	PRIMARY KEY (ID)
);

INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('São Paulo', 4);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Porto Alegre', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('São Leopoldo', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Novo Hamburgo', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Dois Irmãos', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Esteio', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Rolante', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Brochier', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Pelotas', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Portão', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Canoas', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Rio Grande', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Gramado', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Canela', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Alegrete', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Caxias do Sul', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Bento Gonçalves', 1);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Florianópolis', 2);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Tubarão', 2);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Blumenau', 2);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Nova Veneza', 2);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Araranguá', 2);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Joinville', 2);
INSERT INTO FDV_ONLINE.CIDADE (NOME, IDESTADO) VALUES ('Jaraguá do Sul', 2);