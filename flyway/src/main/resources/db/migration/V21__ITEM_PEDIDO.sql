CREATE TABLE IF NOT EXISTS FDV_ONLINE.ITEM_PEDIDO (
	ID SERIAL,
	IDPEDIDO SERIAL REFERENCES FDV_ONLINE.PEDIDO(ID) NOT NULL,
	IDPRODUTO SERIAL REFERENCES FDV_ONLINE.PRODUTO(ID) NOT NULL,
	TAMANHO VARCHAR(20) NOT NULL,
	QUANTIDADE INTEGER NOT NULL,
	PRIMARY KEY (ID)
);

INSERT INTO FDV_ONLINE.ITEM_PEDIDO (IDPEDIDO, IDPRODUTO, TAMANHO, QUANTIDADE) VALUES (1, 1, '37', 14);
INSERT INTO FDV_ONLINE.ITEM_PEDIDO (IDPEDIDO, IDPRODUTO, TAMANHO, QUANTIDADE) VALUES (1, 1, '38', 17);
INSERT INTO FDV_ONLINE.ITEM_PEDIDO (IDPEDIDO, IDPRODUTO, TAMANHO, QUANTIDADE) VALUES (1, 2, '38', 20);
INSERT INTO FDV_ONLINE.ITEM_PEDIDO (IDPEDIDO, IDPRODUTO, TAMANHO, QUANTIDADE) VALUES (1, 2, '37', 20);
INSERT INTO FDV_ONLINE.ITEM_PEDIDO (IDPEDIDO, IDPRODUTO, TAMANHO, QUANTIDADE) VALUES (2, 2, '34', 3);