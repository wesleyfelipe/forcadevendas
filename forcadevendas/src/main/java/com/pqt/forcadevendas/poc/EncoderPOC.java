package com.pqt.forcadevendas.poc;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EncoderPOC {

	public static void main(String[] args){
		
		StandardPasswordEncoder encoder = new StandardPasswordEncoder("ThisIsASecretSoChangeMe");
		String result = encoder.encode("123");
		System.out.println(result);
	}
}
