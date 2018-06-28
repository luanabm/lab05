package lab05;

/**
 * Classe que representa uma aposta. Cada aposta possui os atributos com um nome do apostador, um
 * valor apostado e uma previsão, e realiza métodos específicos.
 * 
 * @author Luana Barbosa de Mélo - 117210906
 *
 */
public class Aposta {
	
	/**
	 * Atributo para armazenar o Nome do apostador.
	 */
	private String nomeApostador;
	/**
	 * Atributo para armazenar o valor da aposta.
	 */
	private int valorAposta;
	/**
	 * Atributo para armazenar a previsão da aposta.
	 */
	private String previsao;
	
	/**
	 * Cria um "objeto" aposta a partir de um nome do apostador, um valor da aposta e uma
	 * previsão.
	 * 
	 * @param nomeApostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 */
	public Aposta(String nomeApostador, int valorAposta, String previsao) {
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}
	
	/**
	 * Método que retorna uma string com o valor da aposta em reais, para outras classes poderem acessar o atributo.
	 * 
	 * @return o valor da aposta em reais, no formato string.
	 */
	private String valorApostaReais() {
		return String.format("%.2f", ((double) this.valorAposta) / 100);
	}
	
	/**
	 * Método que retorna o valor da aposta, para outras classes poderem acessar o atributo.
	 * 
	 * @return o valor da aposta.
	 */
	public int getValorAposta() {
		return valorAposta;
	}
	
	/**
	 * Método que retorna a previsão da aposta, para outras classes poderem acessar o atributo.
	 * 
	 * @return a previsão da aposta.
	 */
	public String getPrevisao() {
		return previsao;
	}
	
	/**
	 * Método que retorna uma string com o nome do apostador, o valor da aposta em reais e a previsão feita pelo o apostador.
	 * @return String 
	 */
	public String toString() {
		return nomeApostador + " - R$ " + valorApostaReais() + " - " + previsao;
	}
	
	
}
