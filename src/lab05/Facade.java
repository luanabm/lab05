package lab05;

import easyaccept.EasyAccept;

/**
 * Classe que representa o facade, ou seja a fachada do programa.
 * 
 * @author Luana Barbosa de M�lo - 117210906
 *
 */
public class Facade {
	/**
	 * Atributo que ir� representar um sistema inicializado.
	 */
	private Sistema sistema;

	/**
	 * M�todo que inicializa um sistema a partir de uma quantidade inicial para o
	 * caixa e uma taxa.
	 * 
	 * @param caixa
	 *            Quantidade de dinheiro do sistema.
	 * @param taxa
	 *            Taxa que define a porcentagem do dinheiro das apostas a ser
	 *            destinado ao sistema.
	 */
	public void inicializa(int caixa, double taxa) {
		sistema = new Sistema(caixa, taxa);
	}

	/**
	 * M�todo que retorna a quantidade de dinheiro no caixa do sistema.
	 * 
	 * @return a quantidade de dinheiro no caixa do sistema.
	 */
	public int getCaixa() {
		return sistema.getCaixa();
	}

	/**
	 * M�todo que cadastra um c�nario novo no sistema, a partir de sua descri��o e o
	 * adiciona � lista de cen�rios do sistema.
	 * 
	 * @param descricao
	 *            descri��o do cen�rio.
	 * @return N�mero do cen�rio adicionado.
	 */
	public int cadastrarCenario(String descricao) {
		return sistema.cadastrarCenario(descricao);
	}

	public int cadastrarCenario(String descricao, int bonus) {
		return sistema.cadastrarCenario(descricao, bonus);
	}
	
	/**
	 * M�todo que retorna a representa��o em string de um cen�rio especifico.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return uma representa��o em string do cen�rio.
	 */
	public String exibirCenario(int cenario) {
		return sistema.exibirCenario(cenario);
	}

	/**
	 * M�todo que retorna a representa��o em string de todos os cen�rios cadastrados
	 * no sistema.
	 * 
	 * @return uma representa��o em string de todos os cen�rios cadastrados no
	 *         sistema.
	 * 
	 */
	public String exibirCenarios() {
		return sistema.exibirCenarios();
	}

	/**
	 * M�todo que cadastra uma aposta a partir do nome do apostador, do valor e da
	 * previs�o � um cen�rio especificado pelo n�mero, cadastrado no sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @param nomeApostador
	 *            Nome do apostador.
	 * @param valorAposta
	 *            Valor da aposta.
	 * @param previsao
	 *            Previs�o da aposta.
	 */
	public void cadastrarAposta(int cenario, String nomeApostador, int valorAposta, String previsao) {
		sistema.cadastrarAposta(cenario, nomeApostador, valorAposta, previsao);
	}

	/**
	 * M�todo que retorna o valor total apostado em um cen�rio espec�fico do
	 * sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return o valor total apostado em um cen�rio espec�fico.
	 */
	public int valorTotalDeApostas(int cenario) {
		return sistema.valorTotalApostas(cenario);
	}

	/**
	 * M�todo que retorna a quantidade total de apostas feita em um cen�rio
	 * espec�fico do sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return a quantidade total de apostas feita em um cen�rio espec�fico.
	 */
	public int totalDeApostas(int cenario) {
		return sistema.totalApostas(cenario);
	}

	/**
	 * M�todo que retorna a representa��o em string das apostas de um cen�rio do
	 * sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return uma representa��o em string das apostas de um cen�rio.
	 */
	public String exibeAposta(int cenario) {
		return sistema.exibeApostas(cenario);
	}

	/**
	 * M�todo que fecha um cen�rio espec�fico e modifica seu estado de acordo com o
	 * boolean passado como par�metro.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @param ocorreu
	 *            Boolean que informa se o cen�rio ocorreu ou n�o.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		sistema.fecharAposta(cenario, ocorreu);
	}

	/**
	 * M�todo que retorna a quantidade de dinheiro direcionada ao caixa ap�s o
	 * fechamento de um cen�rio espec�fico do sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return a quantidade de dinheiro direcionada ao caixa ap�s o fechamento de um
	 *         cen�rio espec�fico.
	 */
	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}

	/**
	 * M�todo que retorna a quantidade de dinheiro que ser� direcionada ao rateio
	 * entre os vencedores de um cen�rio espec�fico do sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return a quantidade de dinheiro que ser� direcionada ao rateio entre os
	 *         vencedores de um cen�rio espec�fico.
	 */
	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateioCenario(cenario);
	}
	
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorAssegurado, int custo) {
		return sistema.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorAssegurado, custo);
	}
	
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
		return sistema.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}
	
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return sistema.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}

	public static void main(String[] args) {
		args = new String[] { "lab05.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt",
				"acceptance_test/us6_test.txt"/*, "acceptance_test/us7_test.txt"*/ };
		EasyAccept.main(args);

	}

}
