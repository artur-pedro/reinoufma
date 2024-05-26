package entities;
import java.util.Random;
public class Mago extends Personagem implements actions {	
	Random random = new Random();
	public int habilidadeMagica;
	public int esquiva;
	public int hpInicial;
	public Mago(String nome) {
		super(nome);
		habilidadeMagica = random.nextInt(5) + 1;
		esquiva = random.nextInt(6) + 1;
		hpInicial = hp;
	}
	public Mago(String nome, int força, int habilidadeMagica, int esquiva) {
		super(nome, força);
		this.habilidadeMagica = habilidadeMagica;
		this.esquiva = esquiva;
		hpInicial = hp;
	}
	public int getHabilidadeMagica() {
		return habilidadeMagica;
	}
	public void setHabilidadeMagica(int habilidadeMagica) {
		this.habilidadeMagica = habilidadeMagica;
	}
	public int getEsquiva() {
		return esquiva;
	}
	public void setEsquiva(int esquiva) {
		this.esquiva = esquiva;
	}
	public Random getRandom() {
		return random;
	}
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public int ataque() {
		if(Alive()) {
			System.out.println(nome + " lança uma magia de " + força*habilidadeMagica + " de dano");
			return força*habilidadeMagica;
		}
		else {
			System.err.println("Personagem " + nome + " não está vivo");
			return 0;
		}
		
	}
	@Override
	public Boolean dano(int dano)
		 {	if(Alive()) {
			 int numero = random.nextInt(hpInicial) + (1);
			 if(numero > esquiva) {
				 hp-=dano;
				 System.out.println(nome + " recebe " + dano + " de dano" );
				 resetHP();
				 return true;
			 }
			 else {
				 System.out.println(nome + " se esquivou do ataque!!!");
				 return false;
			 }
		 	}
		 else {
			 System.err.println(" Personagem já está morto");
			 return false;
		}
	}
	@Override
	public void levelUp() {
		habilidadeMagica += random.nextInt(10) + (1);
		esquiva += random.nextInt(8) + (1);
		nivel++;
		this.hp = 10;
		hp += random.nextInt(10) + 1;
		força += random.nextInt(10) + (1);
		this.hpInicial = hp;
		System.out.println("Parabéns " + nome + " Level UP!!!!");
	}
	@Override
	public void Detalhes() {
	System.out.println("Detalhes do mago: ");
	super.Detalhes();
	System.out.println("Habilidade Mágica: "
	+ this.habilidadeMagica
	+ "\nEsquiva: "+this.esquiva);
	}
	@Override
	public void detalhesCombate() {
		System.out.println(" --------- Mago " + nome + " --------- ");
		super.Detalhes();
		System.out.println("Habilidade Mágica: "
		+ this.habilidadeMagica 
		+", Esquiva: "+this.esquiva + ".");
}
}