import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu { 
	int idade, total = 0;
	List<String> veiculosAlugados = new ArrayList<String>();
	
	Scanner sc = new Scanner(System.in);
	
	//Desportivos
	Desportivo ferrari812 = new Desportivo("Ferrari", "812 Superfast", "Automática/Sequencial de 7 velocidades", "6.5 V12 N/A", 800, 2, 2, 2300, true, 0);
	Desportivo porsche992 = new Desportivo("Porsche", "911 (992) Turbo S", "Automática/Sequencial de 8 velocidades", "3.8 Boxer 6 Turbo", 641, 4, 2, 2200, true, 0);
	
	// Eléctricos
	Electrico kiaEv6 = new Electrico("Kia", "EV6", "Automática de 1 velocidade", "2 motores elétricos", 321, 5, 5, 1200, true, 0);
	Electrico miniElectric = new Electrico("Mini", "Electric", "Automática de 1 velocidade", "1 motor eléctrico", 181, 4, 3, 1000, true, 0);
	
	//Luxo
	Luxo bentleyContinental = new Luxo("Bentley", "Continental GT", "Automática/Sequencial de 8 velocidades", "6.0 W12 Twin-turbo", 650, 2, 4, 2800, true, 0);
	Luxo rollsRoyceGhost = new Luxo("Rolls-Royce", "Ghost", "Automática de 8 velocidades", "6.7 V12 Twin-Turbo", 563, 4, 4, 3000, true, 0);
	
	//Utilitários
	Utilitario vwGolf = new Utilitario("Volkswagen", "Golf 7 1.4 TSI ", "Manual", "1.4 TSI", 122, 5, 5, 1000, true, 0);
	Utilitario fordFiesta = new Utilitario("Ford", "Fiesta", "Manual", "1.0", 100, 5, 4, 100, true, 0);
	
	//SUV
	Suv mercedesGle = new Suv("Mercedes", "GLE", "Automática", "2.0", 255, 5, 4, 300, true, 0);
    Suv volvoXc90 = new Suv("Volvo", "XC90", "Automática", "2.0", 235, 5, 4, 300, true, 0);
    
    //Familiar
    Familiar mercedesC200 = new Familiar("Mercedes", "C200D", "Automática", "2.0", 163, 5, 4, 400, true, 0);
    Familiar fordFocus = new Familiar("Ford", "Focus", "Manual", "1.6", 123, 5, 4, 250, true, 0);
    
    //SuperDesportivas
    Mota r1 = new Mota("Yamaha", "YZF R1M", "manual", "A", 2, 998, 198, 200, true, 0);
    Mota panigale = new Mota("Ducati", "Panigale V4", "manual", "A", 1, 1103, 250, 2000, true, 0);
	
    //Naked
    Mota z1000 = new Mota("Kawasaki", "Z1000", "manual", "A", 2, 1043, 140, 150, true, 0);
    Mota mt10 = new Mota("Yamaha", "MT10", "manual", "A", 2, 998, 160, 180, true, 0);
    
    //Trail
    Mota africaTwin = new Mota("Honda", "Africa Twin", "manual", "A", 1084, 101, 200, 350, true, 0);
    Mota bmw1200gs = new Mota("BMW", "R1200GS", "manual", "A", 2, 1170, 125, 220, true, 0);
    
    //Scooter
    Mota pcx = new Mota("Honda", "Pcx 125", "auto", "A1", 2, 125, 11, 75, true, 0);
    Mota nmax = new Mota("Yamaha", "Nmax 125", "auto", "A1", 2, 125, 12, 75, true, 0);
    
    //Offroad
    Mota crf450 = new Mota("Honda", "CRF450R", "manual", "A2", 1, 450, 54, 150, true, 0);
    Mota kxf450 = new Mota("Kawasaki", "KXF450", "manual", "A2", 1, 449, 53, 150, true, 0);
    
    //Métodos
    public void apresentarDesportivos(int idade) {
    	System.out.println("Lista de desportivos:\n1 - Ferrari 812 Superfast - Ver especificações/alugar\n2 - Porsche 911 (992) Turbo S - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarCarros(idade);
				break;
			case 1:
				if (ferrari812.isAvailable == true) {
					System.out.println("--- " + ferrari812.marca + " " + ferrari812.modelo + " ---");
					System.out.println("Motor: " + ferrari812.tipoMotor);
					System.out.println("Potência: " + ferrari812.potencia + "cv");
					System.out.println("Caixa: " + ferrari812.tipoCaixa);
					System.out.println("Número de portas: " + ferrari812.numPortas);
					System.out.println("Número de lugares: " + ferrari812.numLugares);
					System.out.println("Preço: " + ferrari812.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						ferrari812.numDias = sc.nextInt();
						
						veiculosAlugados.add(ferrari812.marca + " " + ferrari812.modelo + " durante " + ferrari812.numDias + " dia/s");
						
						total += (ferrari812.numDias * ferrari812.precoRenting);
						ferrari812.isAvailable = false;
						
						showMenu();
						break;
					}
					else if (alugar == 0){
						apresentarDesportivos(idade);
						break;
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarDesportivos(idade);
						break;
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (ferrari812.numDias * ferrari812.precoRenting);
								ferrari812.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarDesportivos(idade);
								repeat = false;
								break;
							case 2:
								apresentarDesportivos(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (porsche992.isAvailable == true) {
					System.out.println("--- " + porsche992.marca + " " + porsche992.modelo + " ---");
					System.out.println("Motor: " + porsche992.tipoMotor);
					System.out.println("Potência: " + porsche992.potencia + "cv");
					System.out.println("Caixa: " + porsche992.tipoCaixa);
					System.out.println("Número de portas: " + porsche992.numPortas);
					System.out.println("Número de lugares: " + porsche992.numLugares);
					System.out.println("Preço: " + porsche992.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						porsche992.numDias = sc.nextInt();
						
						veiculosAlugados.add(porsche992.marca + " " + porsche992.modelo + " durante " + porsche992.numDias + " dia/s");
						
						total += (porsche992.numDias * porsche992.precoRenting);
						porsche992.isAvailable = false;
						
						showMenu();
						break;
					}
					else if (alugar == 0){
						apresentarDesportivos(idade);
						break;
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (porsche992.numDias * porsche992.precoRenting);
								porsche992.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarDesportivos(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarDesportivos(idade);
		}
    }
    
    public void apresentarElectricos(int idade) {
    	System.out.println("Lista de eléctricos:\n1 - Kia EV6 - Ver especificações/alugar\n2 - Mini Electric - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarCarros(idade);
				break;
			case 1:
				if (kiaEv6.isAvailable == true) {
					System.out.println("--- " + kiaEv6.marca + " " + kiaEv6.modelo + " ---");
					System.out.println("Motor: " + kiaEv6.tipoMotor);
					System.out.println("Potência: " + kiaEv6.potencia + "cv");
					System.out.println("Caixa: " + kiaEv6.tipoCaixa);
					System.out.println("Número de portas: " + kiaEv6.numPortas);
					System.out.println("Número de lugares: " + kiaEv6.numLugares);
					System.out.println("Preço: " + kiaEv6.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						kiaEv6.numDias = sc.nextInt();
						
						veiculosAlugados.add(kiaEv6.marca + " " + kiaEv6.modelo + " durante " + kiaEv6.numDias + " dia/s");
						
						total += (kiaEv6.numDias * kiaEv6.precoRenting);
						kiaEv6.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarElectricos(idade);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarElectricos(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (kiaEv6.numDias * kiaEv6.precoRenting);
								kiaEv6.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarElectricos(idade);
								repeat = false;
								break;
							case 2:
								apresentarElectricos(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (miniElectric.isAvailable == true) {
					System.out.println("--- " + miniElectric.marca + " " + miniElectric.modelo + " ---");
					System.out.println("Motor: " + miniElectric.tipoMotor);
					System.out.println("Potência: " + miniElectric.potencia + "cv");
					System.out.println("Caixa: " + miniElectric.tipoCaixa);
					System.out.println("Número de portas: " + miniElectric.numPortas);
					System.out.println("Número de lugares: " + miniElectric.numLugares);
					System.out.println("Preço: " + miniElectric.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						miniElectric.numDias = sc.nextInt();
						
						veiculosAlugados.add(miniElectric.marca + " " + miniElectric.modelo + " durante " + miniElectric.numDias + " dia/s");
						
						total += (miniElectric.numDias * miniElectric.precoRenting);
						miniElectric.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarElectricos(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (miniElectric.numDias * miniElectric.precoRenting);
								miniElectric.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarElectricos(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarElectricos(idade);
		}
    }
    
    public void apresentarLuxo(int idade) {
    	System.out.println("Lista de carros de luxo:\n1 - Bentley Continental GT - Ver especificações/alugar\n2 - Rolls Royce Ghost - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarCarros(idade);
				break;
			case 1:
				if (kiaEv6.isAvailable == true) {
					System.out.println("--- " + bentleyContinental.marca + " " + bentleyContinental.modelo + " ---");
					System.out.println("Motor: " + bentleyContinental.tipoMotor);
					System.out.println("Potência: " + bentleyContinental.potencia + "cv");
					System.out.println("Caixa: " + bentleyContinental.tipoCaixa);
					System.out.println("Número de portas: " + bentleyContinental.numPortas);
					System.out.println("Número de lugares: " + bentleyContinental.numLugares);
					System.out.println("Preço: " + bentleyContinental.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						bentleyContinental.numDias = sc.nextInt();
						
						veiculosAlugados.add(bentleyContinental.marca + " " + bentleyContinental.modelo + " durante " + bentleyContinental.numDias + " dia/s");
						
						total += (bentleyContinental.numDias * bentleyContinental.precoRenting);
						bentleyContinental.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarLuxo(idade);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarLuxo(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (rollsRoyceGhost.numDias * rollsRoyceGhost.precoRenting);
								rollsRoyceGhost.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarLuxo(idade);
								repeat = false;
								break;
							case 2:
								apresentarLuxo(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (rollsRoyceGhost.isAvailable == true) {
					System.out.println("--- " + rollsRoyceGhost.marca + " " + rollsRoyceGhost.modelo + " ---");
					System.out.println("Motor: " + rollsRoyceGhost.tipoMotor);
					System.out.println("Potência: " + rollsRoyceGhost.potencia + "cv");
					System.out.println("Caixa: " + rollsRoyceGhost.tipoCaixa);
					System.out.println("Número de portas: " + rollsRoyceGhost.numPortas);
					System.out.println("Número de lugares: " + rollsRoyceGhost.numLugares);
					System.out.println("Preço: " + rollsRoyceGhost.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						rollsRoyceGhost.numDias = sc.nextInt();
						
						veiculosAlugados.add(rollsRoyceGhost.marca + " " + rollsRoyceGhost.modelo + " durante " + rollsRoyceGhost.numDias + " dia/s");
						
						total += (rollsRoyceGhost.numDias * rollsRoyceGhost.precoRenting);
						rollsRoyceGhost.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarLuxo(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (rollsRoyceGhost.numDias * rollsRoyceGhost.precoRenting);
								rollsRoyceGhost.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarLuxo(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarLuxo(idade);
		}
    }

    public void apresentarUtilitarios(int idade) {
    	System.out.println("Lista de utilitários:\n1 - Volkswagen Golf 7 - Ver especificações/alugar\n2 - Ford Fiesta - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarCarros(idade);
				break;
			case 1:
				if (kiaEv6.isAvailable == true) {
					System.out.println("--- " + vwGolf.marca + " " + vwGolf.modelo + " ---");
					System.out.println("Motor: " + vwGolf.tipoMotor);
					System.out.println("Potência: " + vwGolf.potencia + "cv");
					System.out.println("Caixa: " + vwGolf.tipoCaixa);
					System.out.println("Número de portas: " + vwGolf.numPortas);
					System.out.println("Número de lugares: " + vwGolf.numLugares);
					System.out.println("Preço: " + vwGolf.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						vwGolf.numDias = sc.nextInt();
						
						veiculosAlugados.add(vwGolf.marca + " " + vwGolf.modelo + " durante " + vwGolf.numDias + " dia/s");
						
						total += (vwGolf.numDias * vwGolf.precoRenting);
						vwGolf.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarUtilitarios(idade);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarUtilitarios(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (vwGolf.numDias * vwGolf.precoRenting);
								vwGolf.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarUtilitarios(idade);
								repeat = false;
								break;
							case 2:
								apresentarUtilitarios(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (fordFiesta.isAvailable == true) {
					System.out.println("--- " + fordFiesta.marca + " " + fordFiesta.modelo + " ---");
					System.out.println("Motor: " + fordFiesta.tipoMotor);
					System.out.println("Potência: " + fordFiesta.potencia + "cv");
					System.out.println("Caixa: " + fordFiesta.tipoCaixa);
					System.out.println("Número de portas: " + fordFiesta.numPortas);
					System.out.println("Número de lugares: " + fordFiesta.numLugares);
					System.out.println("Preço: " + fordFiesta.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						fordFiesta.numDias = sc.nextInt();
						
						veiculosAlugados.add(fordFiesta.marca + " " + fordFiesta.modelo + " durante " + fordFiesta.numDias + " dia/s");
						
						total += (fordFiesta.numDias * fordFiesta.precoRenting);
						fordFiesta.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarUtilitarios(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (fordFiesta.numDias * fordFiesta.precoRenting);
								fordFiesta.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarUtilitarios(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarUtilitarios(idade);
		}
    }
       
    public void apresentarFamiliar(int idade) {
    	System.out.println("Lista de familiares:\n1 - Mercedes C200d - Ver especificações/alugar\n2 - Ford Focus - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarCarros(idade);
				break;
			case 1:
				if (mercedesC200.isAvailable == true) {
					System.out.println("--- " + mercedesC200.marca + " " + mercedesC200.modelo + " ---");
					System.out.println("Motor: " + mercedesC200.tipoMotor);
					System.out.println("Potência: " + mercedesC200.potencia + "cv");
					System.out.println("Caixa: " + mercedesC200.tipoCaixa);
					System.out.println("Número de portas: " + mercedesC200.numPortas);
					System.out.println("Número de lugares: " + mercedesC200.numLugares);
					System.out.println("Preço: " + mercedesC200.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						mercedesC200.numDias = sc.nextInt();
						
						veiculosAlugados.add(mercedesC200.marca + " " + mercedesC200.modelo + " durante " + mercedesC200.numDias + " dia/s");
						
						total += (mercedesC200.numDias * mercedesC200.precoRenting);
						mercedesC200.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarFamiliar(idade);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarFamiliar(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (mercedesC200.numDias * mercedesC200.precoRenting);
								mercedesC200.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarFamiliar(idade);
								repeat = false;
								break;
							case 2:
								apresentarFamiliar(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (fordFocus.isAvailable == true) {
					System.out.println("--- " + fordFocus.marca + " " + fordFocus.modelo + " ---");
					System.out.println("Motor: " + fordFocus.tipoMotor);
					System.out.println("Potência: " + fordFocus.potencia + "cv");
					System.out.println("Caixa: " + fordFocus.tipoCaixa);
					System.out.println("Número de portas: " + fordFocus.numPortas);
					System.out.println("Número de lugares: " + fordFocus.numLugares);
					System.out.println("Preço: " + fordFocus.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						fordFocus.numDias = sc.nextInt();
						
						veiculosAlugados.add(fordFocus.marca + " " + fordFocus.modelo + " durante " + fordFocus.numDias + " dia/s");
						
						total += (fordFocus.numDias * fordFocus.precoRenting);
						fordFocus.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarFamiliar(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (fordFocus.numDias * fordFocus.precoRenting);
								fordFocus.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarFamiliar(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarFamiliar(idade);
		}
    }
    
    public void apresentarSuv(int idade) {
    	System.out.println("Lista de SUV:\n1 - Mercedes GLE - Ver especificações/alugar\n2 - Volvo XC90 - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarCarros(idade);
				break;
			case 1:
				if (mercedesGle.isAvailable == true) {
					System.out.println("--- " + mercedesGle.marca + " " + mercedesGle.modelo + " ---");
					System.out.println("Motor: " + mercedesGle.tipoMotor);
					System.out.println("Potência: " + mercedesGle.potencia + "cv");
					System.out.println("Caixa: " + mercedesGle.tipoCaixa);
					System.out.println("Número de portas: " + mercedesGle.numPortas);
					System.out.println("Número de lugares: " + mercedesGle.numLugares);
					System.out.println("Preço: " + mercedesGle.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						mercedesGle.numDias = sc.nextInt();
						
						veiculosAlugados.add(mercedesGle.marca + " " + mercedesGle.modelo + " durante " + mercedesGle.numDias + " dia/s");
						
						total += (mercedesGle.numDias * mercedesGle.precoRenting);
						mercedesGle.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarSuv(idade);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarSuv(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (volvoXc90.numDias * volvoXc90.precoRenting);
								volvoXc90.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarSuv(idade);
								repeat = false;
								break;
							case 2:
								apresentarSuv(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (volvoXc90.isAvailable == true) {
					System.out.println("--- " + volvoXc90.marca + " " + volvoXc90.modelo + " ---");
					System.out.println("Motor: " + volvoXc90.tipoMotor);
					System.out.println("Potência: " + volvoXc90.potencia + "cv");
					System.out.println("Caixa: " + volvoXc90.tipoCaixa);
					System.out.println("Número de portas: " + volvoXc90.numPortas);
					System.out.println("Número de lugares: " + volvoXc90.numLugares);
					System.out.println("Preço: " + volvoXc90.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar o carro durante quantos dias?");
						volvoXc90.numDias = sc.nextInt();
						
						veiculosAlugados.add(volvoXc90.marca + " " + volvoXc90.modelo + " durante " + volvoXc90.numDias + " dia/s");
						
						total += (volvoXc90.numDias * volvoXc90.precoRenting);
						volvoXc90.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarSuv(idade);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (volvoXc90.numDias * volvoXc90.precoRenting);
								volvoXc90.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarSuv(idade);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarSuv(idade);
		}
    }
    
    public void apresentarCarros(int idade) {
    	boolean repeat = true;
    	
    	while (repeat == true) {
    		if (idade >= 25 && idade <= 55) {
    			System.out.println("1 - Desportivo\n2 - Eléctrico\n3 - Luxo\n4 - Utilitário\n5 - Familiar\n6 - SUV\n0 - Voltar atrás");
    			int input = sc.nextInt();
    			
    			switch(input) {
    				case 0:
    					showMenu();
    					repeat = false;
    				case 1:
    					apresentarDesportivos(idade);
    					repeat = false;
    					break;
    				case 2:
    					apresentarElectricos(idade);
    					repeat = false;
    					break;
    				case 3:
    					apresentarLuxo(idade);
    					repeat = false;
    					break;
    				case 4:
    					apresentarUtilitarios(idade);
    					repeat = false;
    					break;
    				case 5:
    					apresentarFamiliar(idade);
    					repeat = false;
    					break;
    				case 6:
    					apresentarSuv(idade);
    					repeat = false;
    					break;
    				default:
    					System.out.println("Opção não válida, volte a tentar");
    			}
    			
    			//repeat = false;
    		}
    		else {
    			System.out.println("1 - Eléctrico\n2 - Utilitário\n3 - Familiar\n4 - SUV");
    			int input = sc.nextInt();
    			
    			switch(input) {
    				case 1:
    					apresentarElectricos(idade);
    					repeat = false;
    					break;
    				case 2:
    					apresentarUtilitarios(idade);
    					repeat = false;
    					break;
    				case 3:
    					apresentarFamiliar(idade);
    					repeat = false;
    					break;
    				case 4:
    					apresentarSuv(idade);
    					repeat = false;
    					break;
    				default:
    					System.out.println("Opção não válida, volte a tentar.");
    			}
    		}
    	}
	}
    
    public void apresentarOffroad(int licenca) {
    	System.out.println("1 - " + kxf450.marca + " " + kxf450.modelo + " - Ver especificações/alugar\n2 - " + crf450.marca + " " + crf450.modelo + " - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarMotas(licenca);
				break;
			case 1:
				if (kxf450.isAvailable == true) {
					System.out.println("--- " + kxf450.marca + " " + kxf450.modelo + " ---");
					System.out.println("Motor: " + kxf450.cilindrada + " cc");
					System.out.println("Potência: " + kxf450.potencia + "cv");
					System.out.println("Caixa: " + kxf450.tipoCaixa);
					System.out.println("Número de lugares: " + kxf450.numLugares);
					System.out.println("Preço: " + kxf450.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						kxf450.numDias = sc.nextInt();
						
						veiculosAlugados.add(kxf450.marca + " " + kxf450.modelo + " durante " + kxf450.numDias + " dia/s");
						
						total += (kxf450.numDias * kxf450.precoRenting);
						kxf450.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarOffroad(licenca);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarOffroad(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (kxf450.numDias * kxf450.precoRenting);
								volvoXc90.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarOffroad(licenca);
								repeat = false;
								break;
							case 2:
								apresentarOffroad(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (crf450.isAvailable == true) {
					System.out.println("--- " + crf450.marca + " " + crf450.modelo + " ---");
					System.out.println("Motor: " + crf450.cilindrada + " cc");
					System.out.println("Potência: " + crf450.potencia + "cv");
					System.out.println("Caixa: " + crf450.tipoCaixa);
					System.out.println("Número de lugares: " + crf450.numLugares);
					System.out.println("Preço: " + crf450.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						crf450.numDias = sc.nextInt();
						
						veiculosAlugados.add(crf450.marca + " " + crf450.modelo + " durante " + crf450.numDias + " dia/s");
						
						total += (crf450.numDias * crf450.precoRenting);
						crf450.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarOffroad(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (crf450.numDias * crf450.precoRenting);
								crf450.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarOffroad(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarOffroad(licenca);
		}
    }
    
    public void apresentarTrail(int licenca) {
    	System.out.println("1 - " + africaTwin.marca + " " + africaTwin.modelo + " - Ver especificações/alugar\n2 - " + bmw1200gs.marca + " " + bmw1200gs.modelo + " - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarMotas(licenca);
				break;
			case 1:
				if (africaTwin.isAvailable == true) {
					System.out.println("--- " + africaTwin.marca + " " + africaTwin.modelo + " ---");
					System.out.println("Motor: " + africaTwin.cilindrada + " cc");
					System.out.println("Potência: " + africaTwin.potencia + "cv");
					System.out.println("Caixa: " + africaTwin.tipoCaixa);
					System.out.println("Número de lugares: " + africaTwin.numLugares);
					System.out.println("Preço: " + africaTwin.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						africaTwin.numDias = sc.nextInt();
						
						veiculosAlugados.add(africaTwin.marca + " " + africaTwin.modelo + " durante " + africaTwin.numDias + " dia/s");
						
						total += (africaTwin.numDias * africaTwin.precoRenting);
						africaTwin.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarTrail(licenca);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarTrail(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (africaTwin.numDias * africaTwin.precoRenting);
								africaTwin.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarTrail(licenca);
								repeat = false;
								break;
							case 2:
								apresentarTrail(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (bmw1200gs.isAvailable == true) {
					System.out.println("--- " + bmw1200gs.marca + " " + bmw1200gs.modelo + " ---");
					System.out.println("Motor: " + bmw1200gs.cilindrada + " cc");
					System.out.println("Potência: " + bmw1200gs.potencia + "cv");
					System.out.println("Caixa: " + bmw1200gs.tipoCaixa);
					System.out.println("Número de lugares: " + bmw1200gs.numLugares);
					System.out.println("Preço: " + bmw1200gs.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						bmw1200gs.numDias = sc.nextInt();
						
						veiculosAlugados.add(bmw1200gs.marca + " " + bmw1200gs.modelo + " durante " + bmw1200gs.numDias + " dia/s");
						
						total += (bmw1200gs.numDias * bmw1200gs.precoRenting);
						bmw1200gs.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarTrail(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (bmw1200gs.numDias * bmw1200gs.precoRenting);
								bmw1200gs.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarTrail(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarTrail(licenca);
		}
    }
    
    public void apresentarScooter(int licenca) {
    	System.out.println("1 - " + nmax.marca + " " + nmax.modelo + " - Ver especificações/alugar\n2 - " + pcx.marca + " " + pcx.modelo + " - Ver especificações/alugar\n0 - Voltar atrás");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 0:
				apresentarMotas(licenca);
				break;
			case 1:
				if (nmax.isAvailable == true) {
					System.out.println("--- " + nmax.marca + " " + nmax.modelo + " ---");
					System.out.println("Motor: " + nmax.cilindrada + " cc");
					System.out.println("Potência: " + nmax.potencia + "cv");
					System.out.println("Caixa: " + nmax.tipoCaixa);
					System.out.println("Número de lugares: " + nmax.numLugares);
					System.out.println("Preço: " + nmax.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						nmax.numDias = sc.nextInt();
						
						veiculosAlugados.add(nmax.marca + " " + nmax.modelo + " durante " + nmax.numDias + " dia/s");
						
						total += (nmax.numDias * nmax.precoRenting);
						nmax.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarScooter(licenca);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarScooter(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (nmax.numDias * nmax.precoRenting);
								nmax.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarScooter(licenca);
								repeat = false;
								break;
							case 2:
								apresentarScooter(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (pcx.isAvailable == true) {
					System.out.println("--- " + pcx.marca + " " + pcx.modelo + " ---");
					System.out.println("Motor: " + pcx.cilindrada + " cc");
					System.out.println("Potência: " + pcx.potencia + "cv");
					System.out.println("Caixa: " + pcx.tipoCaixa);
					System.out.println("Número de lugares: " + pcx.numLugares);
					System.out.println("Preço: " + pcx.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						pcx.numDias = sc.nextInt();
						
						veiculosAlugados.add(pcx.marca + " " + pcx.modelo + " durante " + pcx.numDias + " dia/s");
						
						total += (pcx.numDias * pcx.precoRenting);
						pcx.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarScooter(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (pcx.numDias * pcx.precoRenting);
								pcx.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarTrail(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarScooter(licenca);
		}
    }
    
    public void apresentarSuperdesportiva(int licenca) {
    	System.out.println("1 - " + r1.marca + " " + r1.modelo + " - Ver especificações/alugar\n2 - " + panigale.marca + " " + panigale.modelo + " - Ver especificações/alugar\n0 - Voltar atrás");
    	int opcao = sc.nextInt();
		
    	switch(opcao) {
			case 0:
				apresentarMotas(licenca);
				break;
			case 1:
				if (r1.isAvailable == true) {
					System.out.println("--- " + r1.marca + " " + r1.modelo + " ---");
					System.out.println("Motor: " + r1.cilindrada + " cc");
					System.out.println("Potência: " + r1.potencia + "cv");
					System.out.println("Caixa: " + r1.tipoCaixa);
					System.out.println("Número de lugares: " + r1.numLugares);
					System.out.println("Preço: " + r1.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						r1.numDias = sc.nextInt();
						
						veiculosAlugados.add(r1.marca + " " + r1.modelo + " durante " + r1.numDias + " dia/s");
						
						total += (r1.numDias * r1.precoRenting);
						r1.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarSuperdesportiva(licenca);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarSuperdesportiva(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (r1.numDias * r1.precoRenting);
								r1.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarSuperdesportiva(licenca);
								repeat = false;
								break;
							case 2:
								apresentarSuperdesportiva(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (panigale.isAvailable == true) {
					System.out.println("--- " + panigale.marca + " " + panigale.modelo + " ---");
					System.out.println("Motor: " + panigale.cilindrada + " cc");
					System.out.println("Potência: " + panigale.potencia + "cv");
					System.out.println("Caixa: " + panigale.tipoCaixa);
					System.out.println("Número de lugares: " + panigale.numLugares);
					System.out.println("Preço: " + panigale.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						panigale.numDias = sc.nextInt();
						
						veiculosAlugados.add(panigale.marca + " " + panigale.modelo + " durante " + panigale.numDias + " dia/s");
						
						total += (panigale.numDias * panigale.precoRenting);
						panigale.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarSuperdesportiva(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (panigale.numDias * panigale.precoRenting);
								panigale.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarSuperdesportiva(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarSuperdesportiva(licenca);
		}
    }
    
    public void apresentarNaked(int licenca) {
    	System.out.println("1 - " + mt10.marca + " " + mt10.modelo + " - Ver especificações/alugar\n2 - " + z1000.marca + " " + z1000.modelo + " - Ver especificações/alugar\n0 - Voltar atrás");
    	int opcao = sc.nextInt();
		
    	switch(opcao) {
			case 0:
				apresentarMotas(licenca);
				break;
			case 1:
				if (mt10.isAvailable == true) {
					System.out.println("--- " + mt10.marca + " " + mt10.modelo + " ---");
					System.out.println("Motor: " + mt10.cilindrada + " cc");
					System.out.println("Potência: " + mt10.potencia + "cv");
					System.out.println("Caixa: " + mt10.tipoCaixa);
					System.out.println("Número de lugares: " + mt10.numLugares);
					System.out.println("Preço: " + mt10.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						mt10.numDias = sc.nextInt();
						
						veiculosAlugados.add(mt10.marca + " " + mt10.modelo + " durante " + mt10.numDias + " dia/s");
						
						total += (mt10.numDias * mt10.precoRenting);
						mt10.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarNaked(licenca);
					}
					else {
						System.out.println("A opção inserida não é válida");
						apresentarNaked(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (mt10.numDias * mt10.precoRenting);
								mt10.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								apresentarNaked(licenca);
								repeat = false;
								break;
							case 2:
								apresentarNaked(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
			case 2:
				if (z1000.isAvailable == true) {
					System.out.println("--- " + z1000.marca + " " + z1000.modelo + " ---");
					System.out.println("Motor: " + z1000.cilindrada + " cc");
					System.out.println("Potência: " + z1000.potencia + "cv");
					System.out.println("Caixa: " + z1000.tipoCaixa);
					System.out.println("Número de lugares: " + z1000.numLugares);
					System.out.println("Preço: " + z1000.precoRenting + " €/dia");
					System.out.println("Alugar?\n1 - Sim\n0 - Voltar atrás");
					int alugar = sc.nextInt();
					
					if (alugar == 1) {
						System.out.println("Pretende alugar a mota durante quantos dias?");
						z1000.numDias = sc.nextInt();
						
						veiculosAlugados.add(z1000.marca + " " + z1000.modelo + " durante " + z1000.numDias + " dia/s");
						
						total += (z1000.numDias * z1000.precoRenting);
						z1000.isAvailable = false;
						
						showMenu();
					}
					else if (alugar == 0){
						apresentarNaked(licenca);
					}
				}
				else {
					boolean repeat = true;
					
					System.out.println("Pretende cancelar o aluguer?\n1 - Sim\n2 - Não");
					int input = sc.nextInt();
					
					while(repeat) {
						switch(input) {
							case 1:
								total -= (z1000.numDias * z1000.precoRenting);
								z1000.isAvailable = true;
								
								System.out.println("O seu aluguer foi cancelado");
								
								repeat = false;
								break;
							case 2:
								apresentarNaked(licenca);
								repeat = false;
								break;
							default:
								System.out.println("Opção não válida, volte a tentar.");
						}
					}
				}
				break;
				default:
					System.out.println("A opção inserida não é válida");
					apresentarNaked(licenca);
		}
    }
    
    public int escolherLicenca(int idade) {
        boolean repeat = true;
        int licenca = 0;
        
        while (repeat == true) {    
            if (idade >= 25 && idade <= 55) {
                System.out.println("Indique a sua licença: \n1 - A\n2 - A2\n3 - A1\n0 - Voltar ao menu principal");
                int opcao = sc.nextInt();
                
                switch(opcao) { 
	                case 0:
	                    showMenu();
	                    break;
	                case 1:
	                    licenca = 1;
	                    repeat = false;
	                    break;
	                case 2:
	                    licenca = 2;
	                    repeat = false;
	                    break;
	                case 3:
	                    licenca = 3;
	                    repeat = false;
	                    break;
	                default:
	                    System.out.println("Opção não válida, volte a tentar\n");
                }
            }
            else {
                System.out.println("Indique a sua licença: \n1 - A2 \n2 - A1\n0 - Voltar ao menu principal");
                int opcao = sc.nextInt();
                
                switch(opcao) {
                    case 1:
                        licenca = 2;
                        repeat = false;
                        break;
                    case 2:
                        licenca = 3;
                        repeat = false;
                        break;
                    case 0:
                        showMenu();
                        break;
                    default:
                        System.out.println("Opção não válida, volte a tentar\n");
                }
            }
        }
        return licenca;
    }
    
    public void apresentarMotas(int licenca) {
    	boolean repeat = true;
    	
    	while(repeat == true) {
    		if (licenca == 1) {
	            System.out.println("1- OffRoad\n2- Scooter\n3- Naked\n4- Trail\n5- Superdesportiva\n0- Voltar atrás");
	            int input = sc.nextInt();
	            
	            switch(input) {
	            	case 0:
	            		showMenu();
	            		repeat = false;
	            		break;
	            	case 1:
	            		apresentarOffroad(licenca);
	            		repeat = false;
	            		break;
	            	case 2:
	            		apresentarScooter(licenca);
	            		repeat = false;
	            		break;
	            	case 3:
	            		apresentarNaked(licenca);
	            		repeat = false;
	            		break;
	            	case 4:
	            		apresentarTrail(licenca);
	            		repeat = false;
	            		break;
	            	case 5:
	            		apresentarSuperdesportiva(licenca);
	            		repeat = false;
	            		break;
	            	default:
	            		System.out.println("Opção não válida, volte a tentar\n");
	            }
	    	}
	    	else if(licenca == 2) {
	    		System.out.println("1- Offroad\n2- Scooter\n0- Voltar atrás");
	    		int input = sc.nextInt();
	    		
	    		switch(input) {
	    			case 0:
	    				showMenu();
	    				repeat = false;
	            		break;
	    			case 1:
	    				apresentarOffroad(licenca);
	    				repeat = false;
	            		break;
	    			case 2:
	    				//apresentarScooter(idade);
	    				repeat = false;
	            		break;
	    			default:
	            		System.out.println("Opção não válida, volter a tentar\n");
	    		}
	    	}
	    	else if(licenca == 3) {
	    		System.out.println("1- Scooter\n0- Voltar atrás");
	    		int input = sc.nextInt();
	    		
	    		switch(input) {
	    			case 0:
	    				showMenu();
	    				repeat = false;
	            		break;
	    			case 1:
	    				//apresentarScooter(idade);
	    				repeat = false;
	            		break;
	            	default:
	            		System.out.println("Opção não válida, volte a tentar\n");
	    		}
	    	}
    	}	
    }
    
    public void showMenu() {
		boolean repeat = true;
		
		while(repeat == true){
			System.out.println("---------------------------\nBem-vindo ao Rent-a-Vehicle\n---------------------------");
			
			while (idade <= 0) {
				System.out.println("\nIndique a sua idade: ");
				idade = sc.nextInt();
			}
			
			if (idade >= 18 && idade <= 65) {
				System.out.println("Escolha uma das seguintes opções:\n1 - Alugar um automóvel\n2 - Alugar uma mota\n3 - Concluir o Aluguer\n0 - Voltar a inserir idade");
				int input = sc.nextInt();
				
				switch(input) {
					case 0:
						System.out.println("Insira a idade atualizada: ");
						idade = sc.nextInt();
						break;
					case 1:
						apresentarCarros(idade);
						repeat = false;
						break;
					case 2:
						apresentarMotas(escolherLicenca(idade));
						repeat = false;
						break;
					case 3:
						if (total == 0) {
							System.out.println("Não tem nada que pretenda alugar atualmente");
							showMenu();
							break;
						}
						else {
							System.out.println("Pretende alugar o/s seguinte/s veículo/s: \n");
							for(int i = 0; i < veiculosAlugados.size(); i++) {
								System.out.println(veiculosAlugados.get(i));
							}
							
							System.out.println("\nQue resultará num total de " + total + " €");
							System.out.println("Prosseguir com o aluguer?\n1 - Sim\n2 - Não");
							int escolha = sc.nextInt();
							
							if (escolha == 1) {
								System.out.println("Obrigado por viajar connosco");
								repeat = false;
								break;
							}
							else if(escolha == 2) {
								showMenu();
								break;
							}
							
						}
					default:
						System.out.println("Opção não válida, volte a tentar");
						break;
				}
				break;
			}
			else {
				System.out.println("Não é possível alugar nenhum veículo, repetir?\n1 - Sim\n0 - Não\n");
    			int input = sc.nextInt();
    			
    			switch (input) {
    				case 1:
    					idade = 0;
    					showMenu();
    					break;
    				case 0:
    					repeat = false;
    					break;
    				default:
    					System.out.println("Opção não válida, volte a tentar");
    			}	
			}
		}
	}
}