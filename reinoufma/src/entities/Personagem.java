package entities;

import java.util.Random;

public abstract class Personagem implements actions {
	Random random = new Random();
	protected String nome;
	protected int nivel;
	protected int força;
	protected int hp;
	public Personagem(String nome) {
		this.nome = nome;
		nivel = 1;
		força = random.nextInt(5) + 1;
		hp = 10;
	}
	public Personagem(String nome, int força) {
		this.nome = nome;
		nivel = 1;
		this.força = força;
	     hp = 10;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getForça() {
		return força;
	}
	public void setForça(int força) {
		this.força = força;
	}
	public float getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public Boolean Alive() {
		if(hp>0) {
			return true;
		}
		else {
			System.err.println("Personagem " + nome + " está morto");
			return false;
		}
	}
	public void resetHP() {
		if(hp<=0) {
			System.err.println("Personagem " + nome + " Está morto");
			hp = 0;
		}
	}
	@Override
	public abstract Boolean dano(int dano);
	@Override
	public abstract int ataque();
	public abstract void levelUp();
	public abstract void detalhesCombate();
	@Override
	public void Detalhes() {
		System.out.println("Nome: " 
		+ nome 
		+ "\nNivel: " 
		+ nivel 
		+ "\nForça: " 
		+ força 
		+ "\nPontos de vida: " 
		+ hp);	
		}
}