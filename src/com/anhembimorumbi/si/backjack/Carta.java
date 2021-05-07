package com.anhembimorumbi.si.backjack;

public class Carta {
	
	public Integer valor; 
	public Integer naipe;
	public Integer peso;
	
	public Carta () {
	}
	
	public Carta(Integer valor, Integer naipe) {
		this.valor = valor;
		this.naipe = naipe;
		peso = valor>10 ? 10 : valor;
	}
	
	public String mostrarCarta() {
		String vCarta;
		String nCarta;
		
		if(valor > 1 && valor < 11)
			vCarta = valor+"";
		else if(valor == 1)
			vCarta = "A";
		else if(valor == 11)
			vCarta = "J";
		else if(valor == 12)
			vCarta = "Q";
		else
			vCarta = "K";
		
		if(naipe == 1)
			nCarta = "Ouro";
		else if(naipe == 2)
			nCarta = "Espadas";
		else if(naipe == 3)
			nCarta = "Copas";
		else
			nCarta = "Paus";
		return vCarta + "-" + nCarta;
	}

}
