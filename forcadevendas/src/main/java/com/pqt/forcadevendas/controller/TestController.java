package com.pqt.forcadevendas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pqt.forcadevendas.dao.ClienteDAO;
import com.pqt.forcadevendas.entity.Pais;

@RestController
public class TestController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public Pais test(){
		System.out.println("Hello!!!!!!!!");
		Pais pais = new Pais();
		pais.setNome("Test");
		return pais;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/test2")
	public int test2(){
		System.out.println("Hello!!!!!!!!");
		ClienteDAO dao = new ClienteDAO();
		return dao.executarQuery("FROM PAIS").size();
	}
	
	public static void main(String[] args){
		ClienteDAO dao = new ClienteDAO();
		System.out.println(dao.listarClientes().size());
	}

}
