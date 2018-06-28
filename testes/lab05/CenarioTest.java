package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenarioTest {
	
	private Cenario cenarioNovo;
	
	@Before
	public void before() {
		this.cenarioNovo = new Cenario("PAGAR CALCULO2",1);
	}

	@Test
	public void testToString() {
		assertEquals(cenarioNovo.toString(), "PAGAR CALCULO2 - Nao finalizado");
	}

	@Test
	public void testCadastrarAposta() {
		cenarioNovo.cadastrarAposta("Luana", 10000, "VAI ACONTECER");
	}
	
	@Test
	public void testValorTotalApostasZerada() {
		assertEquals(cenarioNovo.valorTotalApostas(), 0);
	}
	
	@Test
	public void testValorTotalApostas() {
		cenarioNovo.cadastrarAposta("Luana", 10000, "VAI ACONTECER");
		assertEquals(cenarioNovo.valorTotalApostas(), 10000);
	}
	
	@Test
	public void testTotalApostasZerada() {
		assertEquals(cenarioNovo.totalApostas(),0);
	}
	
	@Test
	public void testTotalApostas() {
		cenarioNovo.cadastrarAposta("Luana", 10000, "VAI ACONTECER");
		assertEquals(cenarioNovo.totalApostas(),1);
	}
	
	@Test
	public void testExibeApostas() {
		cenarioNovo.cadastrarAposta("Luana", 10000, "VAI ACONTECER");
		assertEquals(cenarioNovo.exibeApostas(),"Luana - R$ 100,00 - VAI ACONTECER");
	}
	
	@Test
	public void testFinalizarCenario() {
		cenarioNovo.finalizarCenario(true);
	}
	
	@Test
	public void testCalculaCaixaZero() {
		assertEquals(cenarioNovo.calculaCaixa(), 0);
	}
	
	@Test
	public void testCalculaCaixaZerado() {
		cenarioNovo.cadastrarAposta("Luana", 10000, "VAI ACONTECER");
		cenarioNovo.finalizarCenario(true);
		assertEquals(cenarioNovo.calculaCaixa(), 0);
	}
	
	@Test
	public void testCalculaCaixa() {
		cenarioNovo.cadastrarAposta("Luana", 10000, "VAI ACONTECER");
		cenarioNovo.finalizarCenario(false);
		assertEquals(cenarioNovo.calculaCaixa(),10000);
	}
}
