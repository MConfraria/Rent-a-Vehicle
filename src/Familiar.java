public class Familiar extends Carro{

	public int bagageira;
	
	public Familiar(String marca, String modelo, String tipoCaixa, String tipoMotor, int potencia, int numLugares,
			int numPortas, int precoRenting, boolean isAvailable, int numDias, int bagageira) {
		super(marca, modelo, tipoCaixa, tipoMotor, potencia, numLugares, numPortas, precoRenting, isAvailable, numDias);
		this.bagageira = bagageira;
	}

}
