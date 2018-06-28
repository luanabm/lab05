package lab05;

/**
 * Classe que representa as situa��es que um cen�rio pode apresentar.
 * @author Luana Barbosa de M�lo - 117210906
 *
 */
public enum SituacoesCenarios {
	/**
	 * Atributos das situa��es, sendo elas finalizadas(ocorrendo ou n�o ocorrendo), e n�o finalizadas.
	 */
	Finalizado_Ocorreu("Finalizado(ocorreu)") , Finalizado_nOcorreu("Finalizado(nao ocorreu)"), Nao_Finalizado("Nao finalizado");

	/** 
	 * Atributo valor, do tipo string.
	 */
	private String valor;
	
	/**
	 *  Construtor da classe, recebendo uma string como parametro.
	 */
	private SituacoesCenarios(String valor) {
		this.valor = valor;
	}
	
	/**
	 * M�todo que retorna o valor da string.
	 * @return
	 */
	public String getValor() {
		return valor;
	}
	
	public String toString() {
		return valor;
	}
}
