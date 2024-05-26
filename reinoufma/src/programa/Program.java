package programa;

import java.util.ArrayList;
import java.util.Random;

import entities.Arqueiro;
import entities.Guerreiro;
import entities.Mago;
import entities.Personagem;

public class Program {
	public static leituraJava input = new leituraJava();
	public static boolean realizarCombate(Personagem personagem1, Personagem personagem2, ArrayList<Personagem> personagens) {
		System.out.println("⚔︎⚔︎⚔︎⚔︎ BATALHA INICIADA ENTRE " + personagem1.getNome() + " e " + personagem2.getNome() + " ⚔︎⚔︎⚔︎⚔︎"); 
    	System.out.println("⚔︎⚔︎⚔︎ BATALHA ⚔︎⚔︎⚔︎");
        if (personagem1.getNivel() > personagem2.getNivel()) {
            personagem2.dano(personagem1.ataque());
        } else if (personagem1.getNivel() < personagem2.getNivel()) {
            personagem1.dano(personagem2.ataque());
        } else {
            Random random = new Random();
            int sorteio = random.nextInt(2) + 1;
            if (sorteio == 1) {
                personagem2.dano(personagem1.ataque());
            } else {
                personagem1.dano(personagem2.ataque());
            }
        }
        System.out.println("⚔︎⚔︎⚔︎⚔︎⚔︎⚔︎⚔︎⚔︎⚔︎⚔︎⚔︎⚔︎");
        System.out.println("⚔︎⚔︎⚔︎⚔︎ INFORMAÇÕES DOS COMBATENTES PÓS BATALHA ⚔︎⚔︎⚔︎⚔︎");
        consultaNomeCombate(personagem1.getNome(), personagens);
        consultaNomeCombate(personagem2.getNome(), personagens);
        if(personagem1.getHp() == 0) {
        	removeNome(personagem1.getNome(), personagens);
        	personagem2.levelUp();
        	System.out.println("Digite qualquer coisa para ver as novas características de " + personagem2.getNome() + " ou '0' para pular");
        	String opcao = leituraJava.lerString();
        	if(!opcao.equals("0")) {
        		consultaNomeCombate(personagem2.getNome(), personagens);
        	}
        }
        if(personagem2.getHp() == 0) {
        	removeNome(personagem2.getNome(), personagens);
        	personagem1.levelUp();
        	System.out.println("Digite qualquer coisa para ver as novas características de " + personagem1.getNome() + " ou '0' para pular");
        	String opcao = leituraJava.lerString();
        	if(!opcao.equals("0")) {
        		consultaNomeCombate(personagem1.getNome(), personagens);
        	}
        }
        return true;
    }
	public static void combate(String personagem1, String personagem2, ArrayList<Personagem> personagens) {
		        int aux = 0;
		        Personagem personagemAux1 = null;
		        Personagem personagemAux2 = null;
		        for (Personagem x : personagens) {
		            if (personagem1.equals(x.getNome())) {
		                aux++;
		                personagemAux1 = x;
		            }
		        }
		        for (Personagem y : personagens) {
		            if (personagem2.equals(y.getNome())) {
		                aux++;
		                personagemAux2 = y;
		            }
		        }
		        if (aux == 2) {
		        	realizarCombate(personagemAux1, personagemAux2, personagens);
		        }
		        else {
		        	System.err.println("Ataque não realizado!!!");
		        	
		        }
		        	
		    }
	public static boolean verificaNome(String nome, ArrayList<Personagem> personagens) {
		for(Personagem x: personagens) {
			if(nome.equals(x.getNome())) {
				System.out.println("Um personagem com esse nome já está cadrastrado");
				System.out.println("Faça a operação novamente!!!");
				return false;
			}
		}
		return true;
	}
	public static boolean removeNome(String nome, ArrayList<Personagem> personagens) {
		for(Personagem x: personagens) {
			if(nome.equals(x.getNome())) {
				personagens.remove(x);
				System.out.println("personagem " + nome + " removido com sucesso da arena!!");
				return true;
			}
		}
		System.out.println("Remoção não realizada, personagem não existe!!!");
		return false;
	}
	public static boolean consultaNome(String nome, ArrayList<Personagem> personagens) {
		for(Personagem x: personagens) {
			if(nome.equals(x.getNome())) {
				System.out.println("Informações");
				x.Detalhes();
				return true;
			}
		}
		System.out.println("Personagem não existe!!!");
		return false;
	}
	public static void consultaNomeCombate(String nome, ArrayList<Personagem> personagens) {
			for(Personagem x: personagens) {
				if(nome.equals(x.getNome())) {
					x.detalhesCombate();
				}
			}
	}
	public static void addPersonagem(ArrayList<Personagem> personagens) {
		System.out.println("⚔︎⚔︎⚔︎⚔︎ Digite o nome do seu personagem ⚔︎⚔︎⚔︎⚔︎");
		String nome = leituraJava.lerString();
		System.out.println("⚔︎⚔︎⚔︎⚔︎ Escolha o tipo do seu personagem ⚔︎⚔︎⚔︎⚔︎");
		System.out.println(" 1 - Mago ");
		System.out.println(" 2 - Guerreiro ");
		System.out.println(" 3 - Arqueiro ");
		int tipo = leituraJava.lerInteiro();
		leituraJava.lerString();
		switch(tipo) {
		case 1:
			if(!verificaNome(nome, personagens)) {
				addPersonagem(personagens);
				leituraJava.lerString();
			}
			else {
				personagens.add(new Mago(nome));
				System.out.println("Personagem adicionado com sucesso");
				System.out.println("Digite qualquer coisa para voltar");
				leituraJava.lerString();
				telaInicial(personagens);
			}
			break;
		case 2:
			if(!verificaNome(nome, personagens)) {
				addPersonagem(personagens);
				leituraJava.lerString();
			}
			else {
				personagens.add(new Guerreiro(nome));
				System.out.println("Personagem adicionado com sucesso");
				System.out.println("Digite qualquer coisa para voltar");
				leituraJava.lerString();
				telaInicial(personagens);
				}
			break;
		case 3:
			if(!verificaNome(nome, personagens)) {
				addPersonagem(personagens);
				leituraJava.lerString();
			}
			else {
				personagens.add(new Arqueiro(nome));
				System.out.println("Personagem adicionado com sucesso");
				System.out.println("Digite qualquer coisa para voltar");
				leituraJava.lerString();
				telaInicial(personagens);
			}
			break;
		default:
			System.err.println("Opção inválida!!!");
			addPersonagem(personagens);
			break;
		}
	}
	public static void removePersonagem(ArrayList<Personagem> personagens) {
		System.out.println("⚔︎⚔︎⚔︎⚔︎ Digite o nome do personagem a ser removido do campo de batalha ⚔︎⚔︎⚔︎⚔︎");
		String nome = leituraJava.lerString();
		removeNome(nome, personagens);
		telaInicial(personagens);
	}
	public static void arenadeCombate(ArrayList<Personagem> personagens) {
		while(true) {
			System.out.println("⚔︎⚔︎⚔︎ ARE YOU READY???? ⚔︎⚔︎⚔︎");
			System.out.println("⚔︎⚔︎⚔︎ Você entrou na arena de combate ⚔︎⚔︎⚔︎");
			System.out.println("⚔︎⚔︎⚔︎ Digite 0 para sair, ou  qualquer coisa para continuar ⚔︎⚔︎⚔︎");
			String opcao = leituraJava.lerString();
			if(opcao.equals("0")) {
				telaInicial(personagens);
				break;
			}
			System.out.println("Digite o nome do primeiro combatente");
			String nome1 = leituraJava.lerString();
			System.out.println("Digite o nome do segundo combatente");
			String nome2 = leituraJava.lerString();
			combate(nome1, nome2, personagens);
			arenadeCombate(personagens);
		}
	}
	public static void consultarPersonagens(ArrayList<Personagem> personagens) {
		System.out.println("⚔︎⚔︎⚔︎⚔︎ Digite o nome do personagem a ser consultado ⚔︎⚔︎⚔︎⚔︎");
		String nome = leituraJava.lerString();
		consultaNome(nome, personagens);
		System.out.println("Digite qualquer coisa para voltar");
		leituraJava.lerString();
		telaInicial(personagens);
	}
	public static void listarPersonagens(ArrayList<Personagem> personagens) {
		System.out.println("⚔︎⚔︎⚔︎⚔︎ Personagens na arena ⚔︎⚔︎⚔︎⚔︎");
		System.out.println("Personagens ativos : " + personagens.size());
		for(Personagem x: personagens) {
			System.out.println("Nome: " + x.getNome());
			System.out.println("Classe: " + x.getClass().getSimpleName());
			System.out.println("Level: " + x.getNivel());
			System.out.println(" --------- ");
		}
		System.err.println("Digite qualquer coisa para voltar");
		leituraJava.lerString();
		telaInicial(personagens);
	}
	public static void telaInicial(ArrayList<Personagem> personagens ) {
		while (true) {
			System.out.println(" ⚔︎ Bem vindo ao reino UFMA ⚔︎");
			System.out.println(" ESCOLHA UMA OPÇÃO");
			System.out.println(" 1 - Adicionar personagens a arena ");
			System.out.println(" 2 - Remover personagens da arena ");
			System.out.println(" 3 - Arena de combate ");
			System.out.println(" 4 - Consultar informações de um personagem");
			System.out.println(" 5 - Visualizar arena ");
			System.out.println(" 6 - Sair ");
			int opcao = leituraJava.lerInteiro();
			leituraJava.lerString();
			switch(opcao) {
			case 1:
				addPersonagem(personagens);
				break;
			case 2:
				removePersonagem(personagens);
				break;
			case 3:
				arenadeCombate(personagens);
				break;
			case 4:
				consultarPersonagens(personagens);
				break;
			case 5:
				listarPersonagens(personagens);
				break;
			case 6:
				System.out.println("Saindo...");
				System.exit(0);
				break;
			default:
				System.err.println("Opção inválida");
				telaInicial(personagens);
				break;
		}
		}
	}
	public static void main(String[] args) {
		ArrayList<Personagem> personagens = new ArrayList<>();
		Personagem Pedro = new Mago("Pedro");  // CONCEITO DE POLIMORFISMO E DOWNCASTING
		Personagem Sarah = new Arqueiro("Sarah");
		Personagem Erick = new Guerreiro("Erick");
		Personagem Boss  = new Mago("Boss", 100, 100, 100);
		personagens.add(Pedro);
		personagens.add(Sarah);
		personagens.add(Erick);
		personagens.add(Boss);
		System.err.println("⚔︎⚔︎⚔︎⚔︎ ARE YOU READY? ⚔︎⚔︎⚔︎⚔︎");
		telaInicial(personagens);
	}
}