import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Random r = new Random();

		try (Scanner s = new Scanner(System.in)) {
			int jogador;
			int resultado = 0;

			for (int i = 0; i < 3; i++) {
				// se alguém ganhar duas rodadas acaba o jogo (melhor de 3)
				if (resultado > 1 || resultado < -1) continue;

				System.out.println("[1] Pedra  -  [2] Papel   -   [3] Tesoura");
				System.out.print("Jogador 1, digite sua opção: ");
				jogador = Integer.parseInt(s.nextLine());

				int comp = r.nextInt(2) + 1;
				System.out.println("\nJogador: " + defineJogada(jogador));
				System.out.println("Comp: " + defineJogada(comp) + "\n");

				int comparacao = comparaJogadas(jogador, comp);

				// empate não faz nada
				if (comparacao == 0) {
					System.out.println("Rodada empatou!\n");
					continue;
				}

				// se jogador ganhou soma 1 no resultado, se perdeu subtrai 1
				resultado = comparacao > 0 ? resultado + 1 : resultado - 1;

				String parcial = comparacao > 0 ? "Jogador 1" : "Comp";
				System.out.println(parcial + " ganhou a rodada!\n");
			}

			// se o resultado for 0, deu empate
			if (resultado == 0) {
				System.out.println("Empate!");
				System.exit(0);
			}

			// se o resultado for > 0, jogador ganha, senão o comp ganha:
			String vencedor = resultado > 0 ? "Jogador 1" : "Comp";
			System.out.println(vencedor + " venceu!");
		} catch (Exception e) {
			System.out.println("Deu de jogo não enche o saco o merda!");
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static int comparaJogadas(int jogada1, int jogada2) {
		// se forem iguais retorna 0; se continuar, sabemos que as duas jogadas são diferentes
		if (jogada1 == jogada2) return 0;

		switch (jogada1) {
			// jogada1 = pedra; se jogada2 = papel, jogada2 ganha; senão, jogada2 = tesoura e jogada1 ganha
			case 1: return jogada2 == 2 ? -1 : 1;

			// jogada1 = papel; se jogada2 = tesoura, jogada2 ganha; senão, jogada2 = pedra e jogada1 ganha
			case 2: return jogada2 == 3 ? -1 : 1;

			// jogada1 = tesoura; se jogada2 = pedra, jogada2 ganha; senão, jogada2 = papel e jogada1 ganha
			case 3: return jogada2 == 1 ? -1 : 1;

			default: throw new IllegalArgumentException("Opção inválida!");
		}
	}

	private static String defineJogada(int jogada) {
		switch (jogada) {
			case 1: return "Pedra";

			case 2: return "Papel";

			case 3: return "Tesoura";

			default: throw new IllegalArgumentException("Jogo bugou, desculpa aê!");
		}
	}
}
