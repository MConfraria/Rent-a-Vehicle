public class Mota {
	String marca;
    String modelo;
    String tipoCaixa;
    String licenca;
    int numLugares;
    int cilindrada;
    int potencia;
    int precoRenting;
    int numDias;
    boolean isAvailable;
    
    public Mota(String marca, String modelo, String tipoCaixa, String licenca, int numLugares, int cilindrada, int potencia, int precoRenting, boolean isAvailable, int numDias) {
    		this.marca = marca;
    		this.modelo = modelo;
    		this.tipoCaixa = tipoCaixa;
    		this.licenca = licenca;
    		this.numLugares = numLugares;
    		this.cilindrada = cilindrada;
    		this.potencia = potencia;
    		this.precoRenting = precoRenting;
    		this.numDias = numDias;
    		this.isAvailable = isAvailable;
    }
}
