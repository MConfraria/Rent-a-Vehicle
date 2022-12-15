public class Desportivo extends Carro{
	
	public double aceleracao;
	
	public Desportivo(String marca, String modelo, String tipoCaixa, String tipoMotor, int potencia, int numLugares,
			int numPortas, int precoRenting, boolean isAvailable, int numDias, double aceleracao) {
		super(marca, modelo, tipoCaixa, tipoMotor, potencia, numLugares, numPortas, precoRenting, isAvailable, numDias);
		this.aceleracao = aceleracao;
	}

}
