package com.anhembimorumbi.si.backjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Blackjack {

	public static void main(String[] args) {
		Carta deck[] = new Carta[52];
		int cont = 0;	
		for(int i=0; i<13; i++) {
			for(int j=0; j<4; j++) {
				deck[cont] = new Carta(i+1, j+1);
				cont++;
			}
		}
		
		List<Carta> intDeck = Arrays.asList(deck);
		Collections.shuffle(intDeck);
		
		for (Carta r : intDeck)
			System.out.println(r.mostrarCarta());
			
	}

}
