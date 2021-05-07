package com.anhembimorumbi.si.backjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Integer opcao;
		
		System.out.print("##--Backjack - Engenharia de Dados - UAM--##\n");
		
		do {
		System.out.print("\n|-----------------------------|\n");
		System.out.print("| Opção 1 - Novo jogo         |\n");
		System.out.print("| Opção 2 - Desenvolvedores   |\n");
		System.out.print("| Opção 3 - Sair              |\n");
		System.out.print("|-----------------------------|\n");
		System.out.print("Digite uma opção: ");
		
		opcao = entrada.nextInt();
		switch (opcao) {
		case 1:
			int qtdDecks;
			int tamPilha;
			
			System.out.println("\nNovo Jogo:");
			
			System.out.println("Com quantos decks você quer jogar (1-7)?");
			qtdDecks = entrada.nextInt();
			tamPilha = qtdDecks*52;
			
			Carta deck[] = new Carta[tamPilha];
			int cont = 0;
			for(int x=0; x<qtdDecks;x++)
				for(int i=0; i<13; i++)
					for(int j=0; j<4; j++) {
						deck[cont] = new Carta(i+1, j+1);
						cont++;
					}
				
			List<Carta> myDeck = Arrays.asList(deck);
			Collections.shuffle(myDeck);
			
//			for (Carta r : myDeck)
//				System.out.println(r.mostrarCarta());
			
			
			
			Stack p = new Stack(tamPilha);
			
			for (Carta r : myDeck)
				p.push(r);
			
			
			ArrayList<Carta> jogador1 = new ArrayList<Carta>();
			jogador1.add(p.pop());
			jogador1.add(p.pop());
			System.out.println("Suas cartas são: ");
			
			for(Carta carta : jogador1)
				System.out.print(carta.mostrarCarta()+"; ");
			
			
			break;
		
		case 2:
			System.out.print("\nDesenvolvedores:\n");
			System.out.println("Dennis Gomes de Sousa		   |	RA: 21362173");
			System.out.println("Marcos Custódio Torres		   |	RA: 20149745");
			System.out.println("Pedro Henrique Siqueira TIhameri   |	RA: 21363765");
			break;
		
		case 3:
			System.out.print("\nAté logo!\n");
			entrada.close();
			break;
			
		default:
			System.out.print("\nOpção Inválida!");
			break;		
		}
		

		}while(opcao != 3);
		
			
//		System.out.println(p.pop().mostrarCarta()); 
//		System.out.println(p.pop().mostrarCarta()); 
			
	}

}
