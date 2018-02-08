package com.gsw.presentatie.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TreinTests {

	private Trein trein = new Trein();
							
	

	@Test
	public void getId_succeeds(){
		Trein trein = new Trein();
		trein.setTrein_id(1L);
		assertEquals(1L, trein.getTrein_id());
	}

	@Test
	public void getMerk_succeeds(){
		Trein trein = new Trein();
		trein.setMerk("treinTest");
		assertEquals("treinTest", trein.getMerk());
	}

}
