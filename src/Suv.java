
public class Suv extends Carro{
	
	public String tipoTracao;
	
	public Suv(String marca, String modelo, String tipoCaixa, String tipoMotor, int potencia, int numLugares,
			int numPortas, int precoRenting, boolean isAvailable, int numDias, String tipoTracao) {
		super(marca, modelo, tipoCaixa, tipoMotor, potencia, numLugares, numPortas, precoRenting, isAvailable, numDias);
		this.tipoTracao = tipoTracao;
	}

}
