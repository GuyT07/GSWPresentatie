package com.gsw.presentatie.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TreinTests {

	private Trein trein = new Trein();
							
	

	@Test
	public void getId_succeeds(){
		Trein trein = new Trein();
		trein.setId(1L);
		assertEquals(1L, trein.getId());
	}

	@Test
	public void getMerk_succeeds(){
		Trein trein = new Trein();
		trein.setMerk("treinTest");
		assertEquals("treinTest", trein.getMerk());
	}

}
