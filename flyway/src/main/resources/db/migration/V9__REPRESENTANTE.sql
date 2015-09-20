CREATE TABLE FDV_ONLINE.REPRESENTANTE (
	ID SERIAL,
	NOME VARCHAR(255) NOT NULL,
	CPF VARCHAR(12) UNIQUE NOT NULL,
	RG VARCHAR(11) UNIQUE NOT NULL,
	EMAIL VARCHAR(255) UNIQUE NOT NULL,
	FONE VARCHAR(25) UNIQUE NOT NULL,
	SITUACAO CHAR(1) NOT NULL,
	USERNAME VARCHAR(30) UNIQUE NOT NULL,
	SENHA VARCHAR(255) NOT NULL,
	PRIMARY KEY (ID)
);

INSERT INTO FDV_ONLINE.REPRESENTANTE (NOME, CPF, RG, EMAIL, FONE, SITUACAO, USERNAME, SENHA) VALUES ('Marcos Lopez', '12312312312','1231231231','mlopez@pqtcorp.com','33338767','A','mlopez','59ffc49110609b4e877286640eb6e5912275a8c868648f6d4392b3f474c3176b9d74374a031baa46');
INSERT INTO FDV_ONLINE.REPRESENTANTE (NOME, CPF, RG, EMAIL, FONE, SITUACAO, USERNAME, SENHA) VALUES ('Homer Simpson', '12312312612','1235231231','hsimpson@pqtcorp.com','87981231','A','hsimpson','59ffc49110609b4e877286640eb6e5912275a8c868648f6d4392b3f474c3176b9d74374a031baa46');
INSERT INTO FDV_ONLINE.REPRESENTANTE (NOME, CPF, RG, EMAIL, FONE, SITUACAO, USERNAME, SENHA) VALUES ('Olívia Marques', '12315312612','1234231231','omarques@pqtcorp.com','84981231','A','omarques','59ffc49110609b4e877286640eb6e5912275a8c868648f6d4392b3f474c3176b9d74374a031baa46');
INSERT INTO FDV_ONLINE.REPRESENTANTE (NOME, CPF, RG, EMAIL, FONE, SITUACAO, USERNAME, SENHA) VALUES ('Fernando Silva', '15312312612','8235231231','fsilva@pqtcorp.com','97981231','A','fsilva','59ffc49110609b4e877286640eb6e5912275a8c868648f6d4392b3f474c3176b9d74374a031baa46');
INSERT INTO FDV_ONLINE.REPRESENTANTE (NOME, CPF, RG, EMAIL, FONE, SITUACAO, USERNAME, SENHA) VALUES ('Marina Cruz', '32312312612','5235231231','mcruz@pqtcorp.com','87081231','A','mcruz','59ffc49110609b4e877286640eb6e5912275a8c868648f6d4392b3f474c3176b9d74374a031baa46');
INSERT INTO FDV_ONLINE.REPRESENTANTE (NOME, CPF, RG, EMAIL, FONE, SITUACAO, USERNAME, SENHA) VALUES ('Cassio Brito', '10312312612','1235230231','cbrito@pqtcorp.com','80981231','A','cbrito','59ffc49110609b4e877286640eb6e5912275a8c868648f6d4392b3f474c3176b9d74374a031baa46');
INSERT INTO FDV_ONLINE.REPRESENTANTE (NOME, CPF, RG, EMAIL, FONE, SITUACAO, USERNAME, SENHA) VALUES ('Cléber Silveira', '12312302612','1235237231','csilveira@pqtcorp.com','879819631','A','csilveira','59ffc49110609b4e877286640eb6e5912275a8c868648f6d4392b3f474c3176b9d74374a031baa46');
INSERT INTO FDV_ONLINE.REPRESENTANTE (NOME, CPF, RG, EMAIL, FONE, SITUACAO, USERNAME, SENHA) VALUES ('Sônia Machado', '48312312612','0535231231','smachado@pqtcorp.com','87966231','A','smachado','59ffc49110609b4e877286640eb6e5912275a8c868648f6d4392b3f474c3176b9d74374a031baa46');