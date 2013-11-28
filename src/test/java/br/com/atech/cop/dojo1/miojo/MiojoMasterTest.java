package br.com.atech.cop.dojo1.miojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MiojoMasterTest {

	@Test
	public void deveCozinharEm10Minutos() {
		assertEquals(10, new MiojoMaster().cozinhar(3, 5, 7));
	}

	@Test
	public void naoDaPraCozinharComTempoDeAmpulhetasIguais() {
		assertEquals(0, new MiojoMaster().cozinhar(3, 5, 5));
	}

	@Test
	public void naoDaPraCozinharComTemposNaoMultiplosDoCozimento() {
		assertEquals(0, new MiojoMaster().cozinhar(3, 4, 6));
		assertEquals(0, new MiojoMaster().cozinhar(4, 5, 7));
		assertEquals(0, new MiojoMaster().cozinhar(5, 6, 8));
	}

}
