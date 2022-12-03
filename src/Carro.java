public abstract class Carro {
	// Atributos
	public String marca;
	public String modelo;
	public String tipoCaixa;
	public String tipoMotor;
	public int potencia;
	public int numLugares;
	public int numPortas;
	public int precoRenting;
	public int numDias;
	public boolean isAvailable;
	
	// Construtor
	public Carro(String marca, String modelo, String tipoCaixa, String tipoMotor, int potencia, int numLugares,
			int numPortas, int precoRenting, boolean isAvailable, int numDias) {
		this.marca = marca;
		this.modelo = modelo;
		this.tipoCaixa = tipoCaixa;
		this.tipoMotor = tipoMotor;
		this.potencia = potencia;
		this.numLugares = numLugares;
		this.numPortas = numPortas;
		this.precoRenting = precoRenting;
		this.isAvailable = isAvailable;
		this.numDias = numDias;
	}
}