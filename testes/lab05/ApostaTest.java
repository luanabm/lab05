package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaTest {

	private Aposta apostaNova;
	
	@Before
	public void before() {
		apostaNova = new Aposta("Luana", 1000000, "VAI ACONTECER");
		
	}
	@Test
	public void testToString() {
		assertEquals(apostaNova.toString(), "Luana - R$ 10000,00 - VAI ACONTECER");
	}

	@Test
	public void testGetValorAposta() {
		assertEquals(apostaNova.getValorAposta(), 1000000);
	}
	
	@Test
	public void testGetPrevisao() {
		assertEquals(apostaNova.getPrevisao(), "VAI ACONTECER");
	}
	
}
