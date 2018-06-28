package lab05;

import java.util.ArrayList;

/**
 * Classe que representa o sistema. O sistema possui um caixa, uma taxa e uma
 * cole��o de cen�rios e os manipula de acordo com as especifica��es do
 * programa.
 * 
 * @author Luana Barbosa de M�lo - 117210906
 *
 */
public class Sistema {
	
	/** 
	 * Atributo que ir� armazenar a lista com os cen�rios do sistema.
	 */
	private ArrayList<Cenario> cenarios;
	/**
	 * ATributo que ir� armazenar a quantidade de dinheiro do sistema.
	 */
	private int caixa;
	/**
	 * ATributo que ir� armazenar a taxa que define a porcentagem do dinheiro das apostas a ser destinado ao
	 * sistema.
	 */
	private double taxa;
	
	/**
	 * Construtor que cria um sistema a partir de um valor inicial para o caixa e uma taxa.
	 * 
	 * @param valor
	 *            Valor inicial do caixa do sistema.
	 * @param taxa
	 *            Taxa que define a porcentagem do dinheiro das apostas a ser
	 *            destinado ao sistema.
	 */
	public Sistema(int valor, double taxa) {
		if (valor < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa <= 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.caixa = valor;
		this.taxa = taxa;
		this.cenarios = new ArrayList<Cenario>();
	}
	
	/**
	 * M�todo que retorna a quantidade de dinheiro no caixa do sistema.
	 * 
	 * @return a quantidade de dinheiro no caixa do sistema.
	 */
	public int getCaixa() {
		return caixa;
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
		this.cenarios.add(new Cenario(descricao));
		return cenarios.size();
	}
	
	/**
	 * M�todo que retorna a representa��o em string de um cen�rio especifico. 
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return uma representa��o em string do cen�rio.
	 */
	public String exibirCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (this.cenarios.size() < cenario) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return cenario + " - " + cenarios.get(cenario-1).toString();
	}
	
	/**
	 * M�todo que retorna a representa��o em string de todos os cen�rios cadastrados no sistema.
	 * 
	 * @return uma representa��o em string de todos os cen�rios cadastrados no
	 *         sistema.
	 * 
	 */
	public String exibirCenarios() {
		String Scenarios = "";
		for (int i = 0; i < cenarios.size(); i++) {
			Scenarios += (i+1) + " - " + cenarios.get(i).toString();
		}
		return Scenarios;
	}
	
	/**
	 * M�todo que cadastra uma aposta a partir do nome do apostador, do valor e da previs�o �
	 * um cen�rio especificado pelo n�mero, cadastrado no sistema.
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
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (this.cenarios.size() < cenario) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		if (nomeApostador == null || nomeApostador.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valorAposta <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || previsao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equalsIgnoreCase("VAI ACONTECER") || previsao.equalsIgnoreCase("N VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		this.cenarios.get(cenario -1).cadastrarAposta(nomeApostador, valorAposta, previsao);
	}
	
	/**
	 * M�todo que retorna o valor total apostado em um cen�rio espec�fico do sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return o valor total apostado em um cen�rio espec�fico.
	 */
	public int valorTotalApostas(int cenario) {
		return cenarios.get(cenario-1).valorTotalApostas();
	}
	
	/**
	 * M�todo que retorna a quantidade total de apostas feita em um cen�rio espec�fico do sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return a quantidade total de apostas feita em um cen�rio espec�fico.
	 */
	public int totalApostas(int cenario) {
		return this.cenarios.get(cenario - 1).totalApostas();
	}
	
	/**
	 * M�todo que retorna a representa��o em string das apostas de um cen�rio do sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return uma representa��o em string das apostas de um cen�rio.
	 */
	public String exibeApostas(int cenario) {
		return this.cenarios.get(cenario - 1).exibeApostas();
	}
	
	/**
	 * M�todo que fecha um cen�rio espec�fico e modifica seu estado de acordo com o boolean
	 * passado como par�metro.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @param ocorreu
	 *            Boolean que informa se o cen�rio ocorreu ou n�o.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.cenarios.get(cenario - 1).finalizarCenario(ocorreu);
		this.caixa += (int) Math.floor((this.cenarios.get(cenario - 1).calculaCaixa() * this.taxa));
	}

	/**
	 * M�todo que retorna e calcula a quantidade de dinheiro direcionada ao caixa ap�s o fechamento de um
	 * cen�rio espec�fico do sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return a quantidade de dinheiro direcionada ao caixa ap�s o fechamento de um
	 *         cen�rio espec�fico.
	 */
	public int getCaixaCenario(int cenario) {
		return (int) (this.cenarios.get(cenario - 1).calculaCaixa() * this.taxa);
	}

	/**
	 * M�todo que calcula e retorna a quantidade de dinheiro que ser� direcionada ao rateio entre os
	 * vencedores de um cen�rio espec�fico do sistema.
	 * 
	 * @param cenario
	 *            N�mero do cen�rio.
	 * @return a quantidade de dinheiro que ser� direcionada ao rateio entre os
	 *         vencedores de um cen�rio espec�fico.
	 */
	public int getTotalRateioCenario(int cenario) {
		return this.cenarios.get(cenario - 1).calculaCaixa()
				- (int) (this.cenarios.get(cenario - 1).calculaCaixa() * this.taxa);
	}
	
}
