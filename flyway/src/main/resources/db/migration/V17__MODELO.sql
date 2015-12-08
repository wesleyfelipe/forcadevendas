CREATE TABLE FDV_ONLINE.MODELO (
	ID SERIAL,
	NOME VARCHAR(255) NOT NULL,
	IDMARCA SERIAL REFERENCES FDV_ONLINE.MARCA(ID) NOT NULL,
	IDCATEGORIA SERIAL REFERENCES FDV_ONLINE.CATEGORIA(ID) NOT NULL,
	IDDEPARTAMENTO SERIAL REFERENCES FDV_ONLINE.DEPARTAMENTO(ID) NOT NULL,
	IDCOLECAO SERIAL REFERENCES FDV_ONLINE.COLECAO(ID) NOT NULL,
	PRIMARY KEY (ID)
);

INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Scarpin XA11', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Peep Toe 4XD1', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Peep Toe Anabela TR4', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Peep Toe ZA', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Peep Toe CA', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Scarpin XA12', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Scarpin ZAS2', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Scarpin Z', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Peep Toe AA5', 12, 1, 1, 1);
INSERT INTO FDV_ONLINE.MODELO (NOME, IDMARCA, IDCATEGORIA, IDDEPARTAMENTO, IDCOLECAO) VALUES ('Peep Toe 6T', 12, 1, 1, 1);