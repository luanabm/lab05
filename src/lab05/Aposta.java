package lab05;

/**
 * Classe que representa uma aposta. Cada aposta possui os atributos com um nome do apostador, um
 * valor apostado e uma previs�o, e realiza m�todos espec�ficos.
 * 
 * @author Luana Barbosa de M�lo - 117210906
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
	 * Atributo para armazenar a previs�o da aposta.
	 */
	private String previsao;
	
	private Seguro seguro;
	

	/**
	 * Cria um "objeto" aposta a partir de um nome do apostador, um valor da aposta e uma
	 * previs�o.
	 * 
	 * @param nomeApostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previs�o da aposta.
	 */
	
	public Aposta(String nomeApostador, int valorAposta, String previsao) {
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
		this.seguro = new SemSeguro();
	}
	
	public Aposta(String nomeApostador, int valorAposta, String previsao, int valorSeguro) {
		this(nomeApostador, valorAposta, previsao);
		this.seguro = new SeguroValor(valorSeguro);
	}
	
	public Aposta(String nomeApostador, int valorAposta, String previsao, double taxaAssegurada) {
		this(nomeApostador, valorAposta, previsao);
		this.seguro = new SeguroTaxa(valorAposta, taxaAssegurada);
	}
	
	/**
	 * M�todo que retorna uma string com o valor da aposta em reais, para outras classes poderem acessar o atributo.
	 * 
	 * @return o valor da aposta em reais, no formato string.
	 */
	private String valorApostaReais() {
		return String.format("%.2f", ((double) this.valorAposta) / 100);
	}
	
	/**
	 * M�todo que retorna o valor da aposta, para outras classes poderem acessar o atributo.
	 * 
	 * @return o valor da aposta.
	 */
	public int getValorAposta() {
		return valorAposta;
	}
	
	/**
	 * M�todo que retorna a previs�o da aposta, para outras classes poderem acessar o atributo.
	 * 
	 * @return a previs�o da aposta.
	 */
	public String getPrevisao() {
		return previsao;
	}
	
	/**
	 * M�todo que retorna uma string com o nome do apostador, o valor da aposta em reais e a previs�o feita pelo o apostador.
	 * @return String 
	 */
	public String toString() {
		return nomeApostador + " - R$ " + valorApostaReais() + " - " + previsao + seguro.toString();
	}
	
	public void alterarSeguroValor(int valorAssegurado) {
		this.seguro = new SeguroValor(valorAssegurado);
	}
	
	public void alterarSeguroTaxa(double taxa) {
		this.seguro = new SeguroTaxa(this.valorAposta,taxa);
	}
	
	
}
