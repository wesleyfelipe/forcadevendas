package com.pqt.forcadevendas.dao;

import com.pqt.forcadevendas.entity.Representante;

public interface IRepresentanteDAO {
	
	public Representante getRepresentante(long id);
	public Representante getRepresentante(String username);

}
