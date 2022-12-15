
public class Utilitario extends Carro{

	public double consumos;

	public Utilitario(String marca, String modelo, String tipoCaixa, String tipoMotor, int potencia, int numLugares,
			int numPortas, int precoRenting, boolean isAvailable, int numDias, double consumos) {
		super(marca, modelo, tipoCaixa, tipoMotor, potencia, numLugares, numPortas, precoRenting, isAvailable, numDias);
		this.consumos = consumos;
	}

}
