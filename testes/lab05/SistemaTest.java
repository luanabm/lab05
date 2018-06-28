package lab05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

	private Sistema sistemaNovo;
	
	@Before
	public void before() {
		sistemaNovo = new Sistema(100, 0.1);
	}
	
	@Test
	public void testSistema() {
		sistemaNovo = new Sistema(100, 0.1);
	}
	
	@Test
	public void testGetCaixa() {
		assertEquals(sistemaNovo.getCaixa(),100);
	}
	
	@Test
	public void testCadastrarCenario() {
		assertEquals(sistemaNovo.cadastrarCenario("Vai pagar calculo2"),1);
	}

	@Test
	public void testExibirCenario() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		assertEquals(sistemaNovo.exibirCenario(1),"1 - Vai pagar calculo2 - Nao finalizado");
	}
	
	@Test
	public void testExibirCenarios() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarCenario("Vai pagar calculo2 PORRA");
		assertEquals(sistemaNovo.exibirCenarios(),"1 - Vai pagar calculo2 - Nao finalizado" + "2 - Vai pagar calculo2 PORRA - Nao finalizado");
	}
	
	@Test
	public void testCadastrarAposta() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
	}
	
	@Test
	public void testValorTotalApostas() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
		assertEquals(sistemaNovo.valorTotalApostas(1), 1000000);
	}
	
	@Test
	public void testTotalApostas() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
		assertEquals(sistemaNovo.totalApostas(1), 1);
	}
	
	@Test
	public void testExibeApostas() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
		assertEquals(sistemaNovo.exibeApostas(1),"Luana - R$ 10000,00 - VAI ACONTECER");
	}
	
	@Test
	public void testFecharAposta() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
		sistemaNovo.fecharAposta(1, true);
	}
	
	@Test 
	public void testGetCaixaCenario() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
		sistemaNovo.fecharAposta(1, true);
		assertEquals(sistemaNovo.getCaixaCenario(1), 0);
	}
	
	@Test
	public void testGetCaixaCenarioFalse() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
		sistemaNovo.fecharAposta(1, false);
		assertEquals(sistemaNovo.getCaixaCenario(1), 100000);
	}
	
	@Test
	public void testGetTotalRateio() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
		sistemaNovo.fecharAposta(1, true);
		assertEquals(sistemaNovo.getTotalRateioCenario(1), 0);
	}
	
	@Test
	public void testGetTotalRateioFalse() {
		sistemaNovo.cadastrarCenario("Vai pagar calculo2");
		sistemaNovo.cadastrarAposta(1, "Luana", 1000000, "VAI ACONTECER");
		sistemaNovo.fecharAposta(1, false);
		assertEquals(sistemaNovo.getTotalRateioCenario(1), 900000);
	}
	
	
}
