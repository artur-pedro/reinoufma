package entities;

import java.util.Random;

public class Guerreiro extends Personagem implements actions {
	Random random = new Random();
	private int habilidadeCombate;
	private int escudo;
	public Guerreiro(String nome) {
		super(nome);
		habilidadeCombate = random.nextInt(5) + 1;
		escudo = 10;
	}
	public Guerreiro(String nome, int força, int habilidadeCombate, int escudo) {
		super(nome, força);
		this.habilidadeCombate = habilidadeCombate;
		this.escudo = escudo;
	}
	public int getHabilidadeCombate() {
		return habilidadeCombate;
	}
	public void setHabilidadeCombate(int habilidadeCombate) {
		this.habilidadeCombate = habilidadeCombate;
	}
	public int getEscudo() {
		return escudo;
	}
	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	@Override
	public int ataque() {
		if(Alive()) {
		System.out.println(nome + " lança um ataque de " + força*habilidadeCombate + " de dano");
		return força*habilidadeCombate;
		}
		else {
			System.err.println("Personagem " + nome + " não está vivo");
		return 0;
		}
	}
	@Override
	public Boolean dano(int dano) {
		if(Alive()) {
			if(dano <= escudo) {
				escudo -= dano;
				System.out.println(nome + " recebe " + dano + " de dano");
			}
			else {
				if(dano > escudo) {
				float danoaux = dano;
				float aux = escudo;
				escudo -= dano;
				if(escudo < 0) {
					escudo = 0;
				}
				dano -= aux;
				hp -= dano;
				System.out.println(nome + " recebe " + danoaux + " de dano");
				}
			}
			resetHP();
		}
		else {
		System.err.println("Personagem " + nome + " não está vivo");
		return false;
		}
		return false;
	}
	@Override
	public void levelUp() {
		habilidadeCombate += random.nextInt(10) + (1);
		escudo = 10;
		escudo *= random.nextInt(3) + (1);
		nivel++;
		this.hp = 10;
		hp += random.nextInt(10) + 1;
		força += random.nextInt(10) + (1);
		System.out.println("Parabéns " + nome + " Level UP!!!!");
	}
	@Override
	public void Detalhes() {
		System.out.println("Detalhes do guerreiro: ");
		super.Detalhes();
		System.out.println("Habilidade de Combate: "
		+ this.habilidadeCombate
		+"\nEscudo: "+this.escudo);
}
	@Override
	public void detalhesCombate() {
		System.out.println(" --------- Guerreiro " + nome + " --------- ");
		super.Detalhes();
		System.out.println("Habilidade de Combate: "
		+ this.habilidadeCombate
		+", Escudo: "+this.escudo + ".");
}
}
