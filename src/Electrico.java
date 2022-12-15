public class Electrico extends Carro {

	public int autonomia;
	
	public Electrico(String marca, String modelo, String tipoCaixa, String tipoMotor, int potencia, int numLugares,
			int numPortas, int precoRenting, boolean isAvailable, int numDias, int autonomia) {
		super(marca, modelo, tipoCaixa, tipoMotor, potencia, numLugares, numPortas, precoRenting, isAvailable, numDias);
		this.autonomia = autonomia;
	}

}
