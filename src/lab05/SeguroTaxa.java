package lab05;

public class SeguroTaxa extends Seguro {
	
	private double taxaAssegurada;
	

	public SeguroTaxa(int valor, double taxaAssegurada) {
		this.taxaAssegurada = taxaAssegurada;
		this.valorAssegurado = valor;
	}
	
	public int getValor() {
		return (int) (this.valorAssegurado * this.taxaAssegurada);
	}
	
	@Override
	public String toString() {
		return " - ASSEGURADA (TAXA) - " + this.taxaAssegurada + "%";
	}

}
