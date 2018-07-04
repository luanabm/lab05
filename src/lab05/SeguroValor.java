package lab05;

public class SeguroValor extends Seguro {
	
	public SeguroValor (int valorAssegurado) {
		this.valorAssegurado = valorAssegurado;
	}
	
	public int getValor() {
		return this.valorAssegurado;
	}
	
	@Override
	public String toString() {
		return " - ASSEGURADA (VALOR) - R$ " + String.format("%.2f", this.valorAssegurado / 100.0); 
	}
	
	

}
