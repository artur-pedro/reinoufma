package entities;

import java.util.Random;

public class Arqueiro extends Personagem implements actions {
	Random random = new Random();
	private int habilidadeArco;
	private int destreza;
	public Arqueiro(String nome) {
		super(nome);
		habilidadeArco = random. nextInt(5) + 1;;
		destreza = random. nextInt(3) + 1;
	}
	public Arqueiro(String nome, int força, int habilidadeArco, int destreza) {
		super(nome, força);
		this.habilidadeArco = habilidadeArco;
		this.destreza = destreza;
	}
	public int getHabilidadeArco() {
		return habilidadeArco;
	}
	public void setHabilidadeArco(int habilidadeArco) {
		this.habilidadeArco = habilidadeArco;
	}
	public int getDestreza() {
		return destreza;
	}
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	@Override
	public int ataque() {
		if(Alive()){
			System.out.println(nome + " lança uma flecha causando " + força*habilidadeArco*destreza + " de dano");
			return força*habilidadeArco*destreza;
		}
		else {
			System.err.println("Personagem " + nome + " não está vivo");
			return 0;
		}
	}
	@Override
	public Boolean dano(int dano) {
		if(Alive()) {
			hp -= dano;
			System.out.println(nome + " recebe " + dano + " de dano");
			resetHP();
			return true;
		}
		else {
			System.err.println("Personagem " + nome + " não está vivo");
			return false;
		}
	}
	@Override
	public void levelUp() {
		habilidadeArco += random.nextInt(10) + (1);
		destreza += random.nextInt(3) + (1);
		nivel++;
		this.hp = 10;
		hp += random.nextInt(10) + 1;
		força += random.nextInt(10) + (1);
		System.out.println("Parabéns " + nome + " Level UP!!!!");
	}
	@Override
	public void Detalhes() {
		System.out.println("Detalhes do arqueiro: ");
		super.Detalhes();
		System.out.println("Habilidade de arco: "
		+ this.habilidadeArco
		+"\nDestreza: "+this.destreza);
}	@Override
	public void detalhesCombate() {
		System.out.println(" --------- Arqueiro " + nome + " --------- ");
		super.Detalhes();
		System.out.println("Habilidade de arco: "
		+ this.habilidadeArco
		+", Destreza: "+this.destreza+ ".");
}
}
