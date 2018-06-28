package lab05;

import java.util.ArrayList;

/**
 * Classe que representa um cen�rio. Cada cen�rio possui os atributos de uma descri��o, uma
 * situacao e uma cole��o de apostas
 * 
 * @author Luana Barbosa de M�lo - 117210906
 *
 */
public class Cenario {
	
	private int numeracao;
	/**
	 * Atributo com uma lista de apostas para o cen�rio.
	 */
	private ArrayList<Aposta> apostas;
	/**
	 * Atributo que representa a descri��o do cen�rio.
	 */
	private String descricao;
	/**
	 * Atributo que representa a situa��o do cen�rio. Podendo ser: N�o finalizado, Finalizado (ocorreu) ou
	 * Finalizado (n ocorreu).
	 */
	private SituacoesCenarios situacao;
	
	
	/**
	 * Construtor que cria um "objeto" cen�rio a partir de uma descri��o.
	 * 
	 * @param descricao
	 *            descri��o do cen�rio;
	 */
	public Cenario(String descricao) {
		if (descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		this.descricao = descricao;
		this.situacao = SituacoesCenarios.Nao_Finalizado;
		this.apostas = new ArrayList<Aposta>();
	}
	
	@Override
	public String toString() {
		return this.descricao + " - " + this.situacao.toString();
	}
	
	/**
	 * M�todo que cadastra uma aposta. Cria uma nova aposta a partir do nome do apostador, do
	 * valor da aposta e de uma previs�o e adiciona a aposta na lista de apostas
	 * do cen�rio.
	 * 
	 * @param nomeApostador
	 *            Nome do apostador.
	 * @param valorAposta
	 *            Valor da aposta.
	 * @param previsao
	 *            Previs�o da aposta.
	 */
	public void cadastrarAposta(String nomeApostador, int valorAposta, String previsao) {
		this.apostas.add(new Aposta(nomeApostador,valorAposta,previsao));
	}

	/**
	 * M�todo que calcula e informa o valor total apostado em um cen�rio, independente da previs�o.
	 * 
	 * @return o valor total apostado em um cen�rio.
	 */
	public int valorTotalApostas() {
		int valorTotalApostas = 0;
		for (Aposta aposta : apostas) {
			valorTotalApostas += aposta.getValorAposta();
		}
		return valorTotalApostas;
	}
	

	/**
	 * M�todo que calcula e informa a quantidade total de apostas feitas no cen�rio.
	 * 
	 * @return a quantidade total de apostas de um cen�rio.
	 */
	public int totalApostas() {
		return this.apostas.size();
	}
	
	/**
	 * M�todo que retorna a representa��o em string de todas as apostas de um cen�rio.
	 * 
	 * @return uma representa��o em string das apostas.
	 */
	public String exibeApostas() {
		String retorno = "";

		for (Aposta a : apostas) {
			retorno += a.toString();
		}
		return retorno;
	}
	
	/**
	 * M�todo que finaliza um cen�rio alterando seu estado de acordo com o boolean passado como
	 * par�metro.
	 * 
	 * @param ocorreu
	 *            Informa se o cen�rio ocorreu ou n�o. True para ocorreu. False para
	 *            n ocorreu.
	 */
	public void finalizarCenario(boolean ocorreu) {
		if (ocorreu) {
			this.situacao = SituacoesCenarios.Finalizado_Ocorreu;
		}
		else {
			this.situacao = SituacoesCenarios.Finalizado_nOcorreu;
		}
	}
	
	/**
	 * M�todo que calcula ap�s um cen�rio ser finalizado, as apostas perdedoras e retorna o
	 * valor total que o caixa recebeu.
	 * 
	 * @return o valor total apurado no caixa.
	 */
	public int calculaCaixa() {
			int caixa = 0;
			for (Aposta a : apostas) {
			if (situacao == SituacoesCenarios.Finalizado_Ocorreu) {
				if (a.getPrevisao().equalsIgnoreCase("N VAI ACONTECER")) {
					caixa += a.getValorAposta();
				}
			}
			else if (situacao == SituacoesCenarios.Finalizado_nOcorreu) {
				if (a.getPrevisao().equalsIgnoreCase("VAI ACONTECER")) {
					caixa += a.getValorAposta();
				}
			}
			}
			
			return caixa;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeracao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (numeracao != other.numeracao)
			return false;
		return true;
	}
	
	
	
	
}
