package com.anhembimorumbi.si.backjack;

public class Stack {
	private int dados[];
	private int topo;
	
	public Stack(int max) {
		this.dados = new int[max];
		this.topo = 0;
	}
	
	public int size() {
		return this.topo;
	}
	
	public void push(int elem) {
			if(this.dados.length > this.topo) {
			this.dados[this.topo] = elem;
			this.topo++;
		}
	}
	
	public int pop() {
		if(this.topo > 0) {
			this.topo--;
			return this.dados[this.topo];
		}
		else {
			System.out.println("Pilha vazia");
			return -1;
		}
	}
	
	public boolean isEmpty() {
		return topo == 0;
	}
	
	public boolean isFull() {
		return topo == dados.length;
	}
	
	public int top () {
		return topo > 0 ? topo -1 : -1;
	}
	
	public void reset() {
		topo = 0;
	}
}
