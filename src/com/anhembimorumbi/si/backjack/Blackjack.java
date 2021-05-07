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
		
		System.out.print("##----Backjack - Engenharia de Dados - UAM----##\n");
		
		do {
		System.out.print("\n	|------------------------------|\n");
		System.out.print("	| Opção 1 - Novo jogo          |\n");
		System.out.print("	| Opção 2 - Desenvolvedores    |\n");
		System.out.print("	| Opção 3 - Sair               |\n");
		System.out.print("	|------------------------------|\n");
		System.out.print("   		Digite uma opção: ");
		
		opcao = entrada.nextInt();
		switch (opcao) {
		case 1:
			int qtdDecks;
			int tamPilha;
			String acao;
			
			System.out.println("\nNovo Jogo:");
			
			System.out.println("Com quantos decks você quer jogar (1-7)?");
			qtdDecks = entrada.nextInt();
			tamPilha = qtdDecks*52;
			
			//Criar deck
			Carta deck[] = new Carta[tamPilha];
			int cont = 0;
			for(int x=0; x<qtdDecks;x++)
				for(int i=0; i<13; i++)
					for(int j=0; j<4; j++) {
						deck[cont] = new Carta(i+1, j+1);
						cont++;
					}
			
			//Embaralhar deck
			List<Carta> myDeck = Arrays.asList(deck);
			Collections.shuffle(myDeck);
			
			//Instância a pilha
			Stack p = new Stack(tamPilha);
			
			//Popular a pilha com o deck embaralhado
			for (Carta r : myDeck)
				p.push(r);
			
			//Jogador 2
			ArrayList<Carta> jogador2 = new ArrayList<Carta>();
			int pontosJ2;
			jogador2.add(p.pop());
			jogador2.add(p.pop());
			System.out.println("\n<<Oponente:>>");
			System.out.println("As cartas do seu oponente são: " + exibirCartas(jogador2));
			pontosJ2 = somarCarta(jogador2);
			System.out.println("O oponente esta com " + pontosJ2 + " pontos." );
			if(pontosJ2==21)
				System.out.println("O oponente venceu");
			System.out.println("-----------------------------------------\n");
			
			
			//Jogador 1
			ArrayList<Carta> jogador1 = new ArrayList<Carta>();
			jogador1.add(p.pop());
			jogador1.add(p.pop());
			System.out.println("<<Jogador1:>>");
			System.out.println("Suas cartas são: " + exibirCartas(jogador1));
			System.out.println("Você esta com " + somarCarta(jogador1) + " pontos." );
			System.out.println("-----------------------------------------\n");
			
			System.out.println("\nDeseja comprar mais uma carta? (s/n)\n");
			acao = entrada.next();
			
			if(acao.equals("s"))
				while(acao.equals("s")) {
					jogador1.add(p.pop());
					System.out.println("Suas cartas são: " + exibirCartas(jogador1));
					System.out.println("Você esta com " + somarCarta(jogador1) + " pontos." );
					System.out.println("Deseja comprar mais uma carta? (s/n)");
					acao = entrada.next();
				};
			
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
	}
	
	private static int somarCarta(ArrayList<Carta> cartas) {
		int total=0;
		int qtdAs=0;
		
		for(Carta c : cartas)
			if(c.valor == 1)
				qtdAs++;
			else
				total += c.peso;
		
		//Usar os As como curinga
			for(int z=0; z<qtdAs; z++) {
				if((total+11)>21)
					total++;
				else
					total+=11;
			}
		
		return total;
	}
	
	public static String exibirCartas(ArrayList<Carta> cartas) {
		String mCartas="";
		for(Carta c : cartas)
			mCartas += c.mostrarCarta() + "; ";
		return mCartas;
	}

}
