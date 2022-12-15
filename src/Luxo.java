
public class Luxo extends Carro{

	public String noiseCanceling;
	
	public Luxo(String marca, String modelo, String tipoCaixa, String tipoMotor, int potencia, int numLugares,
			int numPortas, int precoRenting, boolean isAvailable, int numDias, String noiseCanceling) {
		super(marca, modelo, tipoCaixa, tipoMotor, potencia, numLugares, numPortas, precoRenting, isAvailable, numDias);
		this.noiseCanceling = noiseCanceling;
	}

}
